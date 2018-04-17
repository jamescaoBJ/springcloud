package com.ncme.springboot.mapper;

import com.ncme.springboot.model.MobileMessage;

public interface MobileMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MobileMessage record);

    int insertSelective(MobileMessage record);

    MobileMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MobileMessage record);

    int updateByPrimaryKey(MobileMessage record);
}