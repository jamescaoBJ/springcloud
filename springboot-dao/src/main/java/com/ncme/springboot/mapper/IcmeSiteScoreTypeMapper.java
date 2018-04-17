package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeSiteScoreType;

public interface IcmeSiteScoreTypeMapper {
    int insert(IcmeSiteScoreType record);

    int insertSelective(IcmeSiteScoreType record);
}