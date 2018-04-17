package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeProfTitle;

public interface IcmeProfTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeProfTitle record);

    int insertSelective(IcmeProfTitle record);

    IcmeProfTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeProfTitle record);

    int updateByPrimaryKey(IcmeProfTitle record);
}