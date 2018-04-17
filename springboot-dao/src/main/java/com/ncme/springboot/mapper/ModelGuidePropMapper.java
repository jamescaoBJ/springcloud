package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ModelGuideProp;

public interface ModelGuidePropMapper {
    int insert(ModelGuideProp record);

    int insertSelective(ModelGuideProp record);
}