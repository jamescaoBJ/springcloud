package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemApplication;

public interface SystemApplicationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemApplication record);

    int insertSelective(SystemApplication record);

    SystemApplication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemApplication record);

    int updateByPrimaryKey(SystemApplication record);
}