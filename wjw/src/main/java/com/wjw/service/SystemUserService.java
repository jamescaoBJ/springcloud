package com.wjw.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.SystemAccount;
import com.ncme.springboot.model.SystemLoginLimit;
import com.ncme.springboot.model.SystemUser;
import com.ncme.springboot.model.SystemUserConfig;

public interface SystemUserService {

	/**
	 * getSystemUserByAccountName:
	 * 根据账号名查询用户信息
	 * @param  @param accountName
	 * @param  @return    
	 * @return SystemUser    
	 * @throws 
	 * @since  　version 1.0
	*/
	SystemUser getSystemUserByAccountName(String accountName);
	
	/**
	 * getConfigByUserId:
	 * 根据用户id查询用户地址信息
	 * @param  @param userId
	 * @param  @return    
	 * @return SystemUserConfig    
	 * @throws 
	 * @since  　version 1.0
	*/
	SystemUserConfig getConfigByUserId(Integer userId);
	
	/**
	 * getUserinfo:
	 * 个人信息查询
	 * @param  @param user
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	Record getUserinfo(SystemUser user);
	
	/**
	 * 
	 * getAccountInfo:
	 * TODO(账户信息)
	 *
	 * @param  @param user
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getAccountInfo(SystemUser user);
	
	/**
	 * 
	 * updateAccount:
	 * TODO(修改帐户信息)
	 *
	 * @param  @param user
	 * @param  @param userName
	 * @param  @param proviceId
	 * @param  @param titleId
	 * @param  @param subjectId    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void updateAccount(SystemUser user,String userName,String proviceId,String cityId,String districtId,String titleId,String subjectId);


	/**
	 * 
	 * updatePhone:
	 * TODO(修改用户密码)
	 *
	 * @param  @param userId
	 * @param  @param userPassword    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void updateSystemPassword(String userPassword,String userId);

	/**
	 * 
	 * getPassWordById:
	 * TODO(根据用户 userId 查询其 登录密码)
	 *
	 * @param  @param userId
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	 */
	String getPassWordById(Integer userId);
	
	/**
	 * 
	 * isRegister:
	 * TODO(判断新手机号是否注册过平台账号)
	 *
	 * @param  @param userId
	 * @param  @param newPhone
	 * @param  @return    
	 * @return boolean    
	 * @throws 
	 * @since  　version 1.0
	 */
	boolean isRegister(String userId,String newPhone);

	/**
	 * 
	 * isRegister:
	 * TODO(判断用户证件号是否注册过平台账号)
	 *
	 * @param  @param userId
	 * @param  @param newPhone
	 * @param  @return    
	 * @return boolean    
	 * @throws 
	 * @since  　version 1.0
	 */
	boolean isRegisterIdCard(String userId,String idCard);
	
	/**
	 * 
	 * updatePhone:
	 * TODO(修改用户手机号码)
	 *
	 * @param  @param userId
	 * @param  @param newPhone    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void updatePhone(String userId,String newPhone);
	
	/**
	 * 
	 * saveAccount:
	 * TODO(保存用户注册帐户信息)
	 *
	 * @param  @param user
	 * @param  @param userName
	 * @param  @param proviceId
	 * @param  @param cityId
	 * @param  @param districtId
	 * @param  @param titleId
	 * @param  @param subjectId    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void saveAccount(SystemUser user,String userName,String password,String proviceId,String cityId,String districtId,String titleId,String subjectId);

	/**
	 * getLoginLimter:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return SystemLoginLimit    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	SystemLoginLimit getLoginLimter();

	/**
	 * updateLoginErrors:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param user    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	int updateLoginErrors(SystemUser user);

	/**
	 * 
	 * resetPwd:
	 * TODO(找回密码,即重置密码)
	 *
	 * @param  @param phone
	 * @param  @param originalPassword    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void resetPwd(String phone, String originalPassword);
	
	/**
	 * 
	 * getAllUser:
	 * TODO(定时任务自动推送-获取系统所用用户ID)
	 *
	 * @param  @return    
	 * @return List<SystemUser>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<SystemUser> getAllUser();
	
	/**
	 * 
	 * getMyStudys:
	 * 根据用户ID 及 (所学习项目)未申请学分,获取其学习项目
	 *
	 * @param  @param userId
	 * @param  @param isApplyCredit
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getMyStudys(Integer userId, Integer isApplyCredit);

	/**
	 * 
	 * getSignUpCvLive:
	 * 根据用户ID,获取用户已报名的直播课程
	 *
	 * @param  @param userId
	 * @param  @param isApplyCredit
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getSignUpCvLive(Integer userId, Integer isApplyCredit);
	
	/**
	 * 
	 * checkAlreadySend:
	 * 检测消息是否已推送过
	 *
	 * @param  @param userId
	 * @param  @param msgContent
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	 */
	int checkAlreadySend(Integer userId,String msgContent);
	

	SystemAccount getSystemAccountByWeiXinId(String openid); 
	
	/**
	 * 
	 * saveYzm:
	 * TODO(保存验证码)
	 *
	 * @param  @param phone
	 * @param  @param yzm    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void saveYzm(String phone, Integer yzm);
	
	/**
	 * 
	 * isValidTime:
	 * TODO(根据手机号,判断输入的验证码是否在有效时间内(5分钟))
	 *
	 * @param  @param phone
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	 */
	int isValidTime(String phone);
	
	/**
	 * updateOpenIdByAccountId:
	 * 将openid和系统账号信息进行关联
	 * @param  @param accountId
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	int updateOpenIdByUserId(String openid,Integer userId);
	
	/**
	 * 
	 * nameValidate:
	 * 判断用户名,即用户登录名称是否已存在
	 *
	 * @param  @param userId
	 * @param  @param newPhone
	 * @param  @return    
	 * @return boolean    
	 * @throws 
	 * @since  　version 1.0
	 */
	boolean nameValidate(String userId,String userName);
	
	/**
	 * 
	 * getMyFavorite:
	 * 获取用户的收藏列表
	 *
	 * @param  @param userId
	 * @param  @param favType
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	PageInfo<Record> getMyFavorite(Integer userId,Integer favType, String pageCurrent, String pageSize);
	
	/**
	 * 
	 * addCollection:
	 * 保存收藏
	 *
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @param favType    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void addCollection(Integer userId,Integer projectId,Integer favType);
	
	/**
	 * 
	 * cancelCollection:
	 * 取消收藏
	 *
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @param favType    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void cancelCollection(Integer userId,Integer projectId,Integer favType);
	
	/**
	 * 
	 * saveFeedBack:
	 * 保存用户反馈
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	 */
	int saveFeedBack(Map<String, Object> map);
	
}
