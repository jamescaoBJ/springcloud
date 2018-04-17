package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeQaStandardProf;

public interface IcmeQaStandardProfMapper {
    int insert(IcmeQaStandardProf record);

    int insertSelective(IcmeQaStandardProf record);
}