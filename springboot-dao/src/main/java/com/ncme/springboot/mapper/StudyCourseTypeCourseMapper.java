package com.ncme.springboot.mapper;

import com.ncme.springboot.model.StudyCourseTypeCourse;

public interface StudyCourseTypeCourseMapper {
    int insert(StudyCourseTypeCourse record);

    int insertSelective(StudyCourseTypeCourse record);
}