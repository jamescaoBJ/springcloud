package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ModelUserImage;

public interface ModelUserImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModelUserImage record);

    int insertSelective(ModelUserImage record);

    ModelUserImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModelUserImage record);

    int updateByPrimaryKey(ModelUserImage record);
}