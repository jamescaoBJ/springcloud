package com.wjw.controller.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

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
import com.wjw.service.SearchService;
import com.wjw.service.SystemMessageService;
import com.wjw.service.SystemUserService;
import com.wjw.util.SystemUserUtil;

/**
 * ClassName:SystemController
 * Function: TODO 系统Controller
 * Reason:	 TODO ADD REASON
 *
 * @author   Admin
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月6日	下午2:50:22
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/system")
public class SystemController extends Controller {

	@Autowired
	SystemUserService systemUserService;
	@Autowired
	SystemMessageService systemMessageService;
	@Autowired
	SearchService searchService;
	/**
	 * getLabelList:
	 * 获取标签列表
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/getLabelList")
	public RtnBody getLabelList(){
		RtnBody rtn = new RtnBody();
		List<Record> label = new ArrayList<Record>();
		Record record = new Record();
		record.put("labelId", "-1");
		record.put("labelName", "全部");
		label.add(record);
		Record r1 = new Record();
		r1.put("labelId", "0");
		r1.put("labelName", "指南解读");
		label.add(r1);
		Record r2 = new Record();
		r2.put("labelId", "1");
		r2.put("labelName", "公需科目");
		label.add(r2);
		/*Record r3 = new Record();
		r3.put("labelId", "2");
		r3.put("labelName", "海外视野");
		label.add(r3);*/
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(label); 
	}
	
	@RequestMapping(value="/getGradeList")
	public RtnBody getGradeList(){
		RtnBody rtn = new RtnBody();
		List<Record> grade = new ArrayList<Record>();
		Record record = new Record();
		record.put("gradeId", "-1");
		record.put("gradeName", "全部");
		grade.add(record);
		Record r1 = new Record();
		r1.put("gradeId", "1");
		r1.put("gradeName", "国家I类");
		grade.add(r1);
		Record r2 = new Record();
		r2.put("gradeId", "2");
		r2.put("gradeName", "省级I类");
		grade.add(r2);
		Record r3 = new Record();
		r3.put("gradeId", "3");
		r3.put("gradeName", "市级I类");
		grade.add(r3);
		Record r4 = new Record();
		r4.put("gradeId", "4");
		r4.put("gradeName", "省级II类");
		grade.add(r4);
		Record r5 = new Record();
		r5.put("gradeId", "5");
		r5.put("gradeName", "市级II类");
		grade.add(r5);
		Record r6 = new Record();
		r6.put("gradeId", "6");
		r6.put("gradeName", "无学分");
		grade.add(r6);
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(grade); 
	}
	
	/**
	 * noticeList:
	 * 获得系统消息列表
	 * @param  @param userId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/noticeList")
	public RtnBody noticeList(String userId, Integer isRead){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		if (isRead == null) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请检查参数！");
		}
		RtnBody rtn = new RtnBody();
		String pageNum = getPara("pageNum"); // 当前页码
		if (StrKit.isBlank(pageNum)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		String pageSize = getPara("pageSize", "20"); // 每页条数
		if (StrKit.isBlank(pageSize)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("每页面条数未指定！");
		}
		int notReadCount = 0;
		if (isRead == 1) {
			notReadCount = systemMessageService.getNotReadCount(user.getId());
		} else if (isRead == 2) {
			//将全部消息标记为已读
			systemMessageService.markReadMessageByUserId(user.getId(), isRead);
		}
		PageInfo<Record> page = systemMessageService.getMessageList(user.getId(), pageNum, pageSize);
		
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(page).kvData("notReadCount", notReadCount);
	}

	/**
	 * 
	 * urlList:
	 * TODO(返回原生H5地址 )
	 *
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/urlList")
	public RtnBody urlList(){
		RtnBody rtn = new RtnBody();
		List<Record> grade = new ArrayList<Record>();
		Record r0 = new Record();
		r0.put("url", BusinessConst.H5_URL_ADDR);
		r0.put("name", "首页");
		grade.add(r0);
		Record r1 = new Record();
		r1.put("url", BusinessConst.H5_URL_ADDR+"message");
		r1.put("name", "消息");
		grade.add(r1);
		Record r2 = new Record();
		r2.put("url", BusinessConst.H5_URL_ADDR+"study");
		r2.put("name", "学习");
		grade.add(r2);
		Record r3 = new Record();
		r3.put("url", BusinessConst.H5_URL_ADDR+"mine");
		r3.put("name", "我的");
		grade.add(r3);
		Record r4 = new Record();
		r4.put("url", BusinessConst.H5_URL_ADDR+"search");
		r4.put("name", "搜索");
		grade.add(r4);
		Record r5 = new Record();
		r5.put("url", BusinessConst.H5_URL_ADDR+"mine/login");
		r5.put("name", "登录");
		grade.add(r5);
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(grade); 
	}
	
	/**
	 * 
	 * getSearchResultList:
	 * TODO(全局搜索 )
	 *
	 * @param  @param userId
	 * @param  @param key
	 * @param  @param pageNum
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/search")
	public RtnBody getSearchResultList(String userId, String key, String pageNum){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		RtnBody rtn = new RtnBody();
		//判断是否输入关键字
		if (StrKit.isBlank(key)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("关键字不能为空！");
		}
		//判断是否输入页数
		if (StrKit.isBlank(pageNum)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		try {
			if (StrKit.notBlank(key)) {
				key = URLDecoder.decode(key,"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String pageSize = "20";    //每页条数
		String domainName = request.getServerName(); //取到 域名地址
		PageInfo<Record> page = new PageInfo<Record>();
		//page分页查询
		if (user != null && user.getUserProvinceId() != null) {
			page = searchService.getSearchResultList(key, pageNum, pageSize, user.getUserProvinceId(), domainName);
		} else {
			page = searchService.getSearchResultList(key, pageNum, pageSize, null, domainName);
		}
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(page);
		return rtn;
		
	}

	/**
	 * updateVersion:
	 * 升级接口
	 * @param  @param clientType
	 * @param  @param version
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/update")
	public RtnBody updateVersion(String clientType, String version){
		RtnBody rtn = new RtnBody();
		Record r = new Record();
		r.put("version", "1.0");
		r.put("updateUrl", "www.baidu.com");
		r.put("updateMsg", "优化若干功能，等你体验");
		r.put("isForce", "1");
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(r);
	}
}
