/**
 * PostController.java
 * com.wjw.controller.common
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月8日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.StrKit;
import com.wjw.service.PostService;

/**
 * ClassName:PostController
 * Function: TODO 职位相关信息控制器
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月8日	下午4:12:53
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/post")
public class PostController extends Controller {
	
	@Autowired
	PostService postService; // 职位服务
	/**
	 * getPostType:获取职位类型
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id 职务类型id
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/getPostType")
	public RtnBody getPostType(Integer id){
		
		List<Record> list =  postService.getPostType(id);
		
		return getRtnBody().data(list).code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功。");
		
		
	}
	
	

	/**
	 * getPost: 获取职务
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id ：职务类型id
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/getPost")
	public RtnBody getPost(String id){
		
		if(StrKit.isBlank(id)){// 参数异常
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("id 不能为空！");
		}
		List<Record> list =  postService.getPost(id);
		
		return getRtnBody().data(list).code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功。");//返回list数据，根据文档要求。
		
		
	}

}
