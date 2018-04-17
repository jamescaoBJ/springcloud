package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ContentEditionRef;

public interface ContentEditionRefMapper {
    int deleteByPrimaryKey(Integer ordernum);

    int insert(ContentEditionRef record);

    int insertSelective(ContentEditionRef record);

    ContentEditionRef selectByPrimaryKey(Integer ordernum);

    int updateByPrimaryKeySelective(ContentEditionRef record);

    int updateByPrimaryKey(ContentEditionRef record);
}