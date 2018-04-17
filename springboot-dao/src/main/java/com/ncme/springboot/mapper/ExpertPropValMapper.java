package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExpertPropVal;

public interface ExpertPropValMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpertPropVal record);

    int insertSelective(ExpertPropVal record);

    ExpertPropVal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpertPropVal record);

    int updateByPrimaryKey(ExpertPropVal record);
}