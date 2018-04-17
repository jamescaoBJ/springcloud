package com.ncme.springboot.mapper;

import com.ncme.springboot.model.MaterialInfo;

public interface MaterialInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterialInfo record);

    int insertSelective(MaterialInfo record);

    MaterialInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterialInfo record);

    int updateByPrimaryKey(MaterialInfo record);
}