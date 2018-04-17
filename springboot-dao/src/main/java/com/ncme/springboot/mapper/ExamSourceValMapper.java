package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamSourceVal;

public interface ExamSourceValMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamSourceVal record);

    int insertSelective(ExamSourceVal record);

    ExamSourceVal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamSourceVal record);

    int updateByPrimaryKey(ExamSourceVal record);
}