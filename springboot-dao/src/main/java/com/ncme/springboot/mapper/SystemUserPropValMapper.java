package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemUserPropValKey;

public interface SystemUserPropValMapper {
    int deleteByPrimaryKey(SystemUserPropValKey key);

    int insert(SystemUserPropValKey record);

    int insertSelective(SystemUserPropValKey record);
}