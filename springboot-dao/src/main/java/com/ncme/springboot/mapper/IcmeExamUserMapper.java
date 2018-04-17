package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeExamUser;

public interface IcmeExamUserMapper {
    int insert(IcmeExamUser record);

    int insertSelective(IcmeExamUser record);
}