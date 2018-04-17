package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeSubject;

public interface NcmeSubjectMapper {
    int insert(NcmeSubject record);

    int insertSelective(NcmeSubject record);
}