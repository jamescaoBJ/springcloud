package com.ncme.springboot.mapper;

import com.ncme.springboot.model.HysUserSystemUserValKey;

public interface HysUserSystemUserValMapper {
    int deleteByPrimaryKey(HysUserSystemUserValKey key);

    int insert(HysUserSystemUserValKey record);

    int insertSelective(HysUserSystemUserValKey record);
}