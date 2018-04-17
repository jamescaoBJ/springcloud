package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooAtSqlFetch;

public interface QuestSooAtSqlFetchMapper {
    int insert(QuestSooAtSqlFetch record);

    int insertSelective(QuestSooAtSqlFetch record);
}