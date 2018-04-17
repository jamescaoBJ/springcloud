package com.ncme.springboot.mapper;

import com.ncme.springboot.model.HysDataRoles;

public interface HysDataRolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HysDataRoles record);

    int insertSelective(HysDataRoles record);

    HysDataRoles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HysDataRoles record);

    int updateByPrimaryKey(HysDataRoles record);
}