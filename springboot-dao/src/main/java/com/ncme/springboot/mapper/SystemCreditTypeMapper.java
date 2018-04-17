package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemCreditType;

public interface SystemCreditTypeMapper {
    int insert(SystemCreditType record);

    int insertSelective(SystemCreditType record);
}