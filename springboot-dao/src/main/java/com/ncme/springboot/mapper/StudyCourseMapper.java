package com.ncme.springboot.mapper;

import com.ncme.springboot.model.StudyCourse;

public interface StudyCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudyCourse record);

    int insertSelective(StudyCourse record);

    StudyCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudyCourse record);

    int updateByPrimaryKey(StudyCourse record);
}