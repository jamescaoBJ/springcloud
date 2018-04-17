package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemResourceOld;

public interface SystemResourceOldMapper {
    int insert(SystemResourceOld record);

    int insertSelective(SystemResourceOld record);
}