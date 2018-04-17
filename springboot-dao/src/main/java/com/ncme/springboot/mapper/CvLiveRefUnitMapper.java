package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvLiveRefUnit;

public interface CvLiveRefUnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvLiveRefUnit record);

    int insertSelective(CvLiveRefUnit record);

    CvLiveRefUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvLiveRefUnit record);

    int updateByPrimaryKey(CvLiveRefUnit record);
}