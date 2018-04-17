package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeManageVersion;

public interface NcmeManageVersionMapper {
    int insert(NcmeManageVersion record);

    int insertSelective(NcmeManageVersion record);
}