package com.ncme.springboot.mapper;

import com.ncme.springboot.model.MaterialPropValKey;

public interface MaterialPropValMapper {
    int deleteByPrimaryKey(MaterialPropValKey key);

    int insert(MaterialPropValKey record);

    int insertSelective(MaterialPropValKey record);
}