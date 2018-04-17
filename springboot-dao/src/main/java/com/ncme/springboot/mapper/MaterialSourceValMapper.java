package com.ncme.springboot.mapper;

import com.ncme.springboot.model.MaterialSourceVal;

public interface MaterialSourceValMapper {
    int insert(MaterialSourceVal record);

    int insertSelective(MaterialSourceVal record);
}