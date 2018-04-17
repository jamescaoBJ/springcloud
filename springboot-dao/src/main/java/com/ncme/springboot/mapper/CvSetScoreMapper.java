package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvSetScore;

public interface CvSetScoreMapper {
    int deleteByPrimaryKey(Integer cvSetId);

    int insert(CvSetScore record);

    int insertSelective(CvSetScore record);

    CvSetScore selectByPrimaryKey(Integer cvSetId);

    int updateByPrimaryKeySelective(CvSetScore record);

    int updateByPrimaryKey(CvSetScore record);
}