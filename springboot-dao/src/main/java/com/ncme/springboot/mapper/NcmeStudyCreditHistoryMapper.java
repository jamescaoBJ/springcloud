package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeStudyCreditHistory;

public interface NcmeStudyCreditHistoryMapper {
    int insert(NcmeStudyCreditHistory record);

    int insertSelective(NcmeStudyCreditHistory record);
}