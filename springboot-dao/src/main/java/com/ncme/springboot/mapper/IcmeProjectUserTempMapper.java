package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeProjectUserTemp;

public interface IcmeProjectUserTempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeProjectUserTemp record);

    int insertSelective(IcmeProjectUserTemp record);

    IcmeProjectUserTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeProjectUserTemp record);

    int updateByPrimaryKey(IcmeProjectUserTemp record);
}