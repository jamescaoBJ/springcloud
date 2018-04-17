package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExpertGroup;

public interface ExpertGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpertGroup record);

    int insertSelective(ExpertGroup record);

    ExpertGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpertGroup record);

    int updateByPrimaryKey(ExpertGroup record);
}