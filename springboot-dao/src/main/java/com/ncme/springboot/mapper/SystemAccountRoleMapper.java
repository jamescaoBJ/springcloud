package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemAccountRoleKey;

public interface SystemAccountRoleMapper {
    int deleteByPrimaryKey(SystemAccountRoleKey key);

    int insert(SystemAccountRoleKey record);

    int insertSelective(SystemAccountRoleKey record);
}