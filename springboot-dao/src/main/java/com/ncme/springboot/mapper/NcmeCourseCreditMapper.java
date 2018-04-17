package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeCourseCredit;

public interface NcmeCourseCreditMapper {
    int insert(NcmeCourseCredit record);

    int insertSelective(NcmeCourseCredit record);
}