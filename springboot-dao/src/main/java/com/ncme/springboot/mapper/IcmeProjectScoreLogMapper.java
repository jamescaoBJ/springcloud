package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeProjectScoreLog;

public interface IcmeProjectScoreLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeProjectScoreLog record);

    int insertSelective(IcmeProjectScoreLog record);

    IcmeProjectScoreLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeProjectScoreLog record);

    int updateByPrimaryKey(IcmeProjectScoreLog record);
}