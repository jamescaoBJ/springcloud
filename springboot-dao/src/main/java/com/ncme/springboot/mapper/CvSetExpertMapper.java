package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvSetExpertKey;

public interface CvSetExpertMapper {
    int deleteByPrimaryKey(CvSetExpertKey key);

    int insert(CvSetExpertKey record);

    int insertSelective(CvSetExpertKey record);
}