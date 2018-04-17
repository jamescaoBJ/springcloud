package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ContentSentence;

public interface ContentSentenceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContentSentence record);

    int insertSelective(ContentSentence record);

    ContentSentence selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContentSentence record);

    int updateByPrimaryKey(ContentSentence record);
}