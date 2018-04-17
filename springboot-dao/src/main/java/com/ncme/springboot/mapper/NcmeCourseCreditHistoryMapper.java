package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeCourseCreditHistory;

public interface NcmeCourseCreditHistoryMapper {
    int insert(NcmeCourseCreditHistory record);

    int insertSelective(NcmeCourseCreditHistory record);
}