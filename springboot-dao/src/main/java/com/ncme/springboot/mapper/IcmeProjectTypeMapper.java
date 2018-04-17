package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeProjectType;

public interface IcmeProjectTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeProjectType record);

    int insertSelective(IcmeProjectType record);

    IcmeProjectType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeProjectType record);

    int updateByPrimaryKey(IcmeProjectType record);
}