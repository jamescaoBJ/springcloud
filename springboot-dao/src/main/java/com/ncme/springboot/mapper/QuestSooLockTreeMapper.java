package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooLockTree;

public interface QuestSooLockTreeMapper {
    int insert(QuestSooLockTree record);

    int insertSelective(QuestSooLockTree record);
}