/**
 * JwtUserDetailsServiceImpl.java
 * com.wjw.util.oauth2
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月24日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.oauth2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ncme.springboot.auth.decision.LYJGrantedAuthority;
import com.ncme.springboot.mapper.SystemAccountMapper;
import com.ncme.springboot.model.SystemAccount;

/**
 * ClassName:JwtUserDetailsServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月24日	下午4:22:42
 *
 * @see 	 
 *  
 */
@Service("jwtUserDetailsService")
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	
	SystemAccountMapper  systemAccountMapper; // 账号mapper
//	
//	@Autowired
//	
//	SystemRoleMapper systemRole;
	
//	@Autowired
//	
//	SystemMenuMapper systemMenuMapper;
	

	

	/**
	 * 获取账号信息
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SystemAccount account = systemAccountMapper.selectByUsername(username);
		
		
		if(account == null){
			return null;
			
		}else{
			
//			List<SystemRole> sysRoles =  systemRole.findRolesByUserId(account.getAccountId()); 后续根据业务逻辑实现，暂时没实现
//			List<SystemMenu> SystemMenus =  null; 后续根据业务逻辑实现，暂时没实现
			
//			Collection<GrantedAuthority>  authorities = generateAuthorities(SystemMenus);
//			return JwtUserDetailsFactory.JwtUserDetails(account,authorities);
			
			
			/***********************************模拟数据,测试用,后期需要填充真实数据库url权限数据******************************************/
			
//			SystemMenu menu = new SystemMenu();
			
//			menu.setUrl("/teacher");
			List<String> list = new ArrayList<>();
			
			list.add("/teacher");
			list.add("/teacher/page");
			/***********************************模拟数据,测试用,后期需要填充真实数据库url权限数据******************************************/
			
			Collection<GrantedAuthority>  authorities = generateAuthorities(list);
			return JwtUserDetailsFactory.JwtUserDetails(account,authorities);
		}

	}

	
	private Collection<GrantedAuthority> generateAuthorities(Collection<String> privileges) {
		List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>(
				privileges.size());
		for (String privilege : privileges) {
			GrantedAuthority authority = new LYJGrantedAuthority(
					privilege);
			auth.add(authority);
		}
		return auth;
	}
}
