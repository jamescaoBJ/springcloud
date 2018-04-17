package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentUser;

public interface TrainContentUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentUser record);

    int insertSelective(TrainContentUser record);

    TrainContentUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentUser record);

    int updateByPrimaryKey(TrainContentUser record);
}