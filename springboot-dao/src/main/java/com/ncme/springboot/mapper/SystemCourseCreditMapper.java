package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemCourseCredit;

public interface SystemCourseCreditMapper {
    int insert(SystemCourseCredit record);

    int insertSelective(SystemCourseCredit record);
}