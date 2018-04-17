package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CasePatient;

public interface CasePatientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CasePatient record);

    int insertSelective(CasePatient record);

    CasePatient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CasePatient record);

    int updateByPrimaryKey(CasePatient record);
}