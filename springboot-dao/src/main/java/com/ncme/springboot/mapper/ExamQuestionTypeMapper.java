package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestionType;

public interface ExamQuestionTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamQuestionType record);

    int insertSelective(ExamQuestionType record);

    ExamQuestionType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamQuestionType record);

    int updateByPrimaryKey(ExamQuestionType record);
}