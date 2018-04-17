package com.ncme.springboot.mapper;

import com.ncme.springboot.model.WszgQuestionProp;

public interface WszgQuestionPropMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WszgQuestionProp record);

    int insertSelective(WszgQuestionProp record);

    WszgQuestionProp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WszgQuestionProp record);

    int updateByPrimaryKey(WszgQuestionProp record);
}