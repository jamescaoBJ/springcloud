package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvSetUserImageKey;

public interface CvSetUserImageMapper {
    int deleteByPrimaryKey(CvSetUserImageKey key);

    int insert(CvSetUserImageKey record);

    int insertSelective(CvSetUserImageKey record);
}