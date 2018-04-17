package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeCmsOrgNews;

public interface IcmeCmsOrgNewsMapper {
    int insert(IcmeCmsOrgNews record);

    int insertSelective(IcmeCmsOrgNews record);
}