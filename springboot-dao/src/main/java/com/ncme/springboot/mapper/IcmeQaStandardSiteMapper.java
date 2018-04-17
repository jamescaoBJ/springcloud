package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeQaStandardSite;

public interface IcmeQaStandardSiteMapper {
    int insert(IcmeQaStandardSite record);

    int insertSelective(IcmeQaStandardSite record);
}