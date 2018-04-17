package com.ncme.springboot.mapper;

import com.ncme.springboot.model.LogExamResult;
import com.ncme.springboot.model.LogExamResultKey;

public interface LogExamResultMapper {
    int deleteByPrimaryKey(LogExamResultKey key);

    int insert(LogExamResult record);

    int insertSelective(LogExamResult record);

    LogExamResult selectByPrimaryKey(LogExamResultKey key);

    int updateByPrimaryKeySelective(LogExamResult record);

    int updateByPrimaryKey(LogExamResult record);
}