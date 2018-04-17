package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentLinks;

public interface TrainContentLinksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentLinks record);

    int insertSelective(TrainContentLinks record);

    TrainContentLinks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentLinks record);

    int updateByPrimaryKey(TrainContentLinks record);
}