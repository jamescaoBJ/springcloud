package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentSurvey;

public interface TrainContentSurveyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentSurvey record);

    int insertSelective(TrainContentSurvey record);

    TrainContentSurvey selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentSurvey record);

    int updateByPrimaryKey(TrainContentSurvey record);
}