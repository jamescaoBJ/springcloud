package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeOrgType;

public interface IcmeOrgTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeOrgType record);

    int insertSelective(IcmeOrgType record);

    IcmeOrgType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeOrgType record);

    int updateByPrimaryKey(IcmeOrgType record);
}