package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemAdminOrgan;

public interface SystemAdminOrganMapper {
    int insert(SystemAdminOrgan record);

    int insertSelective(SystemAdminOrgan record);
}