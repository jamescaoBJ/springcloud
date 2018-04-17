package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooAtTraceFile;

public interface QuestSooAtTraceFileMapper {
    int insert(QuestSooAtTraceFile record);

    int insertSelective(QuestSooAtTraceFile record);
}