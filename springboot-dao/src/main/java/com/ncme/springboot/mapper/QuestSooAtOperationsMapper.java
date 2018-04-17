package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooAtOperations;

public interface QuestSooAtOperationsMapper {
    int insert(QuestSooAtOperations record);

    int insertSelective(QuestSooAtOperations record);
}