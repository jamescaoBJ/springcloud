package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamSourceType;

public interface ExamSourceTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamSourceType record);

    int insertSelective(ExamSourceType record);

    ExamSourceType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamSourceType record);

    int updateByPrimaryKey(ExamSourceType record);
}