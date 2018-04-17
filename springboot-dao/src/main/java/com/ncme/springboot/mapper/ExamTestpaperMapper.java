package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExamTestpaper;

public interface ExamTestpaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamTestpaper record);

    int insertSelective(ExamTestpaper record);

    ExamTestpaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamTestpaper record);

    int updateByPrimaryKey(ExamTestpaper record);
}