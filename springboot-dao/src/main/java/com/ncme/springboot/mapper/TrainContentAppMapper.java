package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentApp;

public interface TrainContentAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentApp record);

    int insertSelective(TrainContentApp record);

    TrainContentApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentApp record);

    int updateByPrimaryKey(TrainContentApp record);
}