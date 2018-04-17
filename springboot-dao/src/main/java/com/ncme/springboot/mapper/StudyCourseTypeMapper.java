package com.ncme.springboot.mapper;

import com.ncme.springboot.model.StudyCourseType;

public interface StudyCourseTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudyCourseType record);

    int insertSelective(StudyCourseType record);

    StudyCourseType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudyCourseType record);

    int updateByPrimaryKey(StudyCourseType record);
}