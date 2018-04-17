package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamQuestPropvalCascade;

public interface ExamQuestPropvalCascadeMapper {
    int insert(ExamQuestPropvalCascade record);

    int insertSelective(ExamQuestPropvalCascade record);
}