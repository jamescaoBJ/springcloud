package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentSurveyRole;

public interface TrainContentSurveyRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentSurveyRole record);

    int insertSelective(TrainContentSurveyRole record);

    TrainContentSurveyRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentSurveyRole record);

    int updateByPrimaryKey(TrainContentSurveyRole record);
}