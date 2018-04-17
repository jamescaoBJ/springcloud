package com.ncme.springboot.mapper;

import com.ncme.springboot.model.RoleResource;

public interface RoleResourceMapper {
    int insert(RoleResource record);

    int insertSelective(RoleResource record);
}