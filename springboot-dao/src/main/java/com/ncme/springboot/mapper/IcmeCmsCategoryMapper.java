package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeCmsCategory;

public interface IcmeCmsCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeCmsCategory record);

    int insertSelective(IcmeCmsCategory record);

    IcmeCmsCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeCmsCategory record);

    int updateByPrimaryKeyWithBLOBs(IcmeCmsCategory record);

    int updateByPrimaryKey(IcmeCmsCategory record);
}