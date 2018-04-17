package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvRefUnitKey;

public interface CvRefUnitMapper {
    int deleteByPrimaryKey(CvRefUnitKey key);

    int insert(CvRefUnitKey record);

    int insertSelective(CvRefUnitKey record);
}