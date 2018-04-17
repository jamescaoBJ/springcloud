package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemIndustry;

public interface SystemIndustryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemIndustry record);

    int insertSelective(SystemIndustry record);

    SystemIndustry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemIndustry record);

    int updateByPrimaryKey(SystemIndustry record);
}