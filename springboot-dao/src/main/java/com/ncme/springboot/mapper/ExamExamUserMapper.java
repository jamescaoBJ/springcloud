package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamExamUser;

public interface ExamExamUserMapper {
    int insert(ExamExamUser record);

    int insertSelective(ExamExamUser record);
}