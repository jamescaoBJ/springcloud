package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentCourse;

public interface TrainContentCourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(TrainContentCourse record);

    int insertSelective(TrainContentCourse record);

    TrainContentCourse selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(TrainContentCourse record);

    int updateByPrimaryKey(TrainContentCourse record);
}