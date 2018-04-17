package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentNews;

public interface TrainContentNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentNews record);

    int insertSelective(TrainContentNews record);

    TrainContentNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentNews record);

    int updateByPrimaryKeyWithBLOBs(TrainContentNews record);

    int updateByPrimaryKey(TrainContentNews record);
}