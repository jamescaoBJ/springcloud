package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemOrgUnit;

public interface SystemOrgUnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemOrgUnit record);

    int insertSelective(SystemOrgUnit record);

    SystemOrgUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemOrgUnit record);

    int updateByPrimaryKey(SystemOrgUnit record);
}