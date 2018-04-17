package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooSbEvent;

public interface QuestSooSbEventMapper {
    int insert(QuestSooSbEvent record);

    int insertSelective(QuestSooSbEvent record);
}