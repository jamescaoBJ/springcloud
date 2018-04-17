package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamExamPaper;

public interface ExamExamPaperMapper {
    int insert(ExamExamPaper record);

    int insertSelective(ExamExamPaper record);
}