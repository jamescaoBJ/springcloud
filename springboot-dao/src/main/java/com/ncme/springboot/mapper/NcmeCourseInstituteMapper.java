package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeCourseInstitute;

public interface NcmeCourseInstituteMapper {
    int insert(NcmeCourseInstitute record);

    int insertSelective(NcmeCourseInstitute record);
}