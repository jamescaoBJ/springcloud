package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SubSysPropVal;

public interface SubSysPropValMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubSysPropVal record);

    int insertSelective(SubSysPropVal record);

    SubSysPropVal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubSysPropVal record);

    int updateByPrimaryKey(SubSysPropVal record);
}