package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentFocus;

public interface TrainContentFocusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentFocus record);

    int insertSelective(TrainContentFocus record);

    TrainContentFocus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentFocus record);

    int updateByPrimaryKey(TrainContentFocus record);
}