package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooAtSqlExecError;

public interface QuestSooAtSqlExecErrorMapper {
    int insert(QuestSooAtSqlExecError record);

    int insertSelective(QuestSooAtSqlExecError record);
}