package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ContentEdition;

public interface ContentEditionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContentEdition record);

    int insertSelective(ContentEdition record);

    ContentEdition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContentEdition record);

    int updateByPrimaryKey(ContentEdition record);
}