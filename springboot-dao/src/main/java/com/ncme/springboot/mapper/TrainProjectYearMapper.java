package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainProjectYear;

public interface TrainProjectYearMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainProjectYear record);

    int insertSelective(TrainProjectYear record);

    TrainProjectYear selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainProjectYear record);

    int updateByPrimaryKey(TrainProjectYear record);
}