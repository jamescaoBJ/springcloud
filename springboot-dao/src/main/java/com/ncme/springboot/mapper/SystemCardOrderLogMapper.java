package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemCardOrderLog;

public interface SystemCardOrderLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemCardOrderLog record);

    int insertSelective(SystemCardOrderLog record);

    SystemCardOrderLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemCardOrderLog record);

    int updateByPrimaryKey(SystemCardOrderLog record);
}