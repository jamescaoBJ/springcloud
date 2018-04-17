package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooParseTimeTrack;

public interface QuestSooParseTimeTrackMapper {
    int insert(QuestSooParseTimeTrack record);

    int insertSelective(QuestSooParseTimeTrack record);
}