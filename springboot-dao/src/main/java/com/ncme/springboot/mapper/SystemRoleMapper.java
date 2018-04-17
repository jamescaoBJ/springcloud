package com.ncme.springboot.mapper;

import java.util.List;

import com.ncme.springboot.model.SystemRole;

public interface SystemRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SystemRole record);

    int insertSelective(SystemRole record);

    SystemRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SystemRole record);

    int updateByPrimaryKey(SystemRole record);

	/**
	 * findRolesByUserId:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param accountId
	 * @param  @return    
	 * @return List<SystemRole>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<SystemRole> findRolesByUserId(Integer accountId);
}