package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmePayCard;

public interface NcmePayCardMapper {
    int insert(NcmePayCard record);

    int insertSelective(NcmePayCard record);
}