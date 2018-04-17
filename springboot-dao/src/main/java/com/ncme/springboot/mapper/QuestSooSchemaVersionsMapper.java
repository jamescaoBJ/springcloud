package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooSchemaVersions;

public interface QuestSooSchemaVersionsMapper {
    int insert(QuestSooSchemaVersions record);

    int insertSelective(QuestSooSchemaVersions record);
}