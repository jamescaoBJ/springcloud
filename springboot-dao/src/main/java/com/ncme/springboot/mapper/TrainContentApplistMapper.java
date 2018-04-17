package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentApplist;

public interface TrainContentApplistMapper {
    int deleteByPrimaryKey(Integer appId);

    int insert(TrainContentApplist record);

    int insertSelective(TrainContentApplist record);

    TrainContentApplist selectByPrimaryKey(Integer appId);

    int updateByPrimaryKeySelective(TrainContentApplist record);

    int updateByPrimaryKey(TrainContentApplist record);
}