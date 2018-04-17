package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemOrg;

public interface SystemOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemOrg record);

    int insertSelective(SystemOrg record);

    SystemOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemOrg record);

    int updateByPrimaryKey(SystemOrg record);
}