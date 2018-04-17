package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamExamOrg;

public interface ExamExamOrgMapper {
    int insert(ExamExamOrg record);

    int insertSelective(ExamExamOrg record);
}