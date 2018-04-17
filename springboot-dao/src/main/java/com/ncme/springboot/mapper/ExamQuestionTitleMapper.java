package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestionTitle;

public interface ExamQuestionTitleMapper {
    int insert(ExamQuestionTitle record);

    int insertSelective(ExamQuestionTitle record);
}