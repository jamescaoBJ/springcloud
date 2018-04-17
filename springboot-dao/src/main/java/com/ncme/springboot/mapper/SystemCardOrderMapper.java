package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemCardOrder;

public interface SystemCardOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemCardOrder record);

    int insertSelective(SystemCardOrder record);

    SystemCardOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemCardOrder record);

    int updateByPrimaryKey(SystemCardOrder record);
}