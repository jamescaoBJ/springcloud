package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeSiteProjectType;

public interface IcmeSiteProjectTypeMapper {
    int insert(IcmeSiteProjectType record);

    int insertSelective(IcmeSiteProjectType record);
}