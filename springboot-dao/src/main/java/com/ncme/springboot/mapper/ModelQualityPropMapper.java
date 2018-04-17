package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ModelQualityProp;

public interface ModelQualityPropMapper {
    int insert(ModelQualityProp record);

    int insertSelective(ModelQualityProp record);
}