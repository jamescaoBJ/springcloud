package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeExamOrgproject;

public interface IcmeExamOrgprojectMapper {
    int insert(IcmeExamOrgproject record);

    int insertSelective(IcmeExamOrgproject record);
}