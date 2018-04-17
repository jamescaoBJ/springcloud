package com.ncme.springboot.mapper;

import com.ncme.springboot.model.LogStudyDetail;

public interface LogStudyDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogStudyDetail record);

    int insertSelective(LogStudyDetail record);

    LogStudyDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogStudyDetail record);

    int updateByPrimaryKey(LogStudyDetail record);
}