package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvSetOrg;

public interface CvSetOrgMapper {
    int insert(CvSetOrg record);

    int insertSelective(CvSetOrg record);
}