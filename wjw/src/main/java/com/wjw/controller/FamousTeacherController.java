package com.wjw.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.CaseService;
import com.wjw.service.CvSetService;
import com.wjw.service.SystemUserService;
import com.wjw.util.SystemUserUtil;

/**
 * 
 * ClassName:FamousTeacherController
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月14日	上午11:45:14
 *
 * @see 	 
 *
 */
@RestController
@RequestMapping("/famousteacher")
public class FamousTeacherController extends Controller{
	@Autowired
	CaseService caseService;
	@Autowired
	SystemUserService systemUserService;
	@Autowired
	CvSetService cvSetService;

	/**
	 * 
	 * getFamousTeacherCvList:(这里用一句话描述这个方法的作用)
	 * TODO(获取名师课程列表(标签为名师的课程)
	 *
	 * @param  @param accountName
	 * @param  @param userId
	 * @param  @param xueke
	 * @param  @param hot
	 * @param  @param pageNum
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/list")
	public RtnBody getFamousTeacherCvList(String accountName, String userId, String xueke, String hot, String pageNum){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		
		RtnBody rtn = new RtnBody();
		//判断是否输入页数
		if (StrKit.isBlank(pageNum)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		String pageSize = "20";    //每页条数
		PageInfo<Record> page = new PageInfo<Record>();
		Map<String,Object> map=new HashMap<String, Object>();
		// 设置学科
        if (xueke != null && !"".equals(xueke) && !"ALL".equals(xueke)) {
        	map.put("xueke", xueke);
        }
        // 设置热度
        if (hot != null && !"".equals(hot) && !"ALL".equals(hot)) {
        	map.put("hot", hot);
        }
        // 设置课程标签type 1:病例   3:VR 4:名师  5:三维动画  6:其它

		Integer[] a = {4};
        map.put("type", Arrays.asList(a));
        map.put("types", 4);
        // 设置用户userId 略
        
		//page分页查询
		page = caseService.getCaseCvList(map, pageNum, pageSize);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(page);
		return rtn;
	}
	
	/**
	 * 
	 * getFamousTeacherCvDetail:(这里用一句话描述这个方法的作用)
	 * TODO(获取名师课程详情)
	 *
	 * @param  @param userId
	 * @param  @param typicalId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/detail")
	public RtnBody getFamousTeacherCvDetail(String userId, String typicalId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		RtnBody rtn = new RtnBody();
		
		Map<String,Object> map=new HashMap<String, Object>();
		// 课程ID
		if (StrKit.isBlank(typicalId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请输入课程ID");
		} else {
			map.put("typicalId", typicalId);
		}
        // 设置课程标签type 1:病例   3:VR 4:名师  5:三维动画  6:其它
		Integer[] a = {4};
	    map.put("type", Arrays.asList(a));
        // 设置用户userId 
        map.put("userId", userId);
        
        Record cv = caseService.getCvDetailById(map);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(cv);
		return rtn;
		
	}
	
	/**
	 * 
	 * getFamousTeacherCvCatalog:(这里用一句话描述这个方法的作用)
	 * TODO(获取名师课程目录)
	 *
	 * @param  @param userId
	 * @param  @param typicalId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/catalog")
	public RtnBody getFamousTeacherCvCatalog(String userId, String typicalId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		RtnBody rtn = new RtnBody();
		Map<String,Object> map=new HashMap<String, Object>();
		
		// 课程ID
		if (StrKit.isBlank(typicalId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("课程ID不能为空");
		} else {
			map.put("typicalId", typicalId);
		}
        // 设置课程标签type 1:病例   3:VR 4:名师  5:三维动画  6:其它
		Integer[] a = {4};
	    map.put("type", Arrays.asList(a));
        // 设置用户userId
	    map.put("userId", userId);
        
        Record cv = caseService.getCvCatalogById(map);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(cv);
		return rtn;
	}
	
		
	
}
