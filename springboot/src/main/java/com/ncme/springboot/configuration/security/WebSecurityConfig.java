/**
 * WebSecurityConfig.java
 * com.ncme.springboot.configuration.security
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月24日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ncme.springboot.auth.authentication.LYJAuthenticationProvider;
import com.ncme.springboot.auth.configuration.properties.JwtProperties;
import com.ncme.springboot.auth.decision.LYJFilterSecurityInterceptor;
import com.ncme.springboot.auth.filter.JwtAuthenticationTokenFilter;


/**
 * ClassName:WebSecurityConfig
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月24日	下午4:36:41
 *
 * @see 	 
 *  
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled  = true,prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	  @Autowired
	  @Qualifier("jwtUserDetailsService")
	  private UserDetailsService userDetailsService;
	  
	  @Autowired
	  private LYJAuthenticationProvider provider;
	  
	  @Autowired
	  
	  private LYJFilterSecurityInterceptor lYJFilterSecurityInterceptor;
	  @Autowired
	  
	  private JwtProperties jwtProperties;
	  
	 

	/**
	 * 重写  http 权限访问策略
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	   http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()//后续需配置使用自己的默认登录页等基本设置
	   .authorizeRequests().antMatchers(
			   HttpMethod.GET,
			   "/",
               "/*.html",
               "/favicon.ico",
               "/**/*.html",
               "/**/*.css",
               "/**/*.js").permitAll()
	    // 对于获取token的rest api要允许匿名访问
       .antMatchers(jwtProperties.getPath()).permitAll()
       
       .anyRequest().authenticated()
       /*.and().formLogin().loginPage("/login.html")*/;
	   //禁止浏览器缓存头信息
	   http.headers().cacheControl().disable();
	   http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);//jwt token filter 
	   http.addFilterBefore(lYJFilterSecurityInterceptor, FilterSecurityInterceptor.class);//auth filter
	   
	   
	   
		
	}
	
	
//	@Autowired
//    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                // 设置UserDetailsService
//                .userDetailsService(this.userDetailsService)
//                // 使用md5进行密码的hash
//                .passwordEncoder(passwordEncoder())
//                ;
//    }
//	
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //将验证过程交给系统验证提供者
        auth.authenticationProvider(provider);
    }
	
    
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//    	// 装载BCrypt密码编码器
////        return new BCryptPasswordEncoder();
//    	return new LYJPsswordEncoder();//原系统维持一致加密算法
//    }
	  
	  
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();// add token filter.
    }


	  
	  
	  

}
