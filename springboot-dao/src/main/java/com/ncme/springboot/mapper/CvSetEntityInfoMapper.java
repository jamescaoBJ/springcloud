package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvSetEntityInfo;

public interface CvSetEntityInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvSetEntityInfo record);

    int insertSelective(CvSetEntityInfo record);

    CvSetEntityInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvSetEntityInfo record);

    int updateByPrimaryKey(CvSetEntityInfo record);
}