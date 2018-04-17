package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QmGuideImagePropKey;

public interface QmGuideImagePropMapper {
    int deleteByPrimaryKey(QmGuideImagePropKey key);

    int insert(QmGuideImagePropKey record);

    int insertSelective(QmGuideImagePropKey record);
}