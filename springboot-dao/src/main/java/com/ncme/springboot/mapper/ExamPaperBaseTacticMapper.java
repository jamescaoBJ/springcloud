package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamPaperBaseTactic;

public interface ExamPaperBaseTacticMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamPaperBaseTactic record);

    int insertSelective(ExamPaperBaseTactic record);

    ExamPaperBaseTactic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamPaperBaseTactic record);

    int updateByPrimaryKey(ExamPaperBaseTactic record);
}