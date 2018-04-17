package com.wjw.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.auth.util.Token;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.MD5Util;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.footstone.util.VCUtil;
import com.ncme.springboot.model.LogStudyCvSet;
import com.ncme.springboot.model.SystemAccount;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.SystemUserService;
import com.wjw.util.SystemUserUtil;
import com.wjw.vo.Account;
import com.wjw.vo.Register;

/**
 * ClassName:SystemUserController
 * Function: 用户管理
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月14日	上午10:59:04
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/user")
public class SystemUserController extends Controller {
	@Autowired
	SystemUserService systemUserService;

	@RequestMapping("/userinfo")
	public RtnBody userinfo(String userId){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		Record userInfo = systemUserService.getUserinfo(user);
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(userInfo);
	}
	
	/**
	 * 
	 * accountInfo:
	 * TODO(个人账户信息)
	 *
	 * @param  @param userId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/accountInfo")
	public RtnBody accountInfo(String userId){
		SystemAccount account = Token.USER(request, SystemAccount.class);
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		Record record = new Record();
		record = systemUserService.getAccountInfo(user);
		
		record.put("userName", account.getAccountName());   			 //设置用户登录名称
		
		record.put("name", user.getRealName());							 //设置用户真实名称
		record.put("idCard", user.getCertificateNo());     				 //设置用户身份证号码
		record.put("phone", user.getMobilPhone());      				 //设置用户手机号码
		if (user.getSex() !=null && user.getSex()==1) {                  //用户性别 0:男  man 1:女female (数据库 1:男  2:女)
			record.put("sex", 0);      							 		 //设置用户性别
		} else if (user.getSex() !=null && user.getSex()==2){
			record.put("sex", 1);      						
		} else {
			record.put("sex", ""); 
		}
		record.put("practitionerNum", user.getHealthCertificate());      //设置执业医师号
		record.put("address", user.getHospitalAddress());				 //设置单位地址
		record.put("grassroot", user.getGrassroot());				 	 //设置用户是否来自基层 1:是  0:否(之前老数据为空)
		if (user.getEducation()!=null) {
			record.put("educationId", user.getEducation());              //设置学历ID
			switch (user.getEducation()) {
			case 1:
				record.put("education", "高中");
				break;
			case 2:
				record.put("education", "中专");
				break;
			case 3:
				record.put("education", "大专");
				break;
			case 4:
				record.put("education", "本科");
				break;
			case 5:
				record.put("education", "硕士");
				break;
			case 6:
				record.put("education", "博士");
				break;
			case 7:
				record.put("education", "博士后");
				break;
			case 8:
				record.put("education", "其它");
				break;
			default:
				record.put("education", "请选择");
				break;
			}
		} else {
			record.put("education", "请选择");
		}
		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(record);
	}
	
	/**
	 * 
	 * updateAccount:
	 * TODO(修改帐户信息)
	 *
	 * @param  @param upUser
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/updateAccount")
	public RtnBody updateAccount(Account acount){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		Record record = new Record();
		if (!StrKit.isBlank(acount.getPhone())) {										//用户手机号码
			user.setMobilPhone(acount.getPhone());
		}
		if (acount.getSex() != null && !"".equals(acount.getSex())) {					//用户性别 0:男  man 1:女female (数据库 1:男  2:女)
			if (acount.getSex()==0) {
				user.setSex(1);
			} else {
				user.setSex(2);
			}
		}
		if (!StrKit.isBlank(acount.getCompany())) {										//用户单位名称
			user.setOtherHospitalName(acount.getCompany());
		}
		if (acount.getCompanyId() != null && !"".equals(acount.getCompanyId())) {		//用户单位ID
			user.setWorkUnitId(acount.getCompanyId());
		} else {
			user.setWorkUnitId(null);
			user.setWorkUnit(null);
		}
		if (!StrKit.isBlank(acount.getAddress())) {										//用户单位地址
		
			user.setHospitalAddress(acount.getAddress());
		}
		if (!StrKit.isBlank(acount.getPractitionerNum())) {								//用户执业医师号
			user.setHealthCertificate(acount.getPractitionerNum());
		}
		if (acount.getEducationId() != null && !"".equals(acount.getEducationId())) {	//用户学历ID 例  3:大专
			user.setEducation(acount.getEducationId());
		}
		if (acount.getGrassroot()!=null) {												//用户是否来自基层  1:是  0:否
			user.setGrassroot(acount.getGrassroot());
		}
		if (acount.getEducationId()!=null) {
			user.setEducation(acount.getEducationId());
		} else {
			user.setEducation(null);
		}
		//修改用户帐户信息
		systemUserService.updateAccount(user,acount.getUserName(),acount.getProviceId(),acount.getCityId(),acount.getDistrictId(),acount.getTitleId(),acount.getSubjectId());
		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，修改成功！");
	}
	
	/**
	 * 
	 * checkPwdByPhone:
	 * TODO(修改手机号验证原密码)
	 *
	 * @param  @param userId
	 * @param  @param password
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/checkPwdByPhone")
	public RtnBody checkPwdByPhone(String userId,String password){
		RtnBody rtn = new RtnBody();
		if (StrKit.isBlank(userId)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空！");
		}
		if (StrKit.isBlank(password)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("用户密码不能为空！");
		} else {
			password = MD5Util.string2MD5(password);
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		Record record = new Record();
		if (userId.equals(user.getId().toString())) {
			//根据用户 userId 查询其 登录密码   status 返回值说明   100:输入为空值      1:输入的密码正确       0:输入值错误
			String pwd = "";
			pwd = systemUserService.getPassWordById(user.getId());
			if (pwd!=null && pwd.equals(password)) {
				return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，密码正确！");
			} else {
				return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("原密码不正确！");
			}
		} else {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不正确！");
		}
	}
	
	/**
	 * 
	 * updatePhone:
	 * TODO(修改用户手机号码)
	 *
	 * @param  @param userId
	 * @param  @param newPhone
	 * @param  @param code
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/updatePhone")
	public RtnBody updatePhone(String userId,String newPhone,String code){
		RtnBody rtn = new RtnBody();
		//判断用户ID是否为空
		if (StrKit.isBlank(userId)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空！");
		} 
		//判断用户ID是否正确
		//SystemAccount account = Token.USER(request, SystemAccount.class);
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (!userId.equals(user.getId().toString())) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不正确！");
		}
		//判断用户新手机号是否为空
		if (StrKit.isBlank(newPhone)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("新手机号不能为空！");
		} else {
			//判断新手机号是否注册过平台账号
			boolean isRegister = systemUserService.isRegister(userId,newPhone);
			if (isRegister) {
				return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("该手机号已被注册，请更换其他手机号！");
			} else {
				//根据手机号,判断输入的验证码是否在有效时间内(5分钟)
				int validTime = systemUserService.isValidTime(newPhone);
				if (validTime > 0) {
					return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("请输入正确的验证码！");
				}
			}
		}
		//TODO 判断验证码是否正确 --- 前端判断
		/*
		if (StrKit.isBlank(code)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("验证码不能为空！");
		} else {
			//判断验证码是否正确
			
		}*/
		//修改用户手机号码
		systemUserService.updatePhone(userId,newPhone);
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，修改手机号成功！");
	}
	
	
	
	/**
	 * 
	 * updatePassword:
	 * TODO(修改用户密码)
	 *
	 * @param  @param userId
	 * @param  @param updatePassword
	 * @param  @param commitPassword
	 * @param  @param code
	 * @param  @param Phone
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/updatePwd")
	public RtnBody updatePassword(String userId,String updatePassword,String code,String commitPassword,String Phone){
		RtnBody rtn = new RtnBody();
		//判断用户ID是否为空
		if (StrKit.isBlank(userId)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空！");
		} 
		//判断用户ID是否正确
		//SystemAccount account = Token.USER(request, SystemAccount.class);
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (!userId.equals(user.getId().toString())) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不正确！");
		}
		boolean isRegister = systemUserService.isRegister(userId,Phone);
		if (isRegister=false) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("请输入已注册的手机号进行验证！");
		}
		//判断用户修改密码是否为空
		if (StrKit.isBlank(updatePassword)) {
			
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("修改密码不能为空！");
		}else {
			updatePassword=MD5Util.string2MD5(updatePassword);
		}
		//判断用户确认密码是否为空
		if (StrKit.isBlank(commitPassword)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("确认密码不能为空！");
		}else {
			commitPassword=MD5Util.string2MD5(commitPassword);
		}
		//判断两次密码是否相同
		if (!updatePassword.equals(commitPassword)){
			return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("两次密码输入有误，请确认后重新输入");
		}
		/*else {
			//判断手机号是否注册过平台账号
			boolean isRegister = systemUserService.isRegister(userId,updatePassword);
			if (isRegister) {
				return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("该手机号已注册过！");
			}
		}*/
		//TODO 判断验证码是否正确 --- 前端判断
		/*
		if (StrKit.isBlank(code)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("验证码不能为空！");
		} else {
			//判断验证码是否正确
			
		}*/
		//修改用户账户密码
		systemUserService.updateSystemPassword(updatePassword,userId);
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，修改密码成功！");
	}
	
	
	
	
	/**
	 * 
	 * register:
	 * TODO(保存用户注册信息)
	 *
	 * @param  @param acount
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/register")
	public RtnBody register(Register acount){
		RtnBody rtn = new RtnBody();
		SystemUser user = new SystemUser();
		Record record = new Record();
		if (StrKit.isBlank(acount.getPhone())) {										//用户手机号码
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("手机号不能为空！");
		} else {
			//判断新手机号是否注册过平台账号
			boolean isRegister = systemUserService.isRegister("",acount.getPhone());
			if (isRegister) {
				return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("该手机号已注册过！");
			} else {
				user.setMobilPhone(acount.getPhone());
			}
		}
		//TODO 判断验证码是否正确 --- 前端判断
		/*
		if (StrKit.isBlank(code)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("验证码不能为空！");
		} else {
			//判断验证码是否正确
			
		}*/
		//根据手机号,判断输入的验证码是否在有效时间内(5分钟)
		int validTime = systemUserService.isValidTime(acount.getPhone());
		if (validTime > 0) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("请输入正确的验证码！");
		}
		
		if (acount.getDocumentType()!=null) {										    //用户证件类型
			user.setCertificateType(acount.getDocumentType());
		}
		if (!StrKit.isBlank(acount.getIdCard())) {										//用户证件号
			user.setCertificateNo(acount.getIdCard());
			//判断用户证件号是否注册过平台账号,若注册过,则不再注册,且提示:证件号已被注册，请登录. 
			boolean isRegister = systemUserService.isRegisterIdCard(acount.getDocumentType().toString(),acount.getIdCard());
			if (isRegister) {
				if (acount.getDocumentType()==1) {
					return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("身份证号已被使用！");
				} else if (acount.getDocumentType()==2) {
					return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("军官证已被使用！");
				} else if (acount.getDocumentType()==3) {
					return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("港澳/台通行证已被使用！");
				} else if (acount.getDocumentType()==4) {
					return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("护照已被使用！");
				} else {
					return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("身份证号已被使用！");
				}
			}
		}
		if (!StrKit.isBlank(acount.getName())) {										//用户真实姓名
			user.setRealName(acount.getName());
		}
		
		user.setSex(2);																	//用户性别 0:男  man 1:女female (数据库 1:男  2:女) 默认 2
		user.setStatus(1);																//用户状态 1:正常(默认)
		user.setRegDate(new Date());													//用户注册时间(默认值 当前时间)
		user.setLoginErrorNum(0);														//默认值 0
		user.setLoginErrorFirstTime(0l);												//默认值 0
		user.setLoginErrorLastTime(0l);													//默认值 0
		user.setLastUpdateDate(new Date());												//默认值 当前时间

		if (!StrKit.isBlank(acount.getCompany())) {										//用户单位名称
			user.setOtherHospitalName(acount.getCompany());
		}
		if (acount.getCompanyId() != null && !"".equals(acount.getCompanyId())) {		//用户单位ID
			user.setWorkUnitId(acount.getCompanyId());
		}
		
		
		if (acount.getEducationId() != null && !"".equals(acount.getEducationId())) {	//用户学历ID 例  3:大专
			user.setEducation(acount.getEducationId());
		}
		if (acount.getGrassroot()!=null) {												//用户是否来自基层  1:是  0:否
			user.setGrassroot(acount.getGrassroot());
		}
		if (acount.getJobType()!=null) {												//职务类型ID 例 1:医疗人员
			user.setUserType(acount.getJobType());
		}
		String passwordy = acount.getPassword();										//用户密码(Md5加密)
		String password="";
		if(passwordy!=null && !"".equals(passwordy)) {
			password=MD5Util.string2MD5(passwordy);
		} else {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("密码不能为空！");
		}
		//保存用户注册帐户信息
		systemUserService.saveAccount(user,user.getMobilPhone(),password,acount.getProviceId(),acount.getCityId(),acount.getDistrictId(),acount.getTitleId(),acount.getSubjectId());
		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，注册成功！");
	}
	
	/**
	 * 
	 * getVerificationCode:
	 * TODO(向用户发送验证码)
	 *
	 * @param  @param phone
	 * @param  @return
	 * @param  @throws Exception    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/sendmsg")
	protected RtnBody registercode(String phone,String act) throws Exception{
		RtnBody rtn = new RtnBody();
		Record record = new Record();
		//短信发送的内容
		StringBuffer content = null;
		String mobile_phone="";
		
		//获取要发送的手机号码
		if (StrKit.isBlank(phone)) {	
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("手机号不能为空！");
		} else {
			//判断新手机号是否注册过平台账号
			boolean isRegister = systemUserService.isRegister("",phone);
			if (act.equals("register")) {
				if (isRegister) {
					return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("手机号已被注册过！");
				} else {
					mobile_phone = phone;
				}
			} else if (act.equals("newPhone")) {
				if (isRegister) {
					return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("该手机号已被注册，请更换其他手机号！");
				} else {
					mobile_phone = phone;
				}
			} else if (act.equals("forgetpassword") || act.equals("updatePassword")) {
				if (isRegister) {
					mobile_phone = phone;
				} else {
					return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("不存在此用户！");
				}
			} else {
				mobile_phone = phone;
			}
		}
		//验证码类型(act) 注册验证码:register, 找回密码:forgetpassword, 修改个人信息新手机号验证码:newPhone, 修改密码:updatePassword
		if (StrKit.isBlank(act)) {										
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("验证码类型不能为空！");
		} else {
			switch (act) {
			case "register":
				content = new StringBuffer("欢迎注册中国继续医学教育网，您的手机动态验证码为：");
				break;
			case "forgetpassword":
				content = new StringBuffer("欢迎使用中国继续医学教育网密码找回服务，您的手机动态验证码为：");
				break;
			case "newPhone":
				//content = new StringBuffer("欢迎使用中国继续医学教育网手机号修改服务，您的手机动态验证码为：");
				content = new StringBuffer("验证码：");
				break;
			case "updatePassword":
				//content = new StringBuffer("欢迎使用中国继续医学教育网密码修改服务，您的手机动态验证码为：");
				content = new StringBuffer("验证码：");
				break;
			default:
				break;
			}
		}

		int yzm = (int)((Math.random()*9+1)*100000);
		content.append(yzm);
		if (act.equals("newPhone")) {
			content.append("，你正在中国继续医学教育网进行手机号修改，5分钟内输入有效，请勿将此码告诉他人。有问题请拨打 400-863-1000 ");
		} else if (act.equals("updatePassword")) {
			content.append("，你正在中国继续医学教育网进行密码修改，5分钟内输入有效，请勿将此码告诉他人。有问题请拨打 400-863-1000 ");
		} else {
			content.append("，5分钟有效，请立即填写！");
		}
			
		//判断手机号码是否合法
		if(mobile_phone!=null && !"".equals(mobile_phone)){
			//调用发送短信接口
			String sendResult = VCUtil.sendSMS(mobile_phone, content.toString(), "135", "");
			if(sendResult!=null && !"".equals(sendResult)){
				if("success".equals(sendResult)){
					record.put("yzm", yzm);
					//将验证码保存到 system_timeliness表中
					systemUserService.saveYzm(phone,yzm);
					return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取验证码成功").data(record);
				}else{
					return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("获取验证码失败");
				}
			}else{
				return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("获取验证码失败");
			}
		}else{
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("手机号不能为空");
		}
	}
	
	/**
	 * 
	 * resetPwd:
	 * TODO(找回密码,即重置密码)
	 *
	 * @param  @param phone
	 * @param  @param originalPassword
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/resetPwd")
	public RtnBody resetPwd(String phone, String originalPassword){
		RtnBody rtn = new RtnBody();
		if (StrKit.isBlank(phone)) {													//用户手机号
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("手机号不能为空！");
		} else {
			//判断新手机号是否注册过平台账号
			boolean isRegister = systemUserService.isRegister("",phone);
			if (!isRegister) {
				return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("不存在此用户！");
			}
		}	
									
		String password="";
		if (StrKit.isBlank(originalPassword)) {										    //用户密码
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("密码不能为空！");
		} else {
			password=MD5Util.string2MD5(originalPassword);								//用户密码(Md5加密)
		}

		//根据手机号,判断输入的验证码是否在有效时间内(5分钟)
		int validTime = systemUserService.isValidTime(phone);
		if (validTime > 0) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("请输入正确的验证码！");
		}
		
		//重置用户密码
		systemUserService.resetPwd(phone,password);
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，密码重置成功！");
	}	
	
	@RequestMapping("/idcardIsRegister")
	public RtnBody idcardIsRegister(String idCard,String documentType){
		RtnBody rtn = new RtnBody();
		if (StrKit.isBlank(idCard)) {													//用户证件号
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("证件号不能为空！");
		} else {
			//判断用户证件号是否注册过平台账号,若注册过,则不再注册,且提示:证件号已被注册，请登录. 
			boolean isRegister = systemUserService.isRegisterIdCard(documentType,idCard);
			if (isRegister) {
				if (documentType!=null && Integer.parseInt(documentType)==1) {
					rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("身份证号已被使用！").kvData("isRegister", "false");
				} else if (documentType!=null && Integer.parseInt(documentType)==2) {
					rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("军官证已被使用！").kvData("isRegister", "false");
				} else if (documentType!=null && Integer.parseInt(documentType)==3) {
					rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("港澳/台通行证已被使用！").kvData("isRegister", "false");
				} else if (documentType!=null && Integer.parseInt(documentType)==4) {
					rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("护照已被使用！").kvData("isRegister", "false");
				} else {
					rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("证件号已被注册！").kvData("isRegister", "false");
				}
			} else {
				rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("证件号可以注册！").kvData("isRegister", "true");
			}
		}
		return rtn;
	}
	
	@RequestMapping("/nameValidate")
	public RtnBody nameValidate(String userId,String userName){
		RtnBody rtn = new RtnBody();
		Record record = new Record();
		if (StrKit.isBlank(userId)) {												//用户ID
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空！");
		}
		if (StrKit.isBlank(userName)) {												//用户登录名
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("用户名不能为空！");
		}
		//判断用户名,即用户登录名称是否已存在
		boolean isExist = systemUserService.nameValidate(userId,userName);
		if (isExist) {
			return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("用户名已存在！").kvData("isExist", 1);
		} else {
			return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("用户名可用").kvData("isExist", 0);
		}
	}
	
	@RequestMapping(value="/myFavorite")
	public RtnBody getMyFavorite(String userId, String favType){
		RtnBody rtn = new RtnBody();
		if(StrKit.isBlank(userId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空！");
		}
		if(StrKit.isBlank(favType)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("查询类型不能为空！");
		}
		//查询 page分页
		String pageNum = getPara("pageNum"); // 当前页
		if (StrKit.isBlank(pageNum)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		String pageSize = getPara("pageSize", "20"); // 每页条数
		if (StrKit.isBlank(pageSize)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("每页面条数未指定！");
		}
		//SystemUser user = SystemUserUtil.getLoginUser(request);
		List<Record> list = new ArrayList<Record>();
		PageInfo<Record> page = new PageInfo<Record>();
		
		page = systemUserService.getMyFavorite(Integer.valueOf(userId), Integer.valueOf(favType), pageNum, pageSize);
		
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(page); 
	}
	
	@RequestMapping(value="/addCollection")
	public RtnBody addCollection(String userId, String projectId, String favType){
		RtnBody rtn = new RtnBody();
		if(StrKit.isBlank(userId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空！");
		}
		if(StrKit.isBlank(projectId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("查询类型不能为空！");
		}
		if(StrKit.isBlank(favType)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("查询类型不能为空！");
		}
		
		systemUserService.addCollection(Integer.valueOf(userId), Integer.valueOf(projectId), Integer.valueOf(favType));
		
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，收藏成功！"); 
	}
	
	@RequestMapping(value="/cancelCollection")
	public RtnBody cancelCollection(String userId, String projectId, String favType){
		
		RtnBody rtn = new RtnBody();
		if(StrKit.isBlank(userId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空！");
		}
		if(StrKit.isBlank(projectId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("查询类型不能为空！");
		}
		if(StrKit.isBlank(favType)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("查询类型不能为空！");
		}
		//SystemUser user = SystemUserUtil.getLoginUser(request);
		systemUserService.cancelCollection(Integer.valueOf(userId), Integer.valueOf(projectId), Integer.valueOf(favType));
		
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，取消收藏成功！"); 
	}
	
	@RequestMapping(value="/feedBack")
	public RtnBody saveFeedBack(String userId, String phone, String content, String systemType, String systemVersion, String site){
		RtnBody rtn = new RtnBody();
		Map<String,Object> map=new HashMap<String, Object>();
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (StrKit.isBlank(userId)) {
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("用户ID不能为空！");
		} 
		if (!StrKit.isBlank(phone)){
			map.put("phone", phone);
		} else {
			map.put("phone", null);
		}
		if (!StrKit.isBlank(content)){
			map.put("content", content);
		} else {
			map.put("content", null);
		}
		if (!StrKit.isBlank(systemType)){
			map.put("systemType", systemType);
		} else {
			map.put("systemType", null);
		}
		if (!StrKit.isBlank(systemVersion)){
			map.put("systemVersion", systemVersion);
		} else {
			map.put("systemVersion", null);
		}
		if (!StrKit.isBlank(site)){
			map.put("site", site);
		} else {
			map.put("site", null);
		}

		if (!StrKit.isBlank(user.getAccountName())){
			map.put("creater", user.getAccountName());
			map.put("userId", user.getId());
		} else {
			map.put("creater", null);
			map.put("userId", userId);
		}
		map.put("state", 1);
		int no = systemUserService.saveFeedBack(map);
		if (no>0) {
			return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("反馈成功！"); 
		} else {
			return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("反馈失败！"); 
		}
			
	}
}
