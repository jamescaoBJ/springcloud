package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeYear;

public interface IcmeYearMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeYear record);

    int insertSelective(IcmeYear record);

    IcmeYear selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeYear record);

    int updateByPrimaryKey(IcmeYear record);
}