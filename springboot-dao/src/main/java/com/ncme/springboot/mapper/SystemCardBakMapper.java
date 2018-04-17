package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemCardBak;

public interface SystemCardBakMapper {
    int insert(SystemCardBak record);

    int insertSelective(SystemCardBak record);
}