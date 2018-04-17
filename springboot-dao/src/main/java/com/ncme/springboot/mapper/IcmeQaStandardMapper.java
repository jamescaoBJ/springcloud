package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeQaStandard;

public interface IcmeQaStandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeQaStandard record);

    int insertSelective(IcmeQaStandard record);

    IcmeQaStandard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeQaStandard record);

    int updateByPrimaryKey(IcmeQaStandard record);
}