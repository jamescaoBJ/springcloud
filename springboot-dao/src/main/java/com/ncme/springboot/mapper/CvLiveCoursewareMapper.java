package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvLiveCourseware;

public interface CvLiveCoursewareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvLiveCourseware record);

    int insertSelective(CvLiveCourseware record);

    CvLiveCourseware selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvLiveCourseware record);

    int updateByPrimaryKey(CvLiveCourseware record);
}