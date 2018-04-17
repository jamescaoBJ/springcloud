package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentSubject;

public interface TrainContentSubjectMapper {
    int deleteByPrimaryKey(Integer subjectId);

    int insert(TrainContentSubject record);

    int insertSelective(TrainContentSubject record);

    TrainContentSubject selectByPrimaryKey(Integer subjectId);

    int updateByPrimaryKeySelective(TrainContentSubject record);

    int updateByPrimaryKey(TrainContentSubject record);
}