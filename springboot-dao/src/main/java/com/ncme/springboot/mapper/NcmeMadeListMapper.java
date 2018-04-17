package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeMadeList;

public interface NcmeMadeListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NcmeMadeList record);

    int insertSelective(NcmeMadeList record);

    NcmeMadeList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NcmeMadeList record);

    int updateByPrimaryKey(NcmeMadeList record);
}