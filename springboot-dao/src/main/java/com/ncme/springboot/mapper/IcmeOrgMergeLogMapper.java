package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeOrgMergeLog;

public interface IcmeOrgMergeLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeOrgMergeLog record);

    int insertSelective(IcmeOrgMergeLog record);

    IcmeOrgMergeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeOrgMergeLog record);

    int updateByPrimaryKey(IcmeOrgMergeLog record);
}