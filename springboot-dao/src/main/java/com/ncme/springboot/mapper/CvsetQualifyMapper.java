package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvsetQualify;

public interface CvsetQualifyMapper {
    int insert(CvsetQualify record);

    int insertSelective(CvsetQualify record);
}