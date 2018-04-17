package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeSubjectUser;

public interface IcmeSubjectUserMapper {
    int insert(IcmeSubjectUser record);

    int insertSelective(IcmeSubjectUser record);
}