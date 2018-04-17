package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeQaStandardScoreType;

public interface IcmeQaStandardScoreTypeMapper {
    int insert(IcmeQaStandardScoreType record);

    int insertSelective(IcmeQaStandardScoreType record);
}