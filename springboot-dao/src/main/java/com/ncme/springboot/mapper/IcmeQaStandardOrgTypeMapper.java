package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeQaStandardOrgType;

public interface IcmeQaStandardOrgTypeMapper {
    int insert(IcmeQaStandardOrgType record);

    int insertSelective(IcmeQaStandardOrgType record);
}