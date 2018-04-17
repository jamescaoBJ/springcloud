package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemUserConfig;

public interface SystemUserConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemUserConfig record);

    int insertSelective(SystemUserConfig record);

    SystemUserConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemUserConfig record);

    int updateByPrimaryKey(SystemUserConfig record);
    
    /**
     * selectByUserId:
     * 根据用户id查询用户地址等信息
     * @param  @param userId
     * @param  @return    
     * @return SystemUserConfig    
     * @throws 
     * @since  　version 1.0
    */
    SystemUserConfig selectByUserId(Integer userId);
}