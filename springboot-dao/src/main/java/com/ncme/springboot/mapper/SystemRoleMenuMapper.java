package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemRoleMenu;

public interface SystemRoleMenuMapper {
    int insert(SystemRoleMenu record);

    int insertSelective(SystemRoleMenu record);
}