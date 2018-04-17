package com.wjw.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.AgencyService;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.WeiXinService;
import com.wjw.util.SystemUserUtil;

/**
 * 
 * ClassName:WeiXinController
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   juniorice
 * @version  
 * @since    version 1.0
 * @Date	 2018年2月6日	上午9:32:36
 *
 * @see 	 
 *
 */
@RestController
@RequestMapping("/weixin")
public class WeiXinController extends Controller {
	@Autowired
	WeiXinService weiXinService;

	@RequestMapping("/getSpeciaList")
	public RtnBody userinfo(String userId){
		//SystemUser user = SystemUserUtil.getLoginUser(request);
		RtnBody rtn = new RtnBody();
		//查询 page分页
		String pageNum = getPara("pageNum"); 		  // 当前页
		if (StrKit.isBlank(pageNum)) {
			pageNum="1";
		} 
		String pageSize = getPara("pageSize", "20"); // 每页条数
		PageInfo<Record> page = new PageInfo<Record>();
		page = weiXinService.selectSpeciaByPage(userId,pageNum, pageSize);
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(page); 
	}
	
	@RequestMapping(value="/specialDetail")
	public RtnBody specialDetail(String userId, String id){
		//SystemUser user = SystemUserUtil.getLoginUser(request);
		RtnBody rtn = new RtnBody();
		
		Map<String,Object> map=new HashMap<String, Object>();
		Map<String,Object> map2=new HashMap<String, Object>();
		// 课程ID
		if (StrKit.isBlank(id)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请输入课程ID");
		} else {
			map.put("id", id);
		}
        // 设置用户userId 
        map.put("userId", userId);
        
        //获取专项详情
        Record cvshow = new Record();
        Record cv = weiXinService.getSpecialDetail(map);
        List<Record> list = new ArrayList<Record>();
        
        //获取专项期数
    	List<Record> tlist = weiXinService.getSpecialFaceteach(map);
    	if (tlist!=null && tlist.size()>0) {
    		for (Record rr : tlist) {
    			Record r = new Record();
    			r.put("faceteachId", rr.get("faceteachId").toString());
    			r.put("faceteachName", rr.get("faceteachName").toString());
    			r.put("trainStarttime", rr.get("trainStarttime").toString().substring(0,10));
    			r.put("trainEndtime", rr.get("trainEndtime").toString().substring(0,10));
    			//验证本期是否已报名
    			map2.put("userId", userId);
    			map2.put("cvSetId", id);
    			map2.put("faceteachId", rr.get("faceteachName").toString());//根据客户需求,使用期数
    			//map2.put("faceteachId", 1);//目前只有一期,代码写死(值为1)
    			int no = weiXinService.isSignUp(map2);
    			if (no > 0) {
    				r.put("trainStatue", 1);
    			} else {
    				r.put("trainStatue", 0);
    			}
    			r.put("timeStatue", rr.get("timeStatue").toString());
    			list.add(r);
			}
    		cvshow.put("list", list);
    	}
    	//获取专项下课程
    	List<Record> courseList = weiXinService.getSpecialCourseList(map);
    	
    	if (cv!=null && Integer.parseInt(cv.get("id").toString())>0) {
    		cvshow.put("id", cv.get("id").toString());
    		cvshow.put("name", cv.get("name").toString());
    		cvshow.put("forma", cv.get("forma").toString());
    		cvshow.put("teacher", cv.get("teacher").toString());
    		cvshow.put("code", cv.get("code").toString());
    		cvshow.put("scode", cv.get("scode").toString());
    		cvshow.put("institutions", cv.get("institutions").toString());
    		if (cv.get("address").toString() != null) {
    			cvshow.put("address", cv.get("address").toString());
    		} else {
    			cvshow.put("address", "");
    		}
    		cvshow.put("startDate", cv.get("startDate").toString().substring(0,10));
    		cvshow.put("endDate", cv.get("endDate").toString().substring(0,10));
    		cvshow.put("courseList", courseList);
    	}
        
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(cvshow);
		return rtn;
		
	}
	
