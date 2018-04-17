package com.wjw.util;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncme.springboot.auth.util.Token;
import com.ncme.springboot.model.SystemAccount;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.SystemUserService;

@Component
public class SystemUserUtil {

	@Autowired
	private SystemUserService systemUserService;
	private static SystemUserUtil systemUserUtil;
	
	public void setSystemUserService(SystemUserService systemUserService) {
		this.systemUserService = systemUserService;
	}
	
	@PostConstruct  
    public void init() {  
		systemUserUtil = this;  
		systemUserUtil.systemUserService = this.systemUserService;  
  
    }  
	
	/**
	 * getLoginUser:
	 * 获取登录用户信息
	 * @param  @param request
	 * @param  @return    
	 * @return SystemUser    
	 * @throws 
	 * @since  　version 1.0
	*/
	public static SystemUser getLoginUser(HttpServletRequest request) {
		SystemUser user = null;
		SystemAccount account = null;
		try  {
			account = Token.USER(request, SystemAccount.class);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		if (account != null) {
			user = systemUserUtil.systemUserService.getSystemUserByAccountName(account.getAccountName());
			user.setAccountName(account.getAccountName());
		}
		 
		return user;
	}
}
