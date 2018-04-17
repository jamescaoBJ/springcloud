package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeManageFunc;

public interface NcmeManageFuncMapper {
    int insert(NcmeManageFunc record);

    int insertSelective(NcmeManageFunc record);
}