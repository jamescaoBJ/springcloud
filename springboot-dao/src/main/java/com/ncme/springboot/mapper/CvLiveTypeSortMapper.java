package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvLiveTypeSort;

public interface CvLiveTypeSortMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvLiveTypeSort record);

    int insertSelective(CvLiveTypeSort record);

    CvLiveTypeSort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvLiveTypeSort record);

    int updateByPrimaryKey(CvLiveTypeSort record);
}