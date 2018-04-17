package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentRoleNews;

public interface TrainContentRoleNewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(TrainContentRoleNews record);

    int insertSelective(TrainContentRoleNews record);

    TrainContentRoleNews selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(TrainContentRoleNews record);

    int updateByPrimaryKeyWithBLOBs(TrainContentRoleNews record);

    int updateByPrimaryKey(TrainContentRoleNews record);
}