package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemExpress;

public interface SystemExpressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemExpress record);

    int insertSelective(SystemExpress record);

    SystemExpress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemExpress record);

    int updateByPrimaryKey(SystemExpress record);
}