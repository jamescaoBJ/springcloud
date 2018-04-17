package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvSetScheduleKey;

public interface CvSetScheduleMapper {
    int deleteByPrimaryKey(CvSetScheduleKey key);

    int insert(CvSetScheduleKey record);

    int insertSelective(CvSetScheduleKey record);
}