package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemCardCreateRecordBak;

public interface SystemCardCreateRecordBakMapper {
    int insert(SystemCardCreateRecordBak record);

    int insertSelective(SystemCardCreateRecordBak record);
}