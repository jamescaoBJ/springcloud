package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeCourseSubject;

public interface NcmeCourseSubjectMapper {
    int insert(NcmeCourseSubject record);

    int insertSelective(NcmeCourseSubject record);
}