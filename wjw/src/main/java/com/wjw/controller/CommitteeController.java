/**
 * MasterController.java
 * com.wjw.controller
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年9月30日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.auth.util.Token;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.request.LayaMap;
import com.ncme.springboot.footstone.request.Page;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.ExpertInfo;
import com.ncme.springboot.model.SystemAccount;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.TeacherService;
import com.wjw.util.SystemUserUtil;

/**
 * 
 * ClassName:CommitteeController
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   juniorice
 * @version  
 * @since    version 1.0
 * @Date	 2018年2月7日	下午4:40:10
 *
 * @see 	 
 *
 */
@RestController
@RequestMapping("/committee")
public class CommitteeController extends Controller{
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(value="/list")
	public RtnBody getCommitteeList(String userId, String pageNum){
		RtnBody rtn = new RtnBody();
		//SystemUser user = SystemUserUtil.getLoginUser(request);
		
		//判断是否输入页数
		if (StrKit.isBlank(pageNum)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		String pageSize = "20";    //每页条数
		PageInfo<Record> page = new PageInfo<Record>();
		Map<String,Object> map=new HashMap<String, Object>();
		
		//page分页查询
		page = teacherService.getCommitteeList(map, pageNum, pageSize);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功！").data(page);
		return rtn;
	}
	
	@RequestMapping(value="/detail")
	public RtnBody getCommitteeDetail(String userId, String specialId){
		RtnBody rtn = new RtnBody();
		//SystemUser user = SystemUserUtil.getLoginUser(request);
		Map<String,Object> map=new HashMap<String, Object>();
		
		//判断是否输入专委会ID
		if (StrKit.isBlank(specialId)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("专项ID不能为空！");
		} else {
			map.put("specialId", specialId);
		}
		if (!StrKit.isBlank(userId)) {
			map.put("userId", userId);
		}
		Record record = new Record();
		record = teacherService.getCommitteeDetail(map);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功！").data(record);
		return rtn;
	}
}
