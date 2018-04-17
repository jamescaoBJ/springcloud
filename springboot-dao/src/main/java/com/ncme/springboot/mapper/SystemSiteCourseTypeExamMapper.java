package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemSiteCourseTypeExam;

public interface SystemSiteCourseTypeExamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemSiteCourseTypeExam record);

    int insertSelective(SystemSiteCourseTypeExam record);

    SystemSiteCourseTypeExam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemSiteCourseTypeExam record);

    int updateByPrimaryKey(SystemSiteCourseTypeExam record);
}