package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamPaperTactic;

public interface ExamPaperTacticMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamPaperTactic record);

    int insertSelective(ExamPaperTactic record);

    ExamPaperTactic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamPaperTactic record);

    int updateByPrimaryKey(ExamPaperTactic record);
}