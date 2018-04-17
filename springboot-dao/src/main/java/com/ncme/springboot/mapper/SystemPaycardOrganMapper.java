package com.ncme.springboot.mapper;

import com.ncme.springboot.model.SystemPaycardOrgan;

public interface SystemPaycardOrganMapper {
    int insert(SystemPaycardOrgan record);

    int insertSelective(SystemPaycardOrgan record);
}