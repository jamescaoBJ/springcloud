package com.ncme.springboot.mapper;

import com.ncme.springboot.model.StudyCoursewareTitle;

public interface StudyCoursewareTitleMapper {
    int insert(StudyCoursewareTitle record);

    int insertSelective(StudyCoursewareTitle record);
}