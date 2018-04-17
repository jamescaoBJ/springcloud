package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemUserType;

public interface SystemUserTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemUserType record);

    int insertSelective(SystemUserType record);

    SystemUserType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemUserType record);

    int updateByPrimaryKey(SystemUserType record);
}