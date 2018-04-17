package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainProjectType;

public interface TrainProjectTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainProjectType record);

    int insertSelective(TrainProjectType record);

    TrainProjectType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainProjectType record);

    int updateByPrimaryKey(TrainProjectType record);
}