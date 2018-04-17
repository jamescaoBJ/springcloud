package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestionBak;

public interface ExamQuestionBakMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamQuestionBak record);

    int insertSelective(ExamQuestionBak record);

    ExamQuestionBak selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamQuestionBak record);

    int updateByPrimaryKey(ExamQuestionBak record);
}