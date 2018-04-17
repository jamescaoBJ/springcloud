package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SubSysProp;

public interface SubSysPropMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubSysProp record);

    int insertSelective(SubSysProp record);

    SubSysProp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubSysProp record);

    int updateByPrimaryKey(SubSysProp record);
}