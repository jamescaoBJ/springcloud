package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeSitePosition;

public interface IcmeSitePositionMapper {
    int insert(IcmeSitePosition record);

    int insertSelective(IcmeSitePosition record);
}