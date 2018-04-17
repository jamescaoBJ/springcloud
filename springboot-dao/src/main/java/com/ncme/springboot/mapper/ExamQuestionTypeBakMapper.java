package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestionTypeBak;

public interface ExamQuestionTypeBakMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamQuestionTypeBak record);

    int insertSelective(ExamQuestionTypeBak record);

    ExamQuestionTypeBak selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamQuestionTypeBak record);

    int updateByPrimaryKey(ExamQuestionTypeBak record);
}