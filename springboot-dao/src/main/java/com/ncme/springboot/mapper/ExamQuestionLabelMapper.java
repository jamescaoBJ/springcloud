package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestionLabel;

public interface ExamQuestionLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamQuestionLabel record);

    int insertSelective(ExamQuestionLabel record);

    ExamQuestionLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamQuestionLabel record);

    int updateByPrimaryKey(ExamQuestionLabel record);
}