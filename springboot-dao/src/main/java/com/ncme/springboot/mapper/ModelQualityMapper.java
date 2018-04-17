package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ModelQuality;

public interface ModelQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModelQuality record);

    int insertSelective(ModelQuality record);

    ModelQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModelQuality record);

    int updateByPrimaryKey(ModelQuality record);
}