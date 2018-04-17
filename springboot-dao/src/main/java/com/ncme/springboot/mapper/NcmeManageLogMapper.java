package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeManageLog;

public interface NcmeManageLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NcmeManageLog record);

    int insertSelective(NcmeManageLog record);

    NcmeManageLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NcmeManageLog record);

    int updateByPrimaryKey(NcmeManageLog record);
}