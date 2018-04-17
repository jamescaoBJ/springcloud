package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooPlanTable;

public interface QuestSooPlanTableMapper {
    int insert(QuestSooPlanTable record);

    int insertSelective(QuestSooPlanTable record);
}