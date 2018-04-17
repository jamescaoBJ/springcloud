package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemCardUser;

public interface SystemCardUserMapper {
    int insert(SystemCardUser record);

    int insertSelective(SystemCardUser record);
}