package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainProjectClass;

public interface TrainProjectClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainProjectClass record);

    int insertSelective(TrainProjectClass record);

    TrainProjectClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainProjectClass record);

    int updateByPrimaryKey(TrainProjectClass record);
}