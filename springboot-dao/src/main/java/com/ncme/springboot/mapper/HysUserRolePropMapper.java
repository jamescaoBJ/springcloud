package com.ncme.springboot.mapper;

import com.ncme.springboot.model.HysUserRoleProp;

public interface HysUserRolePropMapper {
    int insert(HysUserRoleProp record);

    int insertSelective(HysUserRoleProp record);
}