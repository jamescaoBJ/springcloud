package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvLiveSignk;

public interface CvLiveSignkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvLiveSignk record);

    int insertSelective(CvLiveSignk record);

    CvLiveSignk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvLiveSignk record);

    int updateByPrimaryKey(CvLiveSignk record);
}