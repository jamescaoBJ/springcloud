package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeSiteProfTitle;

public interface IcmeSiteProfTitleMapper {
    int insert(IcmeSiteProfTitle record);

    int insertSelective(IcmeSiteProfTitle record);
}