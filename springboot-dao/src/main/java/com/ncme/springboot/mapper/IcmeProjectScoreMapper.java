package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeProjectScore;

public interface IcmeProjectScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeProjectScore record);

    int insertSelective(IcmeProjectScore record);

    IcmeProjectScore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeProjectScore record);

    int updateByPrimaryKey(IcmeProjectScore record);
}