package com.ncme.springboot.mapper;

import com.ncme.springboot.model.StudyCourseware;

public interface StudyCoursewareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudyCourseware record);

    int insertSelective(StudyCourseware record);

    StudyCourseware selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudyCourseware record);

    int updateByPrimaryKey(StudyCourseware record);
}