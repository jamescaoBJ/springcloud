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
 * ClassName:AdvertController
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月1日	下午2:05:05
 *
 * @see 	 
 *
 */
@RestController
@RequestMapping("/case")
public class CaseController extends Controller{
	@Autowired
	CaseService caseService;
	@Autowired
	SystemUserService systemUserService;
	@Autowired
	CvSetService cvSetService;

	/**
	 * 
	 * getBannerList:(这里用一句话描述这个方法的作用)
	 * TODO(获取典型病例列表(标签为病例的课程)
	 *
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/list")
	public RtnBody getCaseCvList(String accountName, String userId, String xueke, String hot, String pageNum){
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
		Integer[] a = {1};
	    map.put("type", Arrays.asList(a));
        map.put("types", 1);
        // 设置用户userId 
        map.put("userId", userId);
		//page分页查询
		page = caseService.getCaseCvList(map, pageNum, pageSize);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(page);
		return rtn;
	}
	
	/**
	 * 
	 * getCaseCvDetail:(这里用一句话描述这个方法的作用)
	 * TODO(获取典型病例详情 – 可选)
	 *
	 * @param  @param userId
	 * @param  @param typicalId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/caseDetail")
	public RtnBody getCaseCvDetail(String userId, String typicalId){
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
		Integer[] a = {1};
	    map.put("type", Arrays.asList(a));
        // 设置用户userId 
        map.put("userId", userId);
	    
        Record cv = caseService.getCvDetailById(map);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(cv);
		return rtn;
		
	}
	
	/**
	 * 
	 * getCaseCvCatalog:(这里用一句话描述这个方法的作用)
	 * TODO(获取典型病例目录 – 可选)
	 *
	 * @param  @param userId
	 * @param  @param typicalId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/catalog")
	public RtnBody getCaseCvCatalog(String userId, String typicalId){
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
		Integer[] a = {1};
	    map.put("type", Arrays.asList(a));
        // 设置用户userId
	    map.put("userId", userId);
	
        Record cv = caseService.getCvCatalogById(map);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(cv);
		return rtn;
	}
	
	/**
	 * 
	 * unitDiscuss:(单元讨论)
	 * TODO(获取典型病例  – 单元讨论)
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param unitId
	 * @param  @param projectId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/unitDiscuss")
	public RtnBody unitDiscuss(String userId,String unitId,String projectId,String pageNum){
		RtnBody rtn = new RtnBody();
		//判断是否输入页数
		if (StrKit.isBlank(pageNum)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		String pId="",uId="";
		String pageSize = "10";    //每页条数
		PageInfo<Record> page = new PageInfo<Record>();
		Map<String,Object> map=new HashMap<String, Object>();
		// 单元ID
		if (StrKit.isBlank(unitId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("单元ID不能为空");
		} else {
			uId = unitId;
		}
		
		// 项目ID
		if (projectId != null && !"".equals(projectId)) {
			pId= projectId;
	    }
		
		//根据单元ID获取到所在的 项目ID
		String cvSetId = projectIdByUnitId(uId);
		if (cvSetId!=null) {
			//page分页查询
			//此处直接调用cvSetService中的 unitDiscuss()方法
			page = cvSetService.unitDiscuss(pageNum,pageSize,unitId,cvSetId);
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success.").data(page);
		}
		return null;
	}
	
	//根据单元ID获取到 该单元 所在的课程ID,再根据 课程ID 获取 其课程 所在的 项目ID
	public String projectIdByUnitId(String unitId){
		String cvSetId = "";
		cvSetId = caseService.getProjectIdByUnitId(unitId);
		return cvSetId;
	}
	
	
}
