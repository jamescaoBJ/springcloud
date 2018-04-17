package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentSub;

public interface TrainContentSubMapper {
    int insert(TrainContentSub record);

    int insertSelective(TrainContentSub record);
}