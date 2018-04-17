package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemClient;

public interface SystemClientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemClient record);

    int insertSelective(SystemClient record);

    SystemClient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemClient record);

    int updateByPrimaryKey(SystemClient record);
}