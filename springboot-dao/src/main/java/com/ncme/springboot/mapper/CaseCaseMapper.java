package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CaseCase;

public interface CaseCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CaseCase record);

    int insertSelective(CaseCase record);

    CaseCase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CaseCase record);

    int updateByPrimaryKey(CaseCase record);
}