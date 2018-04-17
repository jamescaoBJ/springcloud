package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemSiteOrgan;

public interface SystemSiteOrganMapper {
    int insert(SystemSiteOrgan record);

    int insertSelective(SystemSiteOrgan record);
}