package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeAppInfo;

public interface IcmeAppInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeAppInfo record);

    int insertSelective(IcmeAppInfo record);

    IcmeAppInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeAppInfo record);

    int updateByPrimaryKey(IcmeAppInfo record);
}