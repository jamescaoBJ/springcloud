package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeExpert;

public interface NcmeExpertMapper {
    int deleteByPrimaryKey(Integer expId);

    int insert(NcmeExpert record);

    int insertSelective(NcmeExpert record);

    NcmeExpert selectByPrimaryKey(Integer expId);

    int updateByPrimaryKeySelective(NcmeExpert record);

    int updateByPrimaryKey(NcmeExpert record);
}