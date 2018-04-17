package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestionUnit;

public interface ExamQuestionUnitMapper {
    int insert(ExamQuestionUnit record);

    int insertSelective(ExamQuestionUnit record);
}