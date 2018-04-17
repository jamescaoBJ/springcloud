package com.ncme.springboot.mapper;

import com.ncme.springboot.model.StudyCourseElementWare;

public interface StudyCourseElementWareMapper {
    int insert(StudyCourseElementWare record);

    int insertSelective(StudyCourseElementWare record);
}