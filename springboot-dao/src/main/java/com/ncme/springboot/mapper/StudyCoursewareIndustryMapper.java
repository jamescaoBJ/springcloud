package com.ncme.springboot.mapper;

import com.ncme.springboot.model.StudyCoursewareIndustry;

public interface StudyCoursewareIndustryMapper {
    int insert(StudyCoursewareIndustry record);

    int insertSelective(StudyCoursewareIndustry record);
}