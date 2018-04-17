package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ModelUserImageSpecial;

public interface ModelUserImageSpecialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModelUserImageSpecial record);

    int insertSelective(ModelUserImageSpecial record);

    ModelUserImageSpecial selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModelUserImageSpecial record);

    int updateByPrimaryKey(ModelUserImageSpecial record);
}