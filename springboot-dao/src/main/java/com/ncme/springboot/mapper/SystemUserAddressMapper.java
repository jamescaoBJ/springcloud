package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemUserAddress;

public interface SystemUserAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemUserAddress record);

    int insertSelective(SystemUserAddress record);

    SystemUserAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemUserAddress record);

    int updateByPrimaryKey(SystemUserAddress record);
}