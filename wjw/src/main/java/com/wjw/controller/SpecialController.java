/**
 * 2018年1月9日 下午1:09:56
 * @author 王印涛
 * SpecialController.java
 */
package com.wjw.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
import com.wjw.service.CvSetService;
import com.wjw.service.SpecialService;
import com.wjw.service.SystemUserFaceEntryService;
import com.wjw.util.SystemUserUtil;

/**
 * @author 王印涛
 * SpecialController.java
 * 2018年1月9日 下午1:09:56
 * 专项能力
 */
@RestController
@RequestMapping("/special")
public class SpecialController extends Controller{
	/**
	 * 面授报名
	 */
	@Autowired
	SystemUserFaceEntryService systemUserFaceEntryService;
	
	@Autowired
	CvSetService cvSetService;
	@Autowired
	SpecialService specialService;
	
	/**
	 * 
	 * getSpecialTrainList:
	 * 专项能力列表
	 *
	 * @param  @param keyword
	 * @param  @param state
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/getSpecialTrainList")
    public RtnBody getSpecialTrainList(String keyword, String state,String pageNum, String pageSize){
		RtnBody rtn = new RtnBody();
		//判断是否输入页数
		if (StrKit.isBlank(pageNum)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		try {
			if (StrKit.notBlank(keyword)) {
				keyword = URLDecoder.decode(keyword,"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (StrKit.isBlank(pageSize)) {
			pageSize = "20";    //每页条数
		}
		PageInfo<Record> page = new PageInfo<Record>();
		
		//page分页查询
		page = specialService.getSpecialTrainList(keyword, state, pageNum, pageSize,request);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功！").data(page);
		return rtn;
	}
	
	/**
	 * 
	 * getSpecialDetail:
	 * 专项能力详情
	 *
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/getSpecialDetail")
	public RtnBody getSpecialDetail(String userId, String projectId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null||"".equals(userId)) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		if (StrKit.isBlank(projectId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("专项ID不能为空！");
		}
		Record sDetail = specialService.getSpecialDetail(Integer.valueOf(userId),Integer.valueOf(projectId));
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功").data(sDetail);
	}
	
	
	/**
	 * 
	 * @author 王印涛 
	 * 2018年1月10日 上午9:22:59
	 * @Description:专项能力面授项目详情
	 * @param userId
	 * @param projectId
	 * @return RtnBody
	 */
	@RequestMapping("/getFaceProDetailById")
	public RtnBody getFaceProDetailById(String userId, String projectId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null||"".equals(userId)) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		if (StrKit.isBlank(projectId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请检查必输项！");
		}
		Record faceDetail = systemUserFaceEntryService.getFaceProDetailById(Integer.valueOf(userId),Integer.valueOf(projectId));
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success").data(faceDetail);
		
	}
	/**
	 * 
	 * @author 王印涛
	 * 2018年1月11日 上午10:04:09
	 * @Description: 专项能力根据期数查询信息
	 * @param userId
	 * @param projectId
	 * @param classId
	 * @return RtnBody
	 */
			
	@RequestMapping("/getCvListByClassId")
	public RtnBody getCvListByClassId(String userId, String projectId,String classId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null||"".equals(userId)) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		if (StrKit.isBlank(projectId) || StrKit.isBlank(classId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请检查必输项！");
		}
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("fid", Integer.valueOf(classId));
		map.put("cvSetId", Integer.valueOf(projectId));
		Record  faceTeach = systemUserFaceEntryService.getFaceTeachById(map);
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success").data(faceTeach);
	}
	/**
	 * 
	 * @author 王印涛
	 * 2018年1月11日 上午10:34:47
	 * @Description: 专项能力面授项目报名
	 * @param userId
	 * @param projectId
	 * @param classId
	 * @return RtnBody
	 */
	@RequestMapping("/signUp")
    public RtnBody signUp(String userId, String projectId,String classId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null||"".equals(userId)) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		if (StrKit.isBlank(projectId) || StrKit.isBlank(classId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请检查必输项！");
		}	
		//保存面授报名
		systemUserFaceEntryService.signUp(Integer.valueOf(userId),Integer.valueOf(projectId),Integer.valueOf(classId));
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(userId));
		map.put("fid", Integer.valueOf(classId));
		Map<String, Object> isSignUp = systemUserFaceEntryService.isSignUp(map);//是否报名
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(isSignUp);
	}
	/**
	 * 
	 * @author 王印涛
	 * 2018年1月10日 上午9:16:57
	 * @Description:专项能查看报名表
	 * @param userId
	 * @param projectId
	 * @param classId
	 * @return RtnBody
	 */
	@RequestMapping("/viewEntryInfo")
	public RtnBody viewEntryInfo(String userId, String projectId,String classId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null||"".equals(userId)) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		if (StrKit.isBlank(projectId) || StrKit.isBlank(classId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请检查必输项！");
		}
		//获取面授报名表信息
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(userId));
		map.put("fid", Integer.valueOf(classId));
		map.put("cvSetId", Integer.valueOf(projectId));
		Record faceEntry = systemUserFaceEntryService.getFaceInfo(map);
		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success").data(faceEntry);
		
	}
}
