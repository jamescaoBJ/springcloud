package com.ncme.springboot.mapper;

import com.ncme.springboot.model.StudyCourseElement;

public interface StudyCourseElementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudyCourseElement record);

    int insertSelective(StudyCourseElement record);

    StudyCourseElement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudyCourseElement record);

    int updateByPrimaryKey(StudyCourseElement record);
}