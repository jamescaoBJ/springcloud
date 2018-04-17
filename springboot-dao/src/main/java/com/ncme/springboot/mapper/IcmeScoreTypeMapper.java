package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeScoreType;

public interface IcmeScoreTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeScoreType record);

    int insertSelective(IcmeScoreType record);

    IcmeScoreType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeScoreType record);

    int updateByPrimaryKey(IcmeScoreType record);
}