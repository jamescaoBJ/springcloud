package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemOrderPaymode;

public interface SystemOrderPaymodeMapper {
    int insert(SystemOrderPaymode record);

    int insertSelective(SystemOrderPaymode record);
}