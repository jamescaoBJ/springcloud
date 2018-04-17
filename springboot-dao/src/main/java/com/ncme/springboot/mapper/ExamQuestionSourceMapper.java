package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestionSourceKey;

public interface ExamQuestionSourceMapper {
    int deleteByPrimaryKey(ExamQuestionSourceKey key);

    int insert(ExamQuestionSourceKey record);

    int insertSelective(ExamQuestionSourceKey record);
}