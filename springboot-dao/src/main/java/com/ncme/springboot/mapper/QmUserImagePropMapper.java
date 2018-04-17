package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QmUserImageProp;

public interface QmUserImagePropMapper {
    int insert(QmUserImageProp record);

    int insertSelective(QmUserImageProp record);
}