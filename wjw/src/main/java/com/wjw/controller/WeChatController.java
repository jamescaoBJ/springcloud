package com.wjw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.SystemUserService;
import com.wjw.util.SignUtil;
import com.wjw.util.SystemUserUtil;
import com.wjw.util.WeixinUtil;
import com.wjw.vo.SNSUserInfo;
import com.wjw.vo.WeixinOauth2Token;

/**
 * ClassName:WeChatController
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2018年1月22日	下午4:39:54
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/weChat")
public class WeChatController extends Controller {

	@Autowired
	SystemUserService systemUserSevice; 
	/**
	 * checkName:验证微信后台配置的服务器地址有效性
	 * 接收并校验四个请求参数
	 *
	 * @param  @param signature 微信加密签名
	 * @param  @param timestamp 时间戳
	 * @param  @param nonce 随机串
	 * @param  @param echostr 随机字符串
	 * @param  @return  echostr  
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/check")
	public void checkName(String signature, String timestamp, String nonce, String echostr, HttpServletResponse response){
		log.info("微信-开始校验签名");
	    log.info("收到来自微信的 echostr 字符串:{}", echostr);
	    PrintWriter out = null ;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	    // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
	    if (SignUtil.checkSignature(signature, timestamp, nonce)) {
	    	log.info("微信-签名校验通过");
	        //如果检验成功原样返回echostr，微信服务器接收到此输出，才会确认检验完成。
	        log.info("回复给微信的 echostr 字符串:{}", echostr);
	        out.print(echostr);  
	    } else {
	    	log.error("微信-签名校验失败");
	    }
        out.close();  
        out = null;
	}
	
	/**
	 * getSignature:
	 * 获取签名
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/getSignature")
	public RtnBody getSignature(String url){
		Map<String, String> ret = new HashMap<String, String>();
		RtnBody rtn = new RtnBody();
		 //1、获取AccessToken  
	    String accessToken = SignUtil.getAccessToken();  
	      
	    //2、获取Ticket  
	    String jsapi_ticket = SignUtil.getTicket(accessToken);  
	    //3、时间戳和随机字符串
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";
        if (url.contains("localhost:8080")) {
        	url = url.replace("localhost:8080", "dev.ncme.org.cn/ncmeapp");
        }
        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;
        log.info("string1:"+string1);
        try{
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        log.info("签名:"+signature);
	    return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(ret);
	}
	
	private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
	
	private String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
    
    /**
     * oAuth:
     * 微信授权后获取用户信息
     * @param  @return    
     * @return RtnBody    
     * @throws 
     * @since  　version 1.0
    */
    @RequestMapping("/oAuth")
    public RtnBody oAuth(String code, String state){
    	RtnBody rtn = new RtnBody();
    	// 用户同意授权
        if (StrKit.notBlank(code)) {
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = WeixinUtil.getOauth2AccessToken(SignUtil.APPID, SignUtil.APPSECRET, code);
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();
            if (StrKit.notBlank(openId)) {
            	 // 获取用户信息
                SNSUserInfo snsUserInfo = WeixinUtil.getSNSUserInfo(accessToken, openId);
                // 设置要传递的参数
                return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(snsUserInfo);
            }else {
            	return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("openId为空");
            }
        } else {
        	return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("code为空");
        }
    }
    
    /**
     * getOAuthUrl:
     * 获取微信授权url
     * @param  @param url
     * @param  @param scope
     * @param  @return    
     * @return RtnBody    
     * @throws UnsupportedEncodingException 
     * @throws 
     * @since  　version 1.0
    */
    @RequestMapping("/getOAuthUrl")
    public RtnBody getOAuthUrl(String url,String scope) throws UnsupportedEncodingException{
    	RtnBody rtn = new RtnBody();
    	scope = StrKit.isBlank(scope)?"snsapi_userinfo":scope;
    	url = URLEncoder.encode(url,"UTF-8");
    	String oAuthUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SignUtil.APPID+"&redirect_uri="+url+
    			"&response_type=code&scope="+scope+"&state=STATE#wechat_redirect";
    	Record r = new Record();
    	r.put("oAuthUrl", oAuthUrl);
    	return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success.").data(r);
    }
    
    
    /**
     * removeWeChatBind:
     * 解除微信绑定
     * @param  @return    
     * @return RtnBody    
     * @throws 
     * @since  　version 1.0
    */
    @RequestMapping("/removeWeChatBind")
    public RtnBody removeWeChatBind(){
    	SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		try {
			int flag = systemUserSevice.updateOpenIdByUserId(null, user.getId());
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("解除绑定成功！");
		} catch (Exception e) {
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("解除绑定异常.");
		}
    }
}
