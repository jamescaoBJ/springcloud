package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeSubject;

public interface IcmeSubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeSubject record);

    int insertSelective(IcmeSubject record);

    IcmeSubject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeSubject record);

    int updateByPrimaryKey(IcmeSubject record);
}