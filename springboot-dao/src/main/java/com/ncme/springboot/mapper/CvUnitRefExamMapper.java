package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvUnitRefExam;

public interface CvUnitRefExamMapper {
    int insert(CvUnitRefExam record);

    int insertSelective(CvUnitRefExam record);
}