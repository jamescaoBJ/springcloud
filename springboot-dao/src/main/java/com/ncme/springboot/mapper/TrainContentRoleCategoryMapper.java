package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentRoleCategory;

public interface TrainContentRoleCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentRoleCategory record);

    int insertSelective(TrainContentRoleCategory record);

    TrainContentRoleCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentRoleCategory record);

    int updateByPrimaryKey(TrainContentRoleCategory record);
}