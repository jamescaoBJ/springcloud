package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamExamTypeBak;

public interface ExamExamTypeBakMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamExamTypeBak record);

    int insertSelective(ExamExamTypeBak record);

    ExamExamTypeBak selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamExamTypeBak record);

    int updateByPrimaryKey(ExamExamTypeBak record);
}