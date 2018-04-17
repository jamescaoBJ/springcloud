package com.ncme.springboot.mapper;

import com.ncme.springboot.model.YhkQuestionProp;

public interface YhkQuestionPropMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YhkQuestionProp record);

    int insertSelective(YhkQuestionProp record);

    YhkQuestionProp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YhkQuestionProp record);

    int updateByPrimaryKey(YhkQuestionProp record);
}