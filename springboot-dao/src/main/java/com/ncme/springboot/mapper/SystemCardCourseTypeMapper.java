package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemCardCourseType;

public interface SystemCardCourseTypeMapper {
    int insert(SystemCardCourseType record);

    int insertSelective(SystemCardCourseType record);
}