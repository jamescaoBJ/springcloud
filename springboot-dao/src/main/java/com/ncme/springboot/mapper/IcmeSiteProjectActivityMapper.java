package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeSiteProjectActivity;

public interface IcmeSiteProjectActivityMapper {
    int insert(IcmeSiteProjectActivity record);

    int insertSelective(IcmeSiteProjectActivity record);
}