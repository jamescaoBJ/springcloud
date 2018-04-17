package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamPaperTactic1PaperKey;

public interface ExamPaperTactic1PaperMapper {
    int deleteByPrimaryKey(ExamPaperTactic1PaperKey key);

    int insert(ExamPaperTactic1PaperKey record);

    int insertSelective(ExamPaperTactic1PaperKey record);
}