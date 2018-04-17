package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestionIcd10;

public interface ExamQuestionIcd10Mapper {
    int insert(ExamQuestionIcd10 record);

    int insertSelective(ExamQuestionIcd10 record);
}