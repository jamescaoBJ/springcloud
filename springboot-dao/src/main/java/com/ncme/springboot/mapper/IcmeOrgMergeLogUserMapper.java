package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeOrgMergeLogUser;

public interface IcmeOrgMergeLogUserMapper {
    int insert(IcmeOrgMergeLogUser record);

    int insertSelective(IcmeOrgMergeLogUser record);
}