package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QmQuality;

public interface QmQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QmQuality record);

    int insertSelective(QmQuality record);

    QmQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QmQuality record);

    int updateByPrimaryKey(QmQuality record);
}