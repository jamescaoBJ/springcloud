package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamExamination;

public interface ExamExaminationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamExamination record);

    int insertSelective(ExamExamination record);

    ExamExamination selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamExamination record);

    int updateByPrimaryKey(ExamExamination record);
}