package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentRole;

public interface TrainContentRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(TrainContentRole record);

    int insertSelective(TrainContentRole record);

    TrainContentRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(TrainContentRole record);

    int updateByPrimaryKey(TrainContentRole record);
}