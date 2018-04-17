package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CasePatientPropVal;

public interface CasePatientPropValMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CasePatientPropVal record);

    int insertSelective(CasePatientPropVal record);

    CasePatientPropVal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CasePatientPropVal record);

    int updateByPrimaryKey(CasePatientPropVal record);
}