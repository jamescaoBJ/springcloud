package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeSystem;

public interface NcmeSystemMapper {
    int insert(NcmeSystem record);

    int insertSelective(NcmeSystem record);
}