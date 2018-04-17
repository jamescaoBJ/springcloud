package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamIcdPropVal;

public interface ExamIcdPropValMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamIcdPropVal record);

    int insertSelective(ExamIcdPropVal record);

    ExamIcdPropVal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamIcdPropVal record);

    int updateByPrimaryKey(ExamIcdPropVal record);
}