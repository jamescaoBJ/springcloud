package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainOfflineExamSignup;

public interface TrainOfflineExamSignupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainOfflineExamSignup record);

    int insertSelective(TrainOfflineExamSignup record);

    TrainOfflineExamSignup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainOfflineExamSignup record);

    int updateByPrimaryKey(TrainOfflineExamSignup record);
}