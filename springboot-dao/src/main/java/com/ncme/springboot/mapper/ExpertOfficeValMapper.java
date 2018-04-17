package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExpertOfficeVal;

public interface ExpertOfficeValMapper {
    int insert(ExpertOfficeVal record);

    int insertSelective(ExpertOfficeVal record);
}