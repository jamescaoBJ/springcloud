package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemCardType;

public interface SystemCardTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemCardType record);

    int insertSelective(SystemCardType record);

    SystemCardType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemCardType record);

    int updateByPrimaryKey(SystemCardType record);
}