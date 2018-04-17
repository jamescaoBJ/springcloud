package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemCourseType;

public interface SystemCourseTypeMapper {
    int insert(SystemCourseType record);

    int insertSelective(SystemCourseType record);
}