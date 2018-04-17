package com.ncme.springboot.mapper;

import com.ncme.springboot.model.OlemQuestionProp;

public interface OlemQuestionPropMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OlemQuestionProp record);

    int insertSelective(OlemQuestionProp record);

    OlemQuestionProp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OlemQuestionProp record);

    int updateByPrimaryKey(OlemQuestionProp record);
}