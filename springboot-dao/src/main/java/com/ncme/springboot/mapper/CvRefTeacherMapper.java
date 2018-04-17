package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvRefTeacherKey;

public interface CvRefTeacherMapper {
    int deleteByPrimaryKey(CvRefTeacherKey key);

    int insert(CvRefTeacherKey record);

    int insertSelective(CvRefTeacherKey record);
}