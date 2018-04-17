package com.ncme.springboot.mapper;

import com.ncme.springboot.model.LogStudy;

public interface LogStudyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogStudy record);

    int insertSelective(LogStudy record);

    LogStudy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogStudy record);

    int updateByPrimaryKey(LogStudy record);
}