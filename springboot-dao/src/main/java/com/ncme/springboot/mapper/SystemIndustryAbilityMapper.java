package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemIndustryAbility;

public interface SystemIndustryAbilityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemIndustryAbility record);

    int insertSelective(SystemIndustryAbility record);

    SystemIndustryAbility selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemIndustryAbility record);

    int updateByPrimaryKey(SystemIndustryAbility record);
}