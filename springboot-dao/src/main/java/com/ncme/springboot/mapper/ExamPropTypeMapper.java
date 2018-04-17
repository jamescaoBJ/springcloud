package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamPropType;

public interface ExamPropTypeMapper {
    int insert(ExamPropType record);

    int insertSelective(ExamPropType record);
}