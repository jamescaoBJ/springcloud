package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemBugLog;

public interface SystemBugLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemBugLog record);

    int insertSelective(SystemBugLog record);

    SystemBugLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemBugLog record);

    int updateByPrimaryKey(SystemBugLog record);
}