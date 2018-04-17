package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentEduc;

public interface TrainContentEducMapper {
    int insert(TrainContentEduc record);

    int insertSelective(TrainContentEduc record);
}