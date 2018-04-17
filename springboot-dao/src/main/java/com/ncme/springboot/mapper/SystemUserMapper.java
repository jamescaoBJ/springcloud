package com.ncme.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.SystemUser;

public interface SystemUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);

	/**
	 * getItemByAccountName:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param string
	 * @param  @param object
	 * @param  @return    
	 * @return SystemUser    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	SystemUser getItemByAccountName(String accountName);
	
	/**
	 * 
	 * getPassWordById:
	 * TODO(查询用户密码)
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
	 * getDutyByUserId:
	 * TODO(查询用户 职称名称 职称ID)
	 *
	 * @param  @param userId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getDutyByUserId(Integer userId);

	/**
	 * 
	 * getSsqByUserId:
	 * TODO(查询用户所在省市区名称及ID)
	 *
	 * @param  @param userId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getSsqByUserId(Integer userId);
	
	/**
	 * 
	 * updateSystemAccount:
	 * TODO(更新用户登录名称)
	 *
	 * @param  @param userName    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void updateSystemAccount(@Param("userName") String userName, @Param("userId") Integer userId);
	
	/**
	 * 
	 * updateSystemAccount:
	 * TODO(修改用户登录密码)
	 *
	 * @param  @param userPassword    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	
	void updateSystemPassword(@Param("userPassword") String userPassword, @Param("userId") String userId);
	
	/**
	 * 
	 * updateSsq:
	 * TODO(更新用户省市区)
	 *
	 * @param  @param proviceId
	 * @param  @param cityId
	 * @param  @param districtId
	 * @param  @param userId    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void updateSsq(@Param("proviceId") String proviceId,@Param("cityId") String cityId,@Param("districtId") String districtId,@Param("userId") Integer userId);
	
	/**
	 * 
	 * updateSsq:
	 * TODO(更新用户职称)
	 *
	 * @param  @param titleId
	 * @param  @param userId    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void updateTitle(@Param("titleId") String titleId,@Param("userId") Integer userId);
	
	/**
	 * 
	 * updateSubjectId:
	 * TODO(更新用户学科--先删除)
	 *
	 * @param  @param subjectId
	 * @param  @param userId    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void updateSubjectIdDelete(@Param("subjectId") String subjectId,@Param("userId") Integer userId);
	
	/**
	 * 
	 * updateSubjectId:
	 * TODO(更新用户学科--再更新)
	 *
	 * @param  @param subjectId
	 * @param  @param userId    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void updateSubjectId(@Param("subjectId") String subjectId,@Param("userId") Integer userId);
	
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
	int isRegister(@Param("userId") String userId,@Param("newPhone") String newPhone);

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
	int isRegisterIdCard(@Param("userId") String userId,@Param("idCard") String idCard);
	
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
	void updatePhone(@Param("userId") String userId,@Param("newPhone") String newPhone);
	
	/**
	 * 
	 * getAccountByPhone:
	 * TODO(根据手机号码获取用户基本信息)
	 *
	 * @param  @param phone
	 * @param  @return    
	 * @return SystemUser    
	 * @throws 
	 * @since  　version 1.0
	 */
	SystemUser getAccountByPhone(String phone);
	
	/**
	 * 
	 * updateSystemAccount:
	 * TODO(保存用户登录名称)
	 *
	 * @param  @param userName    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void saveSystemAccount(@Param("userName") String userName, @Param("userId") Integer userId,@Param("password") String password);
	
	/**
	 * 
	 * saveSsq:
	 * TODO(保存用户省市区)
	 *
	 * @param  @param proviceId
	 * @param  @param cityId
	 * @param  @param districtId
	 * @param  @param userId    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void saveSsq(@Param("proviceId") String proviceId,@Param("cityId") String cityId,@Param("districtId") String districtId,@Param("userId") Integer userId);
	
	/**
	 * 
	 * saveTitle:
	 * TODO(保存用户职称)
	 *
	 * @param  @param titleId
	 * @param  @param userId    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void saveTitle(@Param("titleId") String titleId,@Param("userId") Integer userId);
	
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
	void resetPwd(@Param("phone") String phone, @Param("originalPassword") String originalPassword);
	
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
	List<Record> getMyStudys(@Param("userId")Integer userId, @Param("isApplyCredit")Integer isApplyCredit);
	
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
	List<Record> getSignUpCvLive(@Param("userId")Integer userId, @Param("isApplyCredit")Integer isApplyCredit);
	
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
	int checkAlreadySend(@Param("userId") Integer userId,@Param("msgContent") String msgContent);
	
	/**
	 * 
	 * getYzm:
	 * TODO(判断该手机号是否已获取过验证码)
	 *
	 * @param  @param phone
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	 */
	int getYzmByPhone(@Param("phone") String phone);
	
	/**
	 * 
	 * updateYzmByPhone:
	 * TODO(更新该手机号下的验证码)
	 *
	 * @param  @param phone
	 * @param  @param yzm    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void updateYzmByPhone(@Param("phone") String phone,@Param("yzm") Integer yzm,@Param("cur") String cur);
	
	/**
	 * 
	 * saveYzmByPhone:
	 * TODO(保存验证码)
	 *
	 * @param  @param phone
	 * @param  @param yzm    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void saveYzmByPhone(@Param("phone") String phone,@Param("yzm") Integer yzm,@Param("cur") String cur);
	
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
	int isValidTime(@Param("phone") String phone);
	
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
	int nameValidate(@Param("userId") String userId,@Param("userName") String userName);
	
	/**
	 * 
	 * getMyFavoriteByProject:
	 * 获取用户的收藏列表（项目）
	 *
	 * @param  @param userId
	 * @param  @param favType
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getMyFavoriteByProject(@Param("userId")Integer userId, @Param("favType")Integer favType);
	
	/**
	 * 
	 * getMyFavorite:
	 * 获取用户的收藏列表（课程）
	 *
	 * @param  @param userId
	 * @param  @param favType
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getMyFavorite(@Param("userId")Integer userId, @Param("favType")Integer favType);
	
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
	void addCollection(@Param("userId")Integer userId, @Param("projectId")Integer projectId, @Param("favType")Integer favType);

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
	void cancelCollection(@Param("userId")Integer userId, @Param("projectId")Integer projectId, @Param("favType")Integer favType);
	
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