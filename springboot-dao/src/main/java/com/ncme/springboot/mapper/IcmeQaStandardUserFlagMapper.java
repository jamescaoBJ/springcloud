package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeQaStandardUserFlag;

public interface IcmeQaStandardUserFlagMapper {
    int insert(IcmeQaStandardUserFlag record);

    int insertSelective(IcmeQaStandardUserFlag record);
}