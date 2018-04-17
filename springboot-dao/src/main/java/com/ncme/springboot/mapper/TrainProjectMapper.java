package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainProject;

public interface TrainProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainProject record);

    int insertSelective(TrainProject record);

    TrainProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainProject record);

    int updateByPrimaryKey(TrainProject record);
}