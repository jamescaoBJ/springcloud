package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QmGuideProp;

public interface QmGuidePropMapper {
    int insert(QmGuideProp record);

    int insertSelective(QmGuideProp record);
}