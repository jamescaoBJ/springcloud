package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeCreditType;

public interface NcmeCreditTypeMapper {
    int insert(NcmeCreditType record);

    int insertSelective(NcmeCreditType record);
}