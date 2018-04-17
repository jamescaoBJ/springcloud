package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeManageUser;

public interface NcmeManageUserMapper {
    int insert(NcmeManageUser record);

    int insertSelective(NcmeManageUser record);
}