/**
 * MyStudyController.java
 * com.wjw.controller
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月8日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.DateUtil;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.CvDiploma;
import com.ncme.springboot.model.CvSet;
import com.ncme.springboot.model.LogStudyCvSet;
import com.ncme.springboot.model.SystemUser;
import com.ncme.springboot.model.SystemUserConfig;
import com.wjw.service.CvDiplomaService;
import com.wjw.service.CvSetService;
import com.wjw.service.LogStudyCvSetService;
import com.wjw.service.StudyService;
import com.wjw.service.SystemUserService;
import com.wjw.util.SystemUserUtil;

/**
 * ClassName:MyStudyController
 * Function: TODO  我的学习
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月8日	上午9:27:06
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/study")
public class StudyController extends Controller{
	
	final Integer NoApplyCredit = 1; // 未申请学分
	final Integer ApplyCreditState = 2; // 已申请学分
	@Autowired
	CvSetService cvSetService;
	@Autowired
	SystemUserService systemUserService;
	@Autowired
	LogStudyCvSetService logStudyCvSetService;
	@Autowired
	CvDiplomaService cvDiplomaService;
	@Autowired
	StudyService studyService;
	
	/**
	 * myStudy: 我的学习记录
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/myStudy")
	public RtnBody myStudy(String pageNum,String pageSize){
		
		
		/*if(StrKit.isBlank(pageNum) ){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("params must not be null.");
		}
		
		if(StrKit.isBlank(pageSize)){
			
			pageSize = "20";
		}*/
		
		SystemUser user = SystemUserUtil.getLoginUser(request);
		
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}else{
			List<Record> cvSetList =cvSetService.myStudyNew(user.getId(), NoApplyCredit, user.getUserProvinceId());
			log.warn("{} 查询我的学习记录。",user.getRealName());
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success").data(cvSetList);
		}
		
	}
	/**
	 * myCredit:我的学分
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/myCredit")
	public RtnBody myCredit(String pageNum,String pageSize){
		
		
		/*if(StrKit.isBlank(pageNum)){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("params must not be null.");
		}
		
		
		if(StrKit.isBlank(pageSize)){
			
			pageSize = "20";
		}*/
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		
		String domainName = request.getServerName(); //取到 域名地址

		//PageInfo<Record> page = cvSetService.myCredit(user.getId(),domainName,ApplyCreditState,user.getUserProvinceId(),pageNum,pageSize);
		List<Record> list = cvSetService.myCreditNew(user.getId(), domainName, ApplyCreditState, user.getUserProvinceId());
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success").data(list);
		
	}
	
	
	/**
	 * applyCredit:
	 * 申请学分
	 * @param  @param userId
	 * @param  @param learnId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@Transactional
	@RequestMapping("/applyCredit")
	public RtnBody applyCredit(String userId, String learnId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		String domainName = request.getServerName(); //取到 域名地址
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		RtnBody rtn = new RtnBody();
		List<LogStudyCvSet> logStudyList = logStudyCvSetService.listLogStudyByCvSetId(user.getId(), Integer.valueOf(learnId));
		if (logStudyList != null && logStudyList.size()>0) {
			LogStudyCvSet log = logStudyList.get(0);
			//如果项目学习记录表的状态为2(表示已学完)并且申请学分状态为1(表示未申请学分)
			if (log.getState() == BusinessConst.STUDY_HAVE_LEARN && log.getIsApplyCredit() == NoApplyCredit) {
				//修改项目学习记录表
				LogStudyCvSet logT = new LogStudyCvSet();
				logT.setId(log.getId());
				logT.setIsApplyCredit(ApplyCreditState);
				logT.setApplyDate(new Date());
				logStudyCvSetService.updateLogStudyCvSetById(logT);
				//向学分证书表中插入数据
				CvSet cvSet = cvSetService.getCvSetById(Integer.valueOf(learnId),user.getUserProvinceId(),domainName);
				CvDiploma diploma = new CvDiploma();
				diploma.setSystemUserId(user.getId());
				diploma.setIdNumber(user.getCertificateNo());
				diploma.setSystemUserName(user.getRealName());
				if (cvSet != null) {
					diploma.setItemNumber(cvSet.getCode());
					diploma.setItemName(cvSet.getName());
				}
				diploma.setApplyTime(DateUtil.format(new Date()));
				diploma.setIsDelete(0);
				String diplomaNumber = "";
				if (cvSet != null) {
					if (cvSet.getLevel() == 1) {
						diploma.setItemGrade("国家I类");
					} else if (cvSet.getLevel() == 2) {
						diploma.setItemGrade("省级I类");
					} else if (cvSet.getLevel() == 3) {
						diploma.setItemGrade("市级I类");
					} else if (cvSet.getLevel() == 4) {
						diploma.setItemGrade("省级II类");
					} else if (cvSet.getLevel() == 5) {
						diploma.setItemGrade("市级II类");
					}
					
					if (cvSet.getForma() == 1) {
				   		diploma.setItemType("远程");
				   		diplomaNumber = createSerial("XFYC",diploma.getApplyTime().substring(0,4), 6);
				   	} else if (cvSet.getForma() == 2) {
				   		diploma.setItemType("混合");
				   		diplomaNumber = createSerial("XFHH",diploma.getApplyTime().substring(0,4), 6);
				   	} else {
				   		diploma.setItemType("面授");
				   		diplomaNumber = createSerial("XFMS",diploma.getApplyTime().substring(0,4), 6);
				   	}
					diploma.setBeginTime(DateUtil.format(cvSet.getStartDate()));
					diploma.setEndTime(DateUtil.format(cvSet.getEndDate()));
					diploma.setItemScore(cvSet.getScore().toString());
				}
				diploma.setDiplomaNumber(diplomaNumber);
				diploma.setPathUrl(getUrl(request)+"?method=findT&diploma_number="+diploma.getDiplomaNumber());
				int result = cvDiplomaService.saveCvDiploma(diploma);
				if (result > 0) {
					return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("申请成功！");
				} else {
					return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("申请失败！");
				}
			} else {
				return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("该项目未学完或者已申请过学分！");
			}
		}
		return null;
	}

	/**
	 * certificate:
	 * 查看学分证书
	 * @param  @param userId
	 * @param  @param cvSetId
	 * @param  @param cvsetCode
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/certificate")
	public RtnBody certificate(String userId, String cvSetId, String cvsetCode){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		String domainName = request.getServerName(); //取到 域名地址
		//根据用户id和项目编号查询学分证书
		Record diploma = cvDiplomaService.getCvDiplomaByUserIdAndCode(user.getId(), Integer.valueOf(cvSetId), cvsetCode, 
																	user.getUserProvinceId(),domainName);
		if (diploma == null) {
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("未查询到此学员学分证书的相关记录！");
		}
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(diploma);
	}
	
	// 生产随机账号
    public static synchronized String createSerial(String sysFlg,String str, int randomCount){  
        safeSleep(1);  
        return sysFlg + str + RandomStringUtils.randomNumeric(randomCount);  
    }  
      
    public static void safeSleep(long millis) {  
        try {  
            Thread.sleep(millis);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    } 
    
    // 获取项目URL路径
 	public String getUrl(HttpServletRequest req){
 		return req.getServerName()+":"+req.getServerPort()+req.getContextPath()+req.getServletPath();
 	}
    
 	
 	/**
 	 * annualReport:
 	 * 年度学习报告
 	 * @param  @param year
 	 * @param  @return    
 	 * @return RtnBody    
 	 * @throws 
 	 * @since  　version 1.0
 	*/
 	@RequestMapping("/annualReport")
 	public RtnBody annualReport(String year) {
 		if(StrKit.isBlank(year)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("params must not be null.");
		}
 		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		String domainName = request.getServerName(); //取到 域名地址
		Record record = studyService.annualReport(user.getId(), Integer.valueOf(year), domainName);
 		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(record);
 	}
 	
 	/**
 	 * annualProjectReport:
 	 * 年度项目学习报告
 	 * @param  @param userId
 	 * @param  @param year
 	 * @param  @param pageNum
 	 * @param  @param pageSize
 	 * @param  @return    
 	 * @return RtnBody    
 	 * @throws 
 	 * @since  　version 1.0
 	*/
 	@RequestMapping("/annualProjectReport")
 	public RtnBody annualProjectReport(String userId, String year, String pageNum, String pageSize) {
 		RtnBody rtn = new RtnBody();
		//查询 page分页
		if (StrKit.isBlank(pageNum)) {// 当前页
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		if (StrKit.isBlank(pageSize)) {// 每页条数
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("每页面条数未指定！");
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		PageInfo<Record> projectReport = studyService.annualProjectReport(user.getId(), Integer.valueOf(year), pageNum, pageSize);
		String presentation = year+"/01/01~"+year+"/12/31";
 		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(projectReport).kvData("projectPresentation", presentation);
 	}
 	
 	/**
 	 * reportDetail:
 	 * 项目学习报告详情
 	 * @param  @param userId
 	 * @param  @param projectId
 	 * @param  @return    
 	 * @return RtnBody    
 	 * @throws 
 	 * @since  　version 1.0
 	*/
 	@RequestMapping("/reportDetail")
 	public RtnBody reportDetail(String userId, String projectId) {
 		RtnBody rtn = new RtnBody();
 		if (StrKit.isBlank(projectId)) {// 当前页
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("项目id不能为空！");
		}
 		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		Record record = studyService.reportDetail(user.getId(), Integer.valueOf(projectId));
 		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(record);
 	}
 	
 	/**
 	 * studyTime:
 	 * 学习时长折线图
 	 * @param  @param userId
 	 * @param  @param projectId
 	 * @param  @param year
 	 * @param  @param month
 	 * @param  @return    
 	 * @return RtnBody    
 	 * @throws 
 	 * @since  　version 1.0
 	*/
 	@RequestMapping("/studyTime")
 	public RtnBody studyTime(String userId, String projectId, String year, String month) {
 		RtnBody rtn = new RtnBody();
 		if (StrKit.isBlank(projectId)) {// 当前页
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("项目id不能为空！");
		}
 		if (StrKit.isBlank(year) || StrKit.isBlank(month)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("请检查输入参数！");
		}
 		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		List<Record> studyList = studyService.studyTime(user.getId(), Integer.valueOf(projectId), Integer.valueOf(year), Integer.valueOf(month));
		List<Integer> x = new ArrayList<Integer>();//x轴的值
		List<Double> y = new ArrayList<Double>();//y轴的值
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		int year1 = c.get(Calendar.YEAR);//当前年份
		int month1 = c.get(Calendar.MONTH)+1;//当前月份
		String date = "";
		if (studyList != null && studyList.size()>0) {
			Map<Integer,Double> map = new HashMap<Integer,Double>();
			for (Record r:studyList) {
				String d = (String)r.get("learnDate");
				Long m = Long.valueOf(r.get("learntime").toString());
				String[] dd = d.split("-");
				if(dd.length==3){
					map.put(Integer.parseInt(dd[2]), Double.parseDouble(m.toString()));
				}
			}
			int monthLength=0;
			String[] DDD = new String[2];
			if (studyList.size()!=0) {
				monthLength = Integer.valueOf(studyList.get(0).get("totalDay").toString());
			    DDD = ((String)studyList.get(0).get("learnDate")).split("-");
			}else{//默认当前日期
				c.set(Calendar.DATE, 1);
				c.roll(Calendar.DATE, -1);
				monthLength = c.getActualMaximum(Calendar.DATE);
				DDD[0] = String.valueOf(year1);
				DDD[1] = String.valueOf(month1);
			}
			for (int i = 1; i < monthLength+1; i++) { //添加x数据
				x.add(i);
			}
			Double yma= 0.0;
			for (int i = 1; i < monthLength+1; i++) {
				if (map.get(i)==null) {//添加y数据
					if (Integer.valueOf(year)==year1 && Integer.valueOf(month)==month1 && i>day) {//当前日期之后为学默认null
						y.add(null);
					}else {//当前日期之前为学默认0
						y.add(0.0);
					}
				}else {
					if(yma<map.get(i)){
						yma=map.get(i);
					}
					y.add(map.get(i));
				}
			}
			date = DDD[0]+"-"+DDD[1];
		} else {
			int maxDay = DateUtil.getMonthMaxDay(year+"-"+month+"-01 00:00:00");
			for (int i = 1; i < maxDay+1; i++) { //添加x数据
				x.add(i);
				if (Integer.valueOf(year)>year1 || (Integer.valueOf(year)==year1 && Integer.valueOf(month)>month1)) {
					y.add(null);
				} else {
					y.add(0.0);
				}
			}
			date = year+"-"+month;
		}
		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").kvData("xAsix", x).kvData("yAsix",y)
				.kvData("date", date);
 	}
}
