package com.ncme.springboot.mapper;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.model.SystemAccount;

public interface SystemAccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(SystemAccount record);

    int insertSelective(SystemAccount record);

    SystemAccount selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(SystemAccount record);

    int updateByPrimaryKey(SystemAccount record);

	/**
	 * selectByUsername:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param username
	 * @param  @return    
	 * @return SystemAccount    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	SystemAccount selectByUsername(String username);


	SystemAccount getAccountByOpenId(String openid);
	
	int updateOpenIdByAccountId(@Param("openid")String openid,@Param("userId")Integer userId);
}