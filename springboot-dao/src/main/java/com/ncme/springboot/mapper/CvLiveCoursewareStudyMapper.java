package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvLiveCoursewareStudy;

public interface CvLiveCoursewareStudyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvLiveCoursewareStudy record);

    int insertSelective(CvLiveCoursewareStudy record);

    CvLiveCoursewareStudy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvLiveCoursewareStudy record);

    int updateByPrimaryKey(CvLiveCoursewareStudy record);
}