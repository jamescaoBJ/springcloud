package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamIcdProp;

public interface ExamIcdPropMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamIcdProp record);

    int insertSelective(ExamIcdProp record);

    ExamIcdProp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamIcdProp record);

    int updateByPrimaryKey(ExamIcdProp record);
}