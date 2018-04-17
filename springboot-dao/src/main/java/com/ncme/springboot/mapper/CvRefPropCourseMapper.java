package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvRefPropCourseKey;

public interface CvRefPropCourseMapper {
    int deleteByPrimaryKey(CvRefPropCourseKey key);

    int insert(CvRefPropCourseKey record);

    int insertSelective(CvRefPropCourseKey record);
}