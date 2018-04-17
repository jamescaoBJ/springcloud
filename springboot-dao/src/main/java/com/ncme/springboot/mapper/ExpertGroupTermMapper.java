package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ExpertGroupTerm;

public interface ExpertGroupTermMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpertGroupTerm record);

    int insertSelective(ExpertGroupTerm record);

    ExpertGroupTerm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpertGroupTerm record);

    int updateByPrimaryKey(ExpertGroupTerm record);
}