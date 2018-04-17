package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeStudyCardHistory;

public interface NcmeStudyCardHistoryMapper {
    int insert(NcmeStudyCardHistory record);

    int insertSelective(NcmeStudyCardHistory record);
}