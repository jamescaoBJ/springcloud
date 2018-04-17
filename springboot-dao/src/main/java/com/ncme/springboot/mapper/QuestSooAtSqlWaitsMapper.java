package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooAtSqlWaits;

public interface QuestSooAtSqlWaitsMapper {
    int insert(QuestSooAtSqlWaits record);

    int insertSelective(QuestSooAtSqlWaits record);
}