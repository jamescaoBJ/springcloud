package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamMajorOrder;

public interface ExamMajorOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamMajorOrder record);

    int insertSelective(ExamMajorOrder record);

    ExamMajorOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamMajorOrder record);

    int updateByPrimaryKey(ExamMajorOrder record);
}