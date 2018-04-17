package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeManageLogFunc;

public interface NcmeManageLogFuncMapper {
    int insert(NcmeManageLogFunc record);

    int insertSelective(NcmeManageLogFunc record);
}