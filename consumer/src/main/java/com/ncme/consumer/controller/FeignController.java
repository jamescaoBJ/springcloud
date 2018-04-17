/**
 * FeignController.java
 * com.ncme.consumer.controller
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月20日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ncme.consumer.service.api.TeacherService;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.model.ExpertInfo;
import com.ncme.springboot.model.SystemAccount;

/**
 * ClassName:FeignController
 * Function: TODO ADD feign 方式调用远程服务
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月20日	上午9:27:26
 *
 * @see 	 
 *  
 */

@RestController
@RequestMapping("/feign")
public class FeignController extends Controller {
	
	
	@Autowired
	TeacherService teacherService; //feign方式远程服务调用接口
	
	@RequestMapping("/page-simple")
	public PageInfo<ExpertInfo> getTeachersByPageSimple(String pageCurrent,String pageSize ){
		
		return teacherService.getTeachersByPageSimple(pageCurrent, pageSize);
	}
	
	@RequestMapping(value="/getRtnBody")
	public RtnBody getRtnBody(SystemAccount user){
		
		System.out.println(user.getAccountName()+"************************************");
		return teacherService.getRtnBody(user);
	}
	
	
}
