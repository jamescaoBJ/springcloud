package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemLoginLimit;
import com.ncme.springboot.model.SystemUser;

public interface SystemLoginLimitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemLoginLimit record);

    int insertSelective(SystemLoginLimit record);

    SystemLoginLimit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemLoginLimit record);

    int updateByPrimaryKey(SystemLoginLimit record);

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
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	int updateLoginErrors(SystemUser user);
}