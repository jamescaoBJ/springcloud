package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CasePatientDiagnosis;

public interface CasePatientDiagnosisMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CasePatientDiagnosis record);

    int insertSelective(CasePatientDiagnosis record);

    CasePatientDiagnosis selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CasePatientDiagnosis record);

    int updateByPrimaryKey(CasePatientDiagnosis record);
}