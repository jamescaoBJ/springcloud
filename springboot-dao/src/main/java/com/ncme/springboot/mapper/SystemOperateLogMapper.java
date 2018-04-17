package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemOperateLog;

public interface SystemOperateLogMapper {
    int deleteByPrimaryKey(Integer operateId);

    int insert(SystemOperateLog record);

    int insertSelective(SystemOperateLog record);

    SystemOperateLog selectByPrimaryKey(Integer operateId);

    int updateByPrimaryKeySelective(SystemOperateLog record);

    int updateByPrimaryKey(SystemOperateLog record);
}