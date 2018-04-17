package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvUnitRefQuality;
import com.ncme.springboot.model.CvUnitRefQualityKey;

public interface CvUnitRefQualityMapper {
    int deleteByPrimaryKey(CvUnitRefQualityKey key);

    int insert(CvUnitRefQuality record);

    int insertSelective(CvUnitRefQuality record);

    CvUnitRefQuality selectByPrimaryKey(CvUnitRefQualityKey key);

    int updateByPrimaryKeySelective(CvUnitRefQuality record);

    int updateByPrimaryKey(CvUnitRefQuality record);
}