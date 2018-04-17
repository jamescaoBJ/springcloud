/**
 * TeacherService.java
 * com.ncme.consumer.service.api
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月20日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.consumer.service.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.model.ExpertInfo;
import com.ncme.springboot.model.SystemAccount;


/**
 * ClassName:TeacherService
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月20日	上午9:51:42
 *
 * @see 	 
 *  
 */
@FeignClient(value = "springboot")//服务名,必须与eureka注册中心所需Application名保持一致
public interface TeacherService {
	
	/**只列举出来其中几个接口，其它的不再赘述*/
	@RequestMapping(value="/teacher/page-simple",consumes="application/x-www-form-urlencoded",produces="application/json")
	public PageInfo<ExpertInfo> getTeachersByPageSimple( @RequestParam("pageCurrent") String pageCurrent, @RequestParam("pageSize") String pageSize );
	
	@RequestMapping(value="/teacher/getRtnBody",consumes="application/json",produces="application/json",method=RequestMethod.POST)
	public RtnBody getRtnBody( @RequestBody SystemAccount user);
	
}
