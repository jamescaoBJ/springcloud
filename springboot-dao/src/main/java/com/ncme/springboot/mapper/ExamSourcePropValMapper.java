package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamSourcePropVal;

public interface ExamSourcePropValMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamSourcePropVal record);

    int insertSelective(ExamSourcePropVal record);

    ExamSourcePropVal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamSourcePropVal record);

    int updateByPrimaryKey(ExamSourcePropVal record);
}