package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QmQualityProp;

public interface QmQualityPropMapper {
    int insert(QmQualityProp record);

    int insertSelective(QmQualityProp record);
}