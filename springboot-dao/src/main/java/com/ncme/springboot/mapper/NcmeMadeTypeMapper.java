package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeMadeType;

public interface NcmeMadeTypeMapper {
    int insert(NcmeMadeType record);

    int insertSelective(NcmeMadeType record);
}