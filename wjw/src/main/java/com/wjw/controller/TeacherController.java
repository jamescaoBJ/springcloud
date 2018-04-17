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
 * ClassName:TeacherController
 * Function: 名师 demo
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年9月30日	上午11:39:09
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController extends Controller{
	
	@Autowired
	TeacherService teacherService;
	/**
	 * getTeachersByPageSimple:直接返回page对象（主要针对某些前端页面可直接接收page对象）；get && post均可
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return PageInfo<ExpertInfo>    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/page-simple")
	public PageInfo<ExpertInfo> getTeachersByPageSimple(String pageCurrent,String pageSize ){
		log.info("{} query begin!","page-simple");
		//查询名师 page分页
		
//		String pageCurrent = getPara("pageCurrent"); // 当前页
//		String pageSize = getPara("pageSize"); // 每页条数
		
		ExpertInfo expertInfo = new ExpertInfo();
		expertInfo.setPersonage(1);// 根据卫计委项目流程设置传参，personage
		PageInfo<ExpertInfo>  page = teacherService.getTeachersByPage(expertInfo,pageCurrent,pageSize);
		log.info("page-simple query end,data : {} ",page);
		return page;
	}
	
	/**
	 * getTeachersByPage: 返回包体查询分页数据（主要针对某些前端并不可直接接收page对象）,只允许post请求,支持模糊查询
	 * TODO demo：
	 *
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/page",method=RequestMethod.POST)
	public RtnBody getTeachersByPage(String pageCurrent,String pageSize){
		RtnBody rtn = new RtnBody();
		log.info("{} query begin!","page");
		SystemAccount account = Token.USER(request, SystemAccount.class);
		log.info("test token get account msg：{}",account.getAccountName());
		log.info("test token get account msg：{}",account.getAccountId());
		log.info("test token get account msg：{}",account.getAccountPassword());
		//查询名师 page分页
		
		//String pageCurrent = getPara("pageCurrent"); // 当前页
		if(StrKit.isBlank(pageCurrent)){
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		//String pageSize = getPara("pageSize"); // 每页条数
		if(StrKit.isBlank(pageSize)){
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("每页面条数未指定！");
		}
		ExpertInfo expertInfo = new ExpertInfo();
		expertInfo.setPersonage(1);// 根据卫计委项目流程设置传参，personage
		expertInfo.setName(getPara("name"));
		
//		PageInfo<Record> page =  teacherService.getTeachersByPageRecord(expertInfo, pageCurrent, pageSize);//--可用，模拟复杂返回对象查询，如果想用vo，可以自定义复杂vo对象。
//		log.info("pagerecord query end,data : {} ",page);
		PageInfo<ExpertInfo>  page = teacherService.getTeachersByPage(expertInfo,pageCurrent,pageSize);
		log.info("page query end,data : {} ",page);
//		setAttr("hello", "你好");-- 一般用于返回String数据也就是页面的请求中，实现可以附带着携带数据，此外，modelview也是可以同时返回数据和页面的，后续商量如何选择统一？？
//		setCookie("test", "lyj", 1000);// --可用，注释掉，设置cookies
		
//		String JSESSIONID = getCookie("JSESSIONID");--可用，注释掉，获取cookies
//		removeCookie("test");--可用，注释掉，删除cookies
//		log.info(JSESSIONID);

		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).data(page);//{"code":200,"data":{....}} --可用，先注释掉，主要使用默认返回数据体前缀为：data
		
//		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).kvData("page",page);//{"code":200,"page":{....}} --可用,主要使用自定义数据体前缀，例如 ：page
//		rtn.kvData("else", "附加测试"); //--可用，附加其它需要的返回对象或者数据
		return rtn;
	}
	
	@RequestMapping(value="/pageVo",method=RequestMethod.POST)
	public RtnBody getTeachersByPagevo(@Validated Page pageVo,BindingResult result){
		RtnBody rtn = new RtnBody();
		String message = validate(result);
		//复杂对象或者自定义vo校验规则必须使用，简单参数验证可以代码自定义实现
		if(message != null){
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message(message);
		}
		log.info("{} query begin!","page");
		SystemAccount account = Token.USER(request, SystemAccount.class);
		ExpertInfo expertInfo = new ExpertInfo();
		expertInfo.setPersonage(1);// 根据卫计委项目流程设置传参，personage
		expertInfo.setName(getPara("name"));
//		PageInfo<Record> page =  teacherService.getTeachersByPageRecord(expertInfo, pageCurrent, pageSize);//--可用，模拟复杂返回对象查询，如果想用vo，可以自定义复杂vo对象。
//		log.info("pagerecord query end,data : {} ",page);
		PageInfo<ExpertInfo>  page = teacherService.getTeachersByPageVo(expertInfo,pageVo.getPageNum(),pageVo.getPageSize());
		
		log.info("page query end,data : {} ",page);
//		setAttr("hello", "你好");-- 一般用于返回String数据也就是页面的请求中，实现可以附带着携带数据，此外，modelview也是可以同时返回数据和页面的，后续商量如何选择统一？？
//		setCookie("test", "lyj", 1000);// --可用，注释掉，设置cookies
		
//		String JSESSIONID = getCookie("JSESSIONID");--可用，注释掉，获取cookies
//		removeCookie("test");--可用，注释掉，删除cookies
//		log.info(JSESSIONID);

		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).data(page);//{"code":200,"data":{....}} --可用，先注释掉，主要使用默认返回数据体前缀为：data
		
//		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).kvData("page",page);//{"code":200,"page":{....}} --可用,主要使用自定义数据体前缀，例如 ：page
//		rtn.kvData("else", "附加测试"); //--可用，附加其它需要的返回对象或者数据
		return rtn;
	}
	
	/**
	 * getExportById:根据id获取名师信息
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/getTeacherById",method=RequestMethod.POST)
	public RtnBody getTeacherById(){
		RtnBody rtn = new RtnBody();
		String id = getPara("id");
		String personage = "1";
		if(StrKit.isBlank(id)){
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("id 不能为空！");
		}
		ExpertInfo expertInfo = teacherService.getExportById(id,personage);
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(expertInfo);
	}
	
	/**
	 * delTeacherById:删除名师及其关联（删除名师 ok，事务验证回滚ok，参照原系统，有些删除不正常，关联表太多，暂时搁置，部分是可以删除成功的，后续待业务确认）
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/delTeacherById",method=RequestMethod.POST)
	public RtnBody delTeacherById(){
		Integer id_test = getParaToInt("id");
		log.info("id通过getpara获取：{}",id_test);
		Boolean b = teacherService.delTeacherById(id_test);
		if(b)		
//			return RtnBody.me().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("名师删除成功！");
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("名师删除成功123！");//controller封装得到rtnbody的方法，抽取new 对象代码，几种得到rtnbody的方法均可使用，视情况而定
		else
			return  getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("名师删除失败！");
	}
	
	//*************************************远程调用测试*****************************************************************************
	/**
	 * helloString:测试ribbon 返回String
	 * TODO 入参：String，返回：String
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	*/
//	@RequestMapping(value="/hello",method=RequestMethod.POST) //远程提供服务，调用方式跟单体应用写法规则一致，允许post，get，put，delete。。。
	@RequestMapping(value="/hello")
	public String helloString(String accountName){
		   return "hello " +accountName+" ,i am String response test!";
	}
	
	@RequestMapping(value="/restful/{accountName}",method=RequestMethod.GET)
	public String restful(@PathVariable("accountName") String accountName ){
		return "restful : "+accountName;
	}
	
	@RequestMapping(value="/user")
	public String restful(SystemAccount user ){
		return "user : "+user.getAccountName();
	}
	
	@RequestMapping(value="/map")
	public String map(  @RequestParam Map<String,Object> model ){
		Map<String, String[]> map =getParaMap();
		LayaMap laya = laya();
		for (Entry<String, String> entry : laya.entrySet()) {  
		    log.info(entry.getKey()+"999999"+entry.getValue());
		}  
		log.info((String) model.get("realName"));
		log.info(getPara("realName")+"*****");
		log.info(laya().get("realName")+"&&&&&"+laya().get("age"));
		return "map : "+map.get("realName")[0].toString();
	}
	
	@RequestMapping(value="/getRtnBody")
	public RtnBody getRtnBody(@RequestBody SystemAccount user){
		System.out.println(user.getAccountName()+"************************************");
		user.setAccountId(10001);
		return getRtnBody().code(200).message("ok").data(user);
	}
	
	@RequestMapping(value="/list")
	public RtnBody getFamousTeacherList(String userId, String pageNum){
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
		page = teacherService.getFamousTeacherList(map, pageNum, pageSize);
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功！").data(page);
		return rtn;
	}
}
