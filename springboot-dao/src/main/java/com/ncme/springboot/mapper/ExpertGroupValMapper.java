package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExpertGroupVal;

public interface ExpertGroupValMapper {
    int insert(ExpertGroupVal record);

    int insertSelective(ExpertGroupVal record);
}