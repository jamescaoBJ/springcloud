package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeOrg;

public interface IcmeOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeOrg record);

    int insertSelective(IcmeOrg record);

    IcmeOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeOrg record);

    int updateByPrimaryKey(IcmeOrg record);
}