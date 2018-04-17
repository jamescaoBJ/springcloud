package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemCardCreateRecord;

public interface SystemCardCreateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemCardCreateRecord record);

    int insertSelective(SystemCardCreateRecord record);

    SystemCardCreateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemCardCreateRecord record);

    int updateByPrimaryKey(SystemCardCreateRecord record);
}