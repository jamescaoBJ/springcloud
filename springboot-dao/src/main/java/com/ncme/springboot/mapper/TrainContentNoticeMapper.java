package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentNotice;

public interface TrainContentNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentNotice record);

    int insertSelective(TrainContentNotice record);

    TrainContentNotice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentNotice record);

    int updateByPrimaryKey(TrainContentNotice record);
}