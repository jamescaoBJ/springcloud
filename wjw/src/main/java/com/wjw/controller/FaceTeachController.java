package com.wjw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.SystemUser;
import com.wjw.util.SystemUserUtil;

/**
 * ClassName:FaceTeachController
 * Function: 面授项目Controller
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2018年1月4日	下午2:32:55
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/face")
public class FaceTeachController extends Controller {

	/**
	 * getExamRecordList:
	 * 面授考试历史考试记录
	 * @param  @param userId
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param isPass
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	public RtnBody getExamRecordList(String userId, String pageNum, String pageSize, boolean isPass){
		RtnBody rtn = new RtnBody();
		if (StrKit.isBlank(pageNum)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		if (StrKit.isBlank(pageSize)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("每页面条数未指定！");
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		
		return rtn;
	}
}
