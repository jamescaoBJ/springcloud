package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeProject;

public interface IcmeProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeProject record);

    int insertSelective(IcmeProject record);

    IcmeProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeProject record);

    int updateByPrimaryKey(IcmeProject record);
}