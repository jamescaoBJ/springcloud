package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ModelUserImageGeneralProp;

public interface ModelUserImageGeneralPropMapper {
    int insert(ModelUserImageGeneralProp record);

    int insertSelective(ModelUserImageGeneralProp record);
}