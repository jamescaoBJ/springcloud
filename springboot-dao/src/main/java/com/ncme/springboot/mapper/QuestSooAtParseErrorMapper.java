package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooAtParseError;

public interface QuestSooAtParseErrorMapper {
    int insert(QuestSooAtParseError record);

    int insertSelective(QuestSooAtParseError record);
}