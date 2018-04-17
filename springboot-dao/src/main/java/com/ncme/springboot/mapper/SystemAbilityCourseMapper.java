package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemAbilityCourse;

public interface SystemAbilityCourseMapper {
    int insert(SystemAbilityCourse record);

    int insertSelective(SystemAbilityCourse record);
}