package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvLiveStudy;

public interface CvLiveStudyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvLiveStudy record);

    int insertSelective(CvLiveStudy record);

    CvLiveStudy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvLiveStudy record);

    int updateByPrimaryKey(CvLiveStudy record);
}