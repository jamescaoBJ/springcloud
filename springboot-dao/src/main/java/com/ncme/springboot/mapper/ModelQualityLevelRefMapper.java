package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ModelQualityLevelRef;

public interface ModelQualityLevelRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModelQualityLevelRef record);

    int insertSelective(ModelQualityLevelRef record);

    ModelQualityLevelRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModelQualityLevelRef record);

    int updateByPrimaryKey(ModelQualityLevelRef record);
}