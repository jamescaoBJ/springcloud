package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemSite;

public interface SystemSiteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemSite record);

    int insertSelective(SystemSite record);

    SystemSite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemSite record);

    int updateByPrimaryKey(SystemSite record);
}