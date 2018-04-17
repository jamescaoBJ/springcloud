package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemUserJobVal;

public interface SystemUserJobValMapper {
    int insert(SystemUserJobVal record);

    int insertSelective(SystemUserJobVal record);
}