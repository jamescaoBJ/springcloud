package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeCourseSystem;

public interface NcmeCourseSystemMapper {
    int insert(NcmeCourseSystem record);

    int insertSelective(NcmeCourseSystem record);
}