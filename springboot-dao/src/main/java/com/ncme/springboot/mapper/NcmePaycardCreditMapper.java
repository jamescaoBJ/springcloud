package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmePaycardCredit;

public interface NcmePaycardCreditMapper {
    int insert(NcmePaycardCredit record);

    int insertSelective(NcmePaycardCredit record);
}