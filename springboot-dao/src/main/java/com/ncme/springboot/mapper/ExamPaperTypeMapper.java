package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamPaperType;

public interface ExamPaperTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamPaperType record);

    int insertSelective(ExamPaperType record);

    ExamPaperType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamPaperType record);

    int updateByPrimaryKey(ExamPaperType record);
}