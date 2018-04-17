package com.ncme.springboot.mapper;


import com.ncme.springboot.model.CvSetUnitDiscuss;

public interface CvSetUnitDiscussMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvSetUnitDiscuss record);

    int insertSelective(CvSetUnitDiscuss record);

    CvSetUnitDiscuss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvSetUnitDiscuss record);

    int updateByPrimaryKey(CvSetUnitDiscuss record);





	
}