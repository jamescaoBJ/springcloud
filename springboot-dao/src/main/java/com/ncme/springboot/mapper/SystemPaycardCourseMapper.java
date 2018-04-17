package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemPaycardCourse;

public interface SystemPaycardCourseMapper {
    int insert(SystemPaycardCourse record);

    int insertSelective(SystemPaycardCourse record);
}