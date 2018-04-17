package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QmGuide;

public interface QmGuideMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QmGuide record);

    int insertSelective(QmGuide record);

    QmGuide selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QmGuide record);

    int updateByPrimaryKey(QmGuide record);
}