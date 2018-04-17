package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamSysQuestTypeQuest;

public interface ExamSysQuestTypeQuestMapper {
    int insert(ExamSysQuestTypeQuest record);

    int insertSelective(ExamSysQuestTypeQuest record);
}