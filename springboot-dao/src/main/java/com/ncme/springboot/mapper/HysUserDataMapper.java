package com.ncme.springboot.mapper;

import com.ncme.springboot.model.HysUserData;

public interface HysUserDataMapper {
    int insert(HysUserData record);

    int insertSelective(HysUserData record);
}