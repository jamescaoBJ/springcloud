package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CaseCourseDisease;

public interface CaseCourseDiseaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CaseCourseDisease record);

    int insertSelective(CaseCourseDisease record);

    CaseCourseDisease selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CaseCourseDisease record);

    int updateByPrimaryKey(CaseCourseDisease record);
}