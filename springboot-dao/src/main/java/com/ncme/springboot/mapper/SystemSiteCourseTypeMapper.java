package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemSiteCourseType;

public interface SystemSiteCourseTypeMapper {
    int insert(SystemSiteCourseType record);

    int insertSelective(SystemSiteCourseType record);
}