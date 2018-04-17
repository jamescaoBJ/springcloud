package com.ncme.springboot.mapper;

import com.ncme.springboot.model.StudyCourseSetting;

public interface StudyCourseSettingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudyCourseSetting record);

    int insertSelective(StudyCourseSetting record);

    StudyCourseSetting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudyCourseSetting record);

    int updateByPrimaryKey(StudyCourseSetting record);
}