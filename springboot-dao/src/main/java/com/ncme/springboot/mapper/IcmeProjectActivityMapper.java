package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeProjectActivity;

public interface IcmeProjectActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeProjectActivity record);

    int insertSelective(IcmeProjectActivity record);

    IcmeProjectActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeProjectActivity record);

    int updateByPrimaryKey(IcmeProjectActivity record);
}