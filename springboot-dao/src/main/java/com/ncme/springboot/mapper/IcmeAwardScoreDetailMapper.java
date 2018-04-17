package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeAwardScoreDetail;

public interface IcmeAwardScoreDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeAwardScoreDetail record);

    int insertSelective(IcmeAwardScoreDetail record);

    IcmeAwardScoreDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeAwardScoreDetail record);

    int updateByPrimaryKey(IcmeAwardScoreDetail record);
}