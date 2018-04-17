package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ModelGuide;

public interface ModelGuideMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModelGuide record);

    int insertSelective(ModelGuide record);

    ModelGuide selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModelGuide record);

    int updateByPrimaryKey(ModelGuide record);
}