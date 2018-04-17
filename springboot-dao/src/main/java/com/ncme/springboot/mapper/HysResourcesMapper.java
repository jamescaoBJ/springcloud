package com.ncme.springboot.mapper;

import com.ncme.springboot.model.HysResources;

public interface HysResourcesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HysResources record);

    int insertSelective(HysResources record);

    HysResources selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HysResources record);

    int updateByPrimaryKey(HysResources record);
}