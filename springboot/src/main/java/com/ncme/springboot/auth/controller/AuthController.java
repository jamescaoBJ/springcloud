/**
 * TokenDemo.java
 * com.ncme.springboot.auth.controller
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月27日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncme.springboot.auth.configuration.properties.JwtProperties;
import com.ncme.springboot.auth.encoder.LYJPsswordEncoder;
import com.ncme.springboot.auth.oauth2.JwtUserDetails;
import com.ncme.springboot.auth.util.JwtToken;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.exception.MyException;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.SystemAccount;
import com.ncme.springboot.model.SystemLoginLimit;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.SystemUserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * ClassName:TokenDemo
 * Function: TODO token 登录，刷新，控制失效等demo
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月27日	上午10:23:45
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/auth") //在安全控制中默认是不认证/auth/** 访问的
public class AuthController extends Controller {
	/**由于注册功能和二期估计密码加密等诸多信息不匹配，所有暂时不写注册等一些关联性强的操作，后期融合的时候再根据实际情况编写例子，或者直接开工写代码了。。*/
    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;
    
    
    @Autowired
    private JwtProperties jwtProperties;
    
	@Autowired
	SystemUserService systemUserService;
    
    @RequestMapping(value ="/login")
	
	public  RtnBody login(Device device /**区分设备类型*/){
    	
		String username = getPara("username");
		String password = getPara("password");
		String reLogin = getPara("reLogin");
		String openid = getPara("openid");
		String un = "";
		String pw = "";
		if (StrKit.notBlank(openid) && StrKit.isBlank(username) && StrKit.isBlank(password)) {
			SystemAccount account = systemUserService.getSystemAccountByWeiXinId(openid);
			if (account != null) {
				username = account.getAccountName();
				password = account.getAccountPassword();
				un = account.getAccountName();
				pw = account.getAccountPassword();
			} else {
				return getRtnBody().code(BusinessConst.NOT_BIND_WECHAT).message("该微信号没有绑定NCME账号.");
			}
			
		} 
		
		SystemUser user = systemUserService.getSystemUserByAccountName(username);// 获取账号对应的用户信息
		
		if(user == null){
			
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("账号错误或者不存在.");

		}
		//查询绑定时ncme账号是否已经绑定过
		if (StrKit.notBlank(openid) && StrKit.isBlank(un) && StrKit.isBlank(pw)) {
			if (StrKit.notBlank(user.getOpenid())) {
				return getRtnBody().code(BusinessConst.ALREADY_BIND_WECHAT).message("该账号已绑定过其他微信号.");
			}
		}
		long  now = System.currentTimeMillis(); //系统当前时间
    	Long  last = user.getLoginErrorLastTime();// 最后一次密码错误时间
    	
		SystemLoginLimit limiter = systemUserService.getLoginLimter();

		//如果不是账号管理修改用户信息重新登录或者直接用openid查询用户信息时将密码进行加密
		if (StrKit.isBlank(pw) && !"1".equals(reLogin) ) {
			LYJPsswordEncoder encoder = new LYJPsswordEncoder();
			password = encoder.encode(password);
		}
		UsernamePasswordAuthenticationToken up_token = new UsernamePasswordAuthenticationToken(username, password);
		 Authentication authentication;
		try{
			authentication = authenticationManager.authenticate(up_token);
			
			//登录锁定流程
			if(authentication.isAuthenticated()){
				
				//1.已锁定，但是超过限制时间可以重置限制
		       	if( last != 0 && ((now - last) > limiter.getLockTime()*60*60*1000)){
	        		//重置
					user.setLoginErrorFirstTime(0L);
					user.setLoginErrorLastTime(0L);
					user.setLoginErrorNum(0);
	        	}else if(last != 0 && ((now - last) <=limiter.getLockTime()*60*60*1000)){
	        		
	        		return getRtnBody().code(BusinessConst.ACCOUNT_LOCK).message("用户被锁定，请"+limiter.getLockTime()+"小时后再登录！");
	        	}else if(last == 0){
	        		//重置
					user.setLoginErrorFirstTime(0L);
					user.setLoginErrorLastTime(0L);
					user.setLoginErrorNum(0);
	        	}
		       	systemUserService.updateLoginErrors(user);
		       	//TODO 将openid与NCME用户关联
		       	if (StrKit.notBlank(openid) && StrKit.isBlank(un) && StrKit.isBlank(pw)) {
		       		systemUserService.updateOpenIdByUserId(openid, user.getId());
		       	}
			}
			
			
			
			
		}catch(MyException e){//catch

				// 密码无效,错误次数限制规则start.....
		
	        	
	        	Long first = user.getLoginErrorFirstTime(); //第一次密码错误时间
    			Integer loginErrorNum = user.getLoginErrorNum(); // 密码错误次数
    			//1 未错误过  2 重置过
    			
    			if(first == 0 && loginErrorNum ==0){
    				user.setLoginErrorFirstTime(System.currentTimeMillis());
    				user.setLoginErrorNum(loginErrorNum+1);
    				if(limiter.getLoginNum()==1){
    					user.setLoginErrorLastTime(System.currentTimeMillis());
    				}
    			}else{
    				if((now - first) > limiter.getLockTime()*60*60*1000){//假设只有一次机会输入密码错误，那么first和last将会很近似，所以不做特殊处理，有误差，但可忽略
    	        		//重置
    					user.setLoginErrorFirstTime(0L);
    					user.setLoginErrorLastTime(0L);
        				user.setLoginErrorNum(0);
        				systemUserService.updateLoginErrors(user);
    					user.setLoginErrorFirstTime(System.currentTimeMillis());
        				user.setLoginErrorNum(1);
        				if(limiter.getLoginNum()==1){
        					user.setLoginErrorLastTime(System.currentTimeMillis());
        				}
    				}else{
    					if(loginErrorNum == limiter.getLoginNum()){
    						
    						return getRtnBody().code(BusinessConst.ACCOUNT_LOCK).message("用户被锁定，请"+limiter.getLockTime()+"小时后再登录！");
 		    	         
    					}else{
    						//最后一次登录错误
    						if(loginErrorNum == (limiter.getLoginNum()-1)){
    							user.setLoginErrorLastTime(now);
    						}
    						user.setLoginErrorNum(loginErrorNum+1);
    					}
    					
    			
    				
    				
    				
    			}
				
			}
    			systemUserService.updateLoginErrors(user);
    			if (limiter.getLoginNum()-user.getLoginErrorNum()==0) {
    				return getRtnBody().code(BusinessConst.ACCOUNT_LOCK).message( "密码错误，登录密码出错已达上限！");
    			} else {
    				return getRtnBody().code(BusinessConst.PASSWORD_INVALID).message( "密码错误，您还有"+(limiter.getLoginNum()-user.getLoginErrorNum())+"次机会！");
    			}

			
		}// catch

		// token 生成
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		  

        Claims claims = Jwts.claims();
        claims.put(jwtProperties.getAuthPrefix(),authentication.getAuthorities());
        String token = JwtToken.creatToken((String)authentication.getDetails(), (String)authentication.getPrincipal(), claims);
        Record record = new Record();
        record.put(jwtProperties.getTokenPrefix(), token);
    	record.put("userId", user.getId()); 
    	record.put("username", username);
        return getRtnBody().data(record).code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取Token成功！");
		 
         
         
      

	}
    
   
	/**
	 * refresh:刷新token
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
    @RequestMapping(value ="/refresh")
	public RtnBody  refresh(){
		
		String token = request.getHeader(jwtProperties.getHeader()).substring(7);
		Claims claims ;
		try{
			claims = JwtToken.parserTokenClaims(token);
	
			
		}catch(MyException e){
			
			return getRtnBody().code(HttpServletResponse.SC_UNAUTHORIZED).message(e.getMessage());
		}
		String sub = claims.getSubject();
		JwtUserDetails userDetails = (JwtUserDetails) userDetailsService.loadUserByUsername(sub);
		Record record = new Record();
		if(userDetails != null){
			
			String refreshToken = JwtToken.refreshToken(claims);
			record.put("refreshToken", refreshToken);
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).data(record).message("refresh successful!");
			
		}else{
			
			record.put("refreshToken", token);
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).data(record).message("refresh fail!");

			
		}
		
		
		
	}
    

	

}
