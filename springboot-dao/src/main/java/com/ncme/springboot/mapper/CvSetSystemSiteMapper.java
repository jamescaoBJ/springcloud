package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvSetSystemSiteKey;

public interface CvSetSystemSiteMapper {
    int deleteByPrimaryKey(CvSetSystemSiteKey key);

    int insert(CvSetSystemSiteKey record);

    int insertSelective(CvSetSystemSiteKey record);
}