package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeSubjectCourse;

public interface NcmeSubjectCourseMapper {
    int insert(NcmeSubjectCourse record);

    int insertSelective(NcmeSubjectCourse record);
}