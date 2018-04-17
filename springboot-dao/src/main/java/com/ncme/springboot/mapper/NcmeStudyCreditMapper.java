package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeStudyCredit;

public interface NcmeStudyCreditMapper {
    int insert(NcmeStudyCredit record);

    int insertSelective(NcmeStudyCredit record);
}