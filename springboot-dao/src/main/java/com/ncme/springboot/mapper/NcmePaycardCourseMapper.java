package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmePaycardCourse;

public interface NcmePaycardCourseMapper {
    int insert(NcmePaycardCourse record);

    int insertSelective(NcmePaycardCourse record);
}