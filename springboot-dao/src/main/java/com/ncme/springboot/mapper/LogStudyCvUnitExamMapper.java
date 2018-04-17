package com.ncme.springboot.mapper;

import com.ncme.springboot.model.LogStudyCvUnitExam;

public interface LogStudyCvUnitExamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogStudyCvUnitExam record);

    int insertSelective(LogStudyCvUnitExam record);

    LogStudyCvUnitExam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogStudyCvUnitExam record);

    int updateByPrimaryKey(LogStudyCvUnitExam record);
}