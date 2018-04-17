package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeAwardScoreStandard;

public interface IcmeAwardScoreStandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeAwardScoreStandard record);

    int insertSelective(IcmeAwardScoreStandard record);

    IcmeAwardScoreStandard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeAwardScoreStandard record);

    int updateByPrimaryKey(IcmeAwardScoreStandard record);
}