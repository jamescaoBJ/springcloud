/**
 * JwtUserDetails.java
 * com.ncme.springboot.footstone.oauth2
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月24日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.oauth2;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * ClassName:JwtUserDetails
 * Function: TODO ADD 定制自己业务系统的spring security UserDetails
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月24日	下午3:07:22
 *
 * @see 	 
 *  
 */

public class JwtUserDetails implements UserDetails {

	/**
	 * serialVersionUID:TODO 5153863216235499483L
	 *
	 * @since version 1.0
	 */
	
	private static final long serialVersionUID = 5153863216235499483L;
	
	private final String id;
    private final String username;
    private final String password;//禁止序列化密码字段
    private final Collection<? extends GrantedAuthority> authorities;//权限集合

	
	/**
	 * getJwtUserDetails:编写获取此类方法，禁止new操作
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id
	 * @param  @param username
	 * @param  @param password
	 * @param  @param authorities
	 * @param  @return    
	 * @return JwtUserDetails    
	 * @throws 
	 * @since  　version 1.0
	*/
	public static JwtUserDetails getJwtUserDetails(String id,String username,String password, Collection<? extends GrantedAuthority> authorities){
		
		return new JwtUserDetails(id, username, password, authorities);
	}
	/**
	 * Creates a new instance of JwtUserDetails.
	 *
	 * @param id
	 * @param userName
	 * @param password
	 * @param authorities
	 */
	private JwtUserDetails(String id,String username,String password, Collection<? extends GrantedAuthority> authorities){
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	
	
	
	

	/**
	 * id:主键
	 *
	 * @return  the id
	 * @since    Ver 1.0
	*/
	
	public String getId() {
		return id;
	}



	/**
	 * 返回用户的角色列表
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		// TODO Auto-generated method stub
		return authorities;
		
	}

	/**
	 * 账户密码:禁用序列化
	 */
	@JSONField(serialize=false)
	@Override
	public String getPassword() {
		
		// TODO Auto-generated method stub
		return password;
		
	}

	/**
	 * 用户账号
	 */
	@Override
	public String getUsername() {
		
		// TODO Auto-generated method stub
		return username;
		
	}

	/**
	 * 账号是否未过期
	 */
	@Override
	public boolean isAccountNonExpired() {
		
		// TODO Auto-generated method stub
		return false;
		
	}

	/**
	 * 账号是否锁定
	 */
	@Override
	public boolean isAccountNonLocked() {
		
		// TODO Auto-generated method stub
		return false;
		
	}

	/**
	 * 密码是否未过期
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		
		// TODO Auto-generated method stub
		return false;
		
	}

	/**
	 * 账号是否可用
	 */
	@Override
	public boolean isEnabled() {
		
		// TODO Auto-generated method stub
		return false;
		
	}

}
