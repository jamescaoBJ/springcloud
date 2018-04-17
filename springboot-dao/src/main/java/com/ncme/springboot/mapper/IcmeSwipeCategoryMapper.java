package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeSwipeCategory;

public interface IcmeSwipeCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeSwipeCategory record);

    int insertSelective(IcmeSwipeCategory record);

    IcmeSwipeCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeSwipeCategory record);

    int updateByPrimaryKey(IcmeSwipeCategory record);
}