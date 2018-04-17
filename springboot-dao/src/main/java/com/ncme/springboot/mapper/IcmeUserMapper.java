package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeUser;

public interface IcmeUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeUser record);

    int insertSelective(IcmeUser record);

    IcmeUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeUser record);

    int updateByPrimaryKey(IcmeUser record);
}