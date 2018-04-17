package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeUserType;

public interface IcmeUserTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeUserType record);

    int insertSelective(IcmeUserType record);

    IcmeUserType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeUserType record);

    int updateByPrimaryKey(IcmeUserType record);
}