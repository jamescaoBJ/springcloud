package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentSite;

public interface TrainContentSiteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentSite record);

    int insertSelective(TrainContentSite record);

    TrainContentSite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentSite record);

    int updateByPrimaryKey(TrainContentSite record);
}