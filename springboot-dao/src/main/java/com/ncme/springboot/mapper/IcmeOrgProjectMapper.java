package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeOrgProject;

public interface IcmeOrgProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeOrgProject record);

    int insertSelective(IcmeOrgProject record);

    IcmeOrgProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeOrgProject record);

    int updateByPrimaryKey(IcmeOrgProject record);
}