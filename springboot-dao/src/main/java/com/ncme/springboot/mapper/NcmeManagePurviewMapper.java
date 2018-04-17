package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeManagePurview;

public interface NcmeManagePurviewMapper {
    int insert(NcmeManagePurview record);

    int insertSelective(NcmeManagePurview record);
}