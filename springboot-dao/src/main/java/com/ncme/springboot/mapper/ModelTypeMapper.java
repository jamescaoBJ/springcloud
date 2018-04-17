package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ModelType;

public interface ModelTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModelType record);

    int insertSelective(ModelType record);

    ModelType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModelType record);

    int updateByPrimaryKey(ModelType record);
}