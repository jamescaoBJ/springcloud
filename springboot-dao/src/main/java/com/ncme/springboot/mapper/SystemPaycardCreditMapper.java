package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemPaycardCredit;

public interface SystemPaycardCreditMapper {
    int insert(SystemPaycardCredit record);

    int insertSelective(SystemPaycardCredit record);
}