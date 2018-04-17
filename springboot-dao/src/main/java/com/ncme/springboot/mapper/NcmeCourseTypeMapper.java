package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeCourseType;

public interface NcmeCourseTypeMapper {
    int insert(NcmeCourseType record);

    int insertSelective(NcmeCourseType record);
}