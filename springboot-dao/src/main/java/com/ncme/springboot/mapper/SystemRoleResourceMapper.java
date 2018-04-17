package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemRoleResource;

public interface SystemRoleResourceMapper {
    int insert(SystemRoleResource record);

    int insertSelective(SystemRoleResource record);
}