package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ContentIssueSiteKey;

public interface ContentIssueSiteMapper {
    int deleteByPrimaryKey(ContentIssueSiteKey key);

    int insert(ContentIssueSiteKey record);

    int insertSelective(ContentIssueSiteKey record);
}