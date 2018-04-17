package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvLiveStudyRef;

public interface CvLiveStudyRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvLiveStudyRef record);

    int insertSelective(CvLiveStudyRef record);

    CvLiveStudyRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvLiveStudyRef record);

    int updateByPrimaryKey(CvLiveStudyRef record);
}