package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExpertGroupPropVal;

public interface ExpertGroupPropValMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpertGroupPropVal record);

    int insertSelective(ExpertGroupPropVal record);

    ExpertGroupPropVal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpertGroupPropVal record);

    int updateByPrimaryKey(ExpertGroupPropVal record);
}