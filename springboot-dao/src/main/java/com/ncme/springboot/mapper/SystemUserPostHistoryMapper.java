package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemUserPostHistory;

public interface SystemUserPostHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemUserPostHistory record);

    int insertSelective(SystemUserPostHistory record);

    SystemUserPostHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemUserPostHistory record);

    int updateByPrimaryKey(SystemUserPostHistory record);
}