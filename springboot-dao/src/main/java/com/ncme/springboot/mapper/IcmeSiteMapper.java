package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeSite;

public interface IcmeSiteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeSite record);

    int insertSelective(IcmeSite record);

    IcmeSite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeSite record);

    int updateByPrimaryKey(IcmeSite record);
}