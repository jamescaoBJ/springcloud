package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CaseCourseDiagnosis;

public interface CaseCourseDiagnosisMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CaseCourseDiagnosis record);

    int insertSelective(CaseCourseDiagnosis record);

    CaseCourseDiagnosis selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CaseCourseDiagnosis record);

    int updateByPrimaryKey(CaseCourseDiagnosis record);
}