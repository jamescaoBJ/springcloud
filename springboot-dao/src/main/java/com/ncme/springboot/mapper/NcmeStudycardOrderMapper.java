package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeStudycardOrder;

public interface NcmeStudycardOrderMapper {
    int deleteByPrimaryKey(Integer orderNo);

    int insert(NcmeStudycardOrder record);

    int insertSelective(NcmeStudycardOrder record);

    NcmeStudycardOrder selectByPrimaryKey(Integer orderNo);

    int updateByPrimaryKeySelective(NcmeStudycardOrder record);

    int updateByPrimaryKey(NcmeStudycardOrder record);
}