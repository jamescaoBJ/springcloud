package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamExamType;

public interface ExamExamTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamExamType record);

    int insertSelective(ExamExamType record);

    ExamExamType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamExamType record);

    int updateByPrimaryKey(ExamExamType record);
}