package com.ncme.springboot.mapper;

import com.ncme.springboot.model.StudyCourseElementQuestion;

public interface StudyCourseElementQuestionMapper {
    int insert(StudyCourseElementQuestion record);

    int insertSelective(StudyCourseElementQuestion record);
}