package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ModelUserImageGeneral;

public interface ModelUserImageGeneralMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModelUserImageGeneral record);

    int insertSelective(ModelUserImageGeneral record);

    ModelUserImageGeneral selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModelUserImageGeneral record);

    int updateByPrimaryKey(ModelUserImageGeneral record);
}