package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmePaycardOrgan;

public interface NcmePaycardOrganMapper {
    int insert(NcmePaycardOrgan record);

    int insertSelective(NcmePaycardOrgan record);
}