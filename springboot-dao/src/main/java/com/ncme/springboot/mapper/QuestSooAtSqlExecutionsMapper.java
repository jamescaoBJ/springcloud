package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooAtSqlExecutions;

public interface QuestSooAtSqlExecutionsMapper {
    int insert(QuestSooAtSqlExecutions record);

    int insertSelective(QuestSooAtSqlExecutions record);
}