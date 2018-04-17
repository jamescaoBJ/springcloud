package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeStudyCard;

public interface NcmeStudyCardMapper {
    int insert(NcmeStudyCard record);

    int insertSelective(NcmeStudyCard record);
}