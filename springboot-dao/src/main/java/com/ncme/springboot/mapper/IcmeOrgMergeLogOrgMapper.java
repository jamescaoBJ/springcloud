package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeOrgMergeLogOrg;

public interface IcmeOrgMergeLogOrgMapper {
    int insert(IcmeOrgMergeLogOrg record);

    int insertSelective(IcmeOrgMergeLogOrg record);
}