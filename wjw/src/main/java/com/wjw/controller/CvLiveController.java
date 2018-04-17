package com.wjw.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.DateUtil;
import com.ncme.springboot.footstone.util.JPushClientUtil;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.CvLive;
import com.ncme.springboot.model.SystemMessage;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.CaseService;
import com.wjw.service.CvLiveService;
import com.wjw.service.RedisService;
import com.wjw.service.SystemMessageService;
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
@RequestMapping("/live")
public class CvLiveController extends Controller{
	@Autowired
	CvLiveService cvLiveService;
	@Autowired
	SystemUserService systemUserService;
	@Autowired
	CaseService caseService;
	//保存推送消息
	@Autowired
	SystemMessageService systemMessageService;
	@Autowired
	RedisService redisService;
	
	/**
	 * 
	 * getSearchResultList:
	 * TODO(获取直播课程列表)
	 *
	 * @param  @param accountName
	 * @param  @param userId
	 * @param  @param xueke
	 * @param  @param type
	 * @param  @param pageNum
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/getList")
	public RtnBody getSearchResultList(String accountName, String userId, String xueke, String type, String pageNum){
		//SystemUser user = SystemUserUtil.getLoginUser(request);
		
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
        // 设置直播状态
        if (type != null && !"".equals(type) && !"ALL".equals(type)) {
        	map.put("liveType", type);
        }
        String domainName = request.getServerName(); //"dev.ncme.org.cn";//request.getServerName(); //取到 域名地址
        if (domainName != null && !"".equals(domainName)){
        	map.put("domainName", domainName);
        }
		//page分页查询
		page = cvLiveService.getCvList(map, pageNum, pageSize,request);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(page);
		return rtn;
		
	}
	
	/**
	 * 
	 * getLiveDetail:
	 * TODO(获取直播课程详情)
	 *
	 * @param  @param userId
	 * @param  @param cvId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/getDetail")
	public RtnBody getLiveDetail(String userId, String cvId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		
		RtnBody rtn = new RtnBody();
		Map<String,Object> map=new HashMap<String, Object>();
		//判断是否直播课程ID
		if (StrKit.isBlank(cvId)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("课程ID不能为空！");
		} else {
			map.put("cvId", cvId);
			
		}
        String domainName = request.getServerName(); //取到 域名地址
        if (domainName != null && !"".equals(domainName)){
        	map.put("domainName", domainName);
        }
		Record cv = cvLiveService.getDetail(map,request);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(cv);
		return rtn;
		
	}
	
	@RequestMapping(value="/catalog")
	public RtnBody getLiveCatalog(String userId, String typicalId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		RtnBody rtn = new RtnBody();
		Map<String,Object> map=new HashMap<String, Object>();
		
		// 课程ID
		if (StrKit.isBlank(typicalId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("课程ID不能为空");
		} else {
			map.put("typicalId", typicalId);
			map.put("cvId", typicalId);
		}
        // 设置课程标签type 1:病例   3:VR 4:名师  5:三维动画  6:其它
		String[] a = {"6"};
	    map.put("type", Arrays.asList(a));
        // 设置用户userId
		if (StrKit.isBlank(userId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空");
		} else {
			map.put("userId", userId);
		}
		
        String domainName = request.getServerName(); //取到 域名地址
        if (domainName != null && !"".equals(domainName)){
        	map.put("domainName", domainName);
        }
        
        Record cv = new Record();
        
		Record cvDetail = cvLiveService.getDetail(map,request);
		if (cvDetail!=null && cvDetail.get("makeType").toString().equals("1")){
			cv.put("cvUnitList", cvDetail.get("viewBackUrlList"));
			cv.put("costType",cvDetail.get("costType"));
			cv.put("typicalId", cvDetail.get("cvId"));
			cv.put("unitName", cvDetail.get("cvName"));
			cv.put("makeType", cvDetail.get("makeType").toString());
		} else if (cvDetail!=null && cvDetail.get("makeType").toString().equals("2")){
			cv = caseService.getCvCatalogById(map);
			cv.put("makeType", cvDetail.get("makeType").toString());
		} else {
			cv = caseService.getCvCatalogById(map);
		}
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(cv);
		return rtn;
	}
	
	@RequestMapping(value="/checkBindCost")
	public RtnBody checkBindCost(String userId, String cvId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		RtnBody rtn = new RtnBody();
		Map<String,Object> map=new HashMap<String, Object>();
		
		// 课程ID
		if (StrKit.isBlank(cvId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("课程ID不能为空");
		} 
        // 设置用户userId
		if (StrKit.isBlank(userId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空");
		} 
		Record r = cvLiveService.checkBindCost(userId,cvId);
		if (r.get("bindFlag").equals("2")) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("此课程不隶属于一个项目");
		}
		//return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").kvData("bindFlag", r.get("bindFlag"));
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(r);
	}
	
	@RequestMapping(value="/isTokenOverdue")
	public RtnBody isTokenOverdue(){
		RtnBody rtn = new RtnBody();
		//获取用户信息
		SystemUser user = SystemUserUtil.getLoginUser(request); //权限信息应该在项目展示阶段进行鉴权,原系统设计不合理，暂时复用
		if (user == null) {
			return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("用户未登录或者Token已过期！").kvData("tokenflag", BusinessConst.USER_NOT_LOGIN);
		} else {
			return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("Token未过期！").kvData("tokenflag", 1);
		}
	}

	@RequestMapping(value="/SignUpInfo")
	public RtnBody SignUpInfo(String userId, String projectId){
		RtnBody rtn = new RtnBody();
		// 设置用户userId
		if (StrKit.isBlank(userId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空");
		} 
		// 直播课程ID
		if (StrKit.isBlank(projectId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("课程ID不能为空");
		} 
		//验证用户是否已报名过
		if (cvLiveService.checkSignUp(userId,projectId)) {
			return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("您已报过名！");
		} else {
			cvLiveService.signUpInfo(userId,projectId);
			Date curr = DateUtil.getNowDateYM();
			String userfulDate = "",itemName = "";
			SystemMessage message = new SystemMessage();
			//根据课程ID获取直播课程
			CvLive cvLive = cvLiveService.selectByPrimaryKey(Integer.parseInt(projectId));
			
			String startDate="",invaliDate="",start="",invali="",str="";
			Date startD = cvLive.getStartDate();
			Date endD = cvLive.getInvalidDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			startDate = sdf.format(startD);
			invaliDate = sdf.format(endD);
			if (startDate!=null && startDate!="" && invaliDate!=null && invaliDate!="") {
				start = startDate.substring(0, 16);
				invali = invaliDate.substring(11, 16);
				str=start+"-"+invali;
			}
			//直播报名成功,给用户//推送一条信息(极光推送)
			String notification_title="NCME";     							  // 标题(固定写法)
			String msg_title="";											  // 为空
			String msg_content="亲爱的学员，你已报名参加【"+cvLive.getClassName()+"】直播课程，将于"+str+"直播，请准时参加~";       // 内容
			List<String> alias= new ArrayList<String>();
			alias.add(userId);
			//int result = new JPushClientUtil(true).sendToClient(notification_title, msg_title, msg_content, alias);
			//将此推送信息保存至(system_message)表中
			message.setSystemUserId(Integer.parseInt(userId));
			message.setMessageContent(msg_content);
			message.setMessageDate(new Date());
			message.setIsRead(1);
			message.setMessageTitle("直播报名成功");
			systemMessageService.saveMessage(message);
			//报完名之后将userid存入缓存中
			List<String> signUpList = (List<String>)redisService.get(projectId);
			if (signUpList != null) {
				signUpList.add(userId);
				redisService.set(projectId, signUpList);
			} else {
				List<String> userList = new ArrayList<String>();
				userList.add(userId);
				redisService.set(projectId, userList);
			}
			return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("报名成功！");
		}
		
	}
	
	@RequestMapping(value="/isSignUp")
	public RtnBody isSignUp(String userId, String projectId){
		RtnBody rtn = new RtnBody();
		// 设置用户userId
		if (StrKit.isBlank(userId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空");
		} 
		// 直播课程ID
		if (StrKit.isBlank(projectId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("课程ID不能为空");
		} 
		//验证用户是否已报名过
		if (cvLiveService.checkSignUp(userId,projectId)) {
			return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("已报名！").kvData("isSignup", 0);
		} else {
			return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("未报名！").kvData("isSignup", 1);
		}
		
	}
	
	@RequestMapping(value="/maintainLogStudy")
	public RtnBody maintainLogStudy(String userId, String cvId){
		RtnBody rtn = new RtnBody();
		// 设置用户userId
		if (StrKit.isBlank(userId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空");
		} 
		// 直播课程ID
		if (StrKit.isBlank(cvId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("课程ID不能为空");
		} 
		String flag = cvLiveService.maintainLogStudySave(userId,cvId);
		//根据flag的值进行判断
		if (flag.equals("1")) {
			return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("cvSet is null！");
		} else if (flag.equals("2")) {
			return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("unitList is null！");
		} else {
			return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success！");
		}
	}
	
	
}
