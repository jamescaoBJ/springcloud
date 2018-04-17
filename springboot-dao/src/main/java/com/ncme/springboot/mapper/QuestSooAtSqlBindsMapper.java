package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooAtSqlBinds;

public interface QuestSooAtSqlBindsMapper {
    int insert(QuestSooAtSqlBinds record);

    int insertSelective(QuestSooAtSqlBinds record);
}