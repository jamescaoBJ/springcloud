package com.wjw.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.CvSetScoreLog;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.CvSetScoreService;
import com.wjw.service.FirstPageProjectService;
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
@RequestMapping("/project")
public class FirstPageProjectController extends Controller{
	@Autowired
	FirstPageProjectService firstPageProjectService;
	@Autowired
	CvSetScoreService cvSetScoreService;
	
	/**
	 * 
	 * getBannerList:
	 * TODO(获取首页推荐项目)
	 *
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/getReCommendProjectList")
	public RtnBody getBannerList(){
		RtnBody rtn = new RtnBody();
		log.info("{} query begin!","List");
		Map<String,Object> map=new HashMap<String, Object>();
		String domainName = request.getServerName(); //"dev.ncme.org.cn";   取到 域名地址
		if (domainName != null && !"".equals(domainName)){
        	map.put("domainName", domainName);
        }
		map.put("status", 5);
		map.put("edtionId", 3);
		//查询首页banner
		List<Record> project = firstPageProjectService.getReCommendProjectList(map);
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(project);
	}
	/**
	 * 添加项目评价
	 * @param projectId
	 * @param userId
	 * @param score1
	 * @param score2
	 * @param score3
	 * @param score4
	 * @param scoreDate
	 * @param scoreContent
	 * @return
	 */
	@RequestMapping(value="/evaluation")
	public RtnBody add(String projectId,String userId, String score1, String score2, String score3, String score4,
			Date scoreDate,String scoreContent){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		RtnBody rtn = new RtnBody();
		if (StrKit.isBlank(userId)) {         //获取userId
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不正确！");
		}
		if (StrKit.isBlank(projectId)) {      //获取项目Id
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("项目ID不正确！");
		}
		/*if (StrKit.isBlank(score1)) {         //四项打分的分值
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("请填选评价！");
		}*/
		if (StrKit.isBlank(score2)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("请填选评价！");
		}
		if (StrKit.isBlank(score3)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("请填选评价！");
		}
		if (StrKit.isBlank(score4)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("请填选评价！");
		}
		
		try {
			//转化传回来的参数类型
		    int projectId1 = Integer.parseInt(projectId);
		    int userId1 = Integer.parseInt(userId);
		    BigDecimal score11=new BigDecimal(score1);   
		    BigDecimal score12=new BigDecimal(score2);
		    BigDecimal score13=new BigDecimal(score3);
		    BigDecimal score14=new BigDecimal(score4);
			scoreDate = new Date();
			cvSetScoreService.insert(projectId1,userId1,  score11, score12, score13, score14,scoreDate,scoreContent);
		
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，评价成功！");
			}
			
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
