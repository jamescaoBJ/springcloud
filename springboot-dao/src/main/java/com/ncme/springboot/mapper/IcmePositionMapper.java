package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmePosition;

public interface IcmePositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmePosition record);

    int insertSelective(IcmePosition record);

    IcmePosition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmePosition record);

    int updateByPrimaryKey(IcmePosition record);
}