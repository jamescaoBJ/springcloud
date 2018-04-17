package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeAdminOrgan;

public interface NcmeAdminOrganMapper {
    int deleteByPrimaryKey(String organId);

    int insert(NcmeAdminOrgan record);

    int insertSelective(NcmeAdminOrgan record);

    NcmeAdminOrgan selectByPrimaryKey(String organId);

    int updateByPrimaryKeySelective(NcmeAdminOrgan record);

    int updateByPrimaryKey(NcmeAdminOrgan record);
}