package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeCourseList;

public interface NcmeCourseListMapper {
    int insert(NcmeCourseList record);

    int insertSelective(NcmeCourseList record);
}