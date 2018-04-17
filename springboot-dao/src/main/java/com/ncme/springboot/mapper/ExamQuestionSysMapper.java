package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestionSys;

public interface ExamQuestionSysMapper {
    int insert(ExamQuestionSys record);

    int insertSelective(ExamQuestionSys record);
}