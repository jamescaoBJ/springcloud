package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooAtExecutionPlan;

public interface QuestSooAtExecutionPlanMapper {
    int insert(QuestSooAtExecutionPlan record);

    int insertSelective(QuestSooAtExecutionPlan record);
}