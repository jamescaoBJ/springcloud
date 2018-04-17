package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvSchedule;

public interface CvScheduleMapper {
    int deleteByPrimaryKey(Integer scheduleId);

    int insert(CvSchedule record);

    int insertSelective(CvSchedule record);

    CvSchedule selectByPrimaryKey(Integer scheduleId);

    int updateByPrimaryKeySelective(CvSchedule record);

    int updateByPrimaryKey(CvSchedule record);
}