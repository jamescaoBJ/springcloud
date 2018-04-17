package com.ncme.springboot.mapper;

import com.ncme.springboot.model.StudyCoursewareCognize;

public interface StudyCoursewareCognizeMapper {
    int insert(StudyCoursewareCognize record);

    int insertSelective(StudyCoursewareCognize record);
}