package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentSurveyQuestion;

public interface TrainContentSurveyQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainContentSurveyQuestion record);

    int insertSelective(TrainContentSurveyQuestion record);

    TrainContentSurveyQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainContentSurveyQuestion record);

    int updateByPrimaryKey(TrainContentSurveyQuestion record);
}