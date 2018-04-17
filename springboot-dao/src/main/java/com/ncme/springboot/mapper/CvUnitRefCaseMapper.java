package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvUnitRefCase;

public interface CvUnitRefCaseMapper {
    int insert(CvUnitRefCase record);

    int insertSelective(CvUnitRefCase record);
}