package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemExperts;

public interface SystemExpertsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemExperts record);

    int insertSelective(SystemExperts record);

    SystemExperts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemExperts record);

    int updateByPrimaryKey(SystemExperts record);
}