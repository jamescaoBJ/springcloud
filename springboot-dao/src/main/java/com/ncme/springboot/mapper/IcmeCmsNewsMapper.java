package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeCmsNews;

public interface IcmeCmsNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeCmsNews record);

    int insertSelective(IcmeCmsNews record);

    IcmeCmsNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeCmsNews record);

    int updateByPrimaryKeyWithBLOBs(IcmeCmsNews record);

    int updateByPrimaryKey(IcmeCmsNews record);
}