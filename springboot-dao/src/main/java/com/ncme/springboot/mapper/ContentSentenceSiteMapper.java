package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ContentSentenceSite;

public interface ContentSentenceSiteMapper {
    int insert(ContentSentenceSite record);

    int insertSelective(ContentSentenceSite record);
}