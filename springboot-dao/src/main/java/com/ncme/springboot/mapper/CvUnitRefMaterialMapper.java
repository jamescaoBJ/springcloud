package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvUnitRefMaterialKey;

public interface CvUnitRefMaterialMapper {
    int deleteByPrimaryKey(CvUnitRefMaterialKey key);

    int insert(CvUnitRefMaterialKey record);

    int insertSelective(CvUnitRefMaterialKey record);
}