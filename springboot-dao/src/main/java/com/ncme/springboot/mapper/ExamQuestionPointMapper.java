package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestionPoint;

public interface ExamQuestionPointMapper {
    int insert(ExamQuestionPoint record);

    int insertSelective(ExamQuestionPoint record);
}