package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestionCognize;

public interface ExamQuestionCognizeMapper {
    int insert(ExamQuestionCognize record);

    int insertSelective(ExamQuestionCognize record);
}