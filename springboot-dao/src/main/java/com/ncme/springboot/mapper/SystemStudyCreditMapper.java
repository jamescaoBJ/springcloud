package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemStudyCredit;

public interface SystemStudyCreditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemStudyCredit record);

    int insertSelective(SystemStudyCredit record);

    SystemStudyCredit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemStudyCredit record);

    int updateByPrimaryKey(SystemStudyCredit record);
}