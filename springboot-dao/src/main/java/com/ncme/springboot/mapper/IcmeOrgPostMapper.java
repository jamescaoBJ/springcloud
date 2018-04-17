package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeOrgPost;

public interface IcmeOrgPostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeOrgPost record);

    int insertSelective(IcmeOrgPost record);

    IcmeOrgPost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeOrgPost record);

    int updateByPrimaryKey(IcmeOrgPost record);
}