	@RequestMapping(value="/signUp")
	public RtnBody signUp(String userId, String cvSetId, String faceteachId){
		RtnBody rtn = new RtnBody();
		
		Map<String,Object> map=new HashMap<String, Object>();
		// 用户ID
		if (StrKit.isBlank(userId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空!");
		} 
		// 项目ID
		if (StrKit.isBlank(cvSetId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("项目ID不能为空!");
		} 
		// 项目期数ID
		if (StrKit.isBlank(faceteachId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("项目期数ID不能为空!");
		} 
        
		map.put("userId", userId);
		map.put("cvSetId", cvSetId);
		map.put("faceteachId", faceteachId);
		map.put("createDate", new Date());
		//验证本期是否已报名
		int no = weiXinService.isSignUp(map);
		if (no > 0) {
			rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("本期您已报过名！");
		} else {
			weiXinService.saveSignUp(map);
			rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("报名成功！");
		}
		return rtn;
	}
	
	@RequestMapping(value="/getSignUp")
	public RtnBody getSignUp(String userId, String cvSetId, String faceteachId){
		RtnBody rtn = new RtnBody();
		
		Map<String,Object> map=new HashMap<String, Object>();
		// 用户ID
		if (StrKit.isBlank(userId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空!");
		} 
		// 项目ID
		if (StrKit.isBlank(cvSetId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("项目ID不能为空!");
		} 
		// 项目期数ID
		if (StrKit.isBlank(faceteachId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("项目期数ID不能为空!");
		} 
        
		map.put("userId", userId);
		map.put("cvSetId", cvSetId);
		map.put("faceteachId", faceteachId);
		
		Record rt = new Record();
		Record r = new Record();
		r = weiXinService.getSignUp(map);
		if (r!=null) {
			rt.put("userId", r.get("userId"));
			rt.put("userName", r.get("userName"));
			rt.put("userCard", r.get("userCard"));
			rt.put("userPhone", r.get("userPhone"));
			if (r.get("unitAddress")!=null) {
				rt.put("unitAddress", r.get("unitAddress"));
			} else {
				rt.put("unitAddress", "");
			}
			if (r.get("unitName")!=null) {
				rt.put("unitName", r.get("unitName"));
			} else {
				rt.put("unitName", "");
			}
			rt.put("name", r.get("name"));
			rt.put("id", r.get("id"));
			rt.put("faceteachId", r.get("faceteachId"));
			rt.put("faceteachName", r.get("faceteachName"));
			rt.put("trainStarttime", r.get("trainStarttime").toString().substring(0,10));
			rt.put("trainEndtime", r.get("trainEndtime").toString().substring(0,10));
			rt.put("trainPlace", r.get("trainPlace"));
			rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功！").data(rt);
		} else {
			rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("获取失败！").data(rt);
		}
		return rtn;
	}
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/jfsignUp")
	public RtnBody jfsignUp(HttpServletRequest request,HttpServletResponse response){
		RtnBody rtn = new RtnBody();
		String projectName = "signup";
		String resultStr="";
		String ss = request.getMethod();
		if("OPTIONS".equalsIgnoreCase(request.getMethod())){//ajax跨域验证
			rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("报名失败！").kvData("resultStr", resultStr);
		}
		AgencyService as=new AgencyService();
		JSONObject jsonObject = new JSONObject();	
		try {
			//如果是get请求，调用下面方法
			if("GET".equalsIgnoreCase(request.getMethod())){
				resultStr=as.doGet(projectName,request);
				if (resultStr!=null && resultStr.length()>0){
					 jsonObject = JSON.parseObject(resultStr);;
				}
			}else{//Post请求
				String url=null,  type=null,  params=null;
				resultStr = as.doPost(projectName,url,type,params);
				if (resultStr!=null && resultStr.length()>0){
					 jsonObject = JSON.parseObject(resultStr);;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			resultStr=e.getMessage();
		}catch(RuntimeException e){
			e.printStackTrace();
			resultStr=e.getMessage();
		}
		if (jsonObject!=null) {
			return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).kvData("code", jsonObject.getString("code")).kvData("message", jsonObject.getString("message"));
		} else {
			return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).kvData("code", "0").kvData("message", "报名失败");
		}
		
	}
}
