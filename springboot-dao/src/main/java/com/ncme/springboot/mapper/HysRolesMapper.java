package com.ncme.springboot.mapper;

import com.ncme.springboot.model.HysRoles;

public interface HysRolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HysRoles record);

    int insertSelective(HysRoles record);

    HysRoles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HysRoles record);

    int updateByPrimaryKey(HysRoles record);
}