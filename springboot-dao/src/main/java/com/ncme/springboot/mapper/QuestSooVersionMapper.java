package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooVersion;

public interface QuestSooVersionMapper {
    int insert(QuestSooVersion record);

    int insertSelective(QuestSooVersion record);
}