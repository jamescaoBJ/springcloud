package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentService;

public interface TrainContentServiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentService record);

    int insertSelective(TrainContentService record);

    TrainContentService selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentService record);

    int updateByPrimaryKey(TrainContentService record);
}