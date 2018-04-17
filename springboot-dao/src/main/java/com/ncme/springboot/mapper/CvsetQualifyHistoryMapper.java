package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvsetQualifyHistory;

public interface CvsetQualifyHistoryMapper {
    int insert(CvsetQualifyHistory record);

    int insertSelective(CvsetQualifyHistory record);
}