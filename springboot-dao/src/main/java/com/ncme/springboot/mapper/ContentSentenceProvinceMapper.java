package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ContentSentenceProvince;

public interface ContentSentenceProvinceMapper {
    int insert(ContentSentenceProvince record);

    int insertSelective(ContentSentenceProvince record);
}