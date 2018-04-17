package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemResourceSite;

public interface SystemResourceSiteMapper {
    int insert(SystemResourceSite record);

    int insertSelective(SystemResourceSite record);
}