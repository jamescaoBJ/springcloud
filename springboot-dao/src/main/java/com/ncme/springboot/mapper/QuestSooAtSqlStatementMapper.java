package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooAtSqlStatement;

public interface QuestSooAtSqlStatementMapper {
    int insert(QuestSooAtSqlStatement record);

    int insertSelective(QuestSooAtSqlStatement record);
}