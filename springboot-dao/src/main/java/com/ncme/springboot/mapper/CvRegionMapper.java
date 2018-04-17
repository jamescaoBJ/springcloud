package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvRegionKey;

public interface CvRegionMapper {
    int deleteByPrimaryKey(CvRegionKey key);

    int insert(CvRegionKey record);

    int insertSelective(CvRegionKey record);
}