package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentCategory;

public interface TrainContentCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentCategory record);

    int insertSelective(TrainContentCategory record);

    TrainContentCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentCategory record);

    int updateByPrimaryKeyWithBLOBs(TrainContentCategory record);

    int updateByPrimaryKey(TrainContentCategory record);
}