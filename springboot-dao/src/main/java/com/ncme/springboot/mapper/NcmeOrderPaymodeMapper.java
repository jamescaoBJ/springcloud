package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeOrderPaymode;

public interface NcmeOrderPaymodeMapper {
    int insert(NcmeOrderPaymode record);

    int insertSelective(NcmeOrderPaymode record);
}