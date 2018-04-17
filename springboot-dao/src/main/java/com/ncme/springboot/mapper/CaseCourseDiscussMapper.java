package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CaseCourseDiscuss;

public interface CaseCourseDiscussMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CaseCourseDiscuss record);

    int insertSelective(CaseCourseDiscuss record);

    CaseCourseDiscuss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CaseCourseDiscuss record);

    int updateByPrimaryKey(CaseCourseDiscuss record);
}