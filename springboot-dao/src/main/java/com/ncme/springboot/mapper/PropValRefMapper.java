package com.ncme.springboot.mapper;

import com.ncme.springboot.model.PropValRef;

public interface PropValRefMapper {
    int insert(PropValRef record);

    int insertSelective(PropValRef record);
}