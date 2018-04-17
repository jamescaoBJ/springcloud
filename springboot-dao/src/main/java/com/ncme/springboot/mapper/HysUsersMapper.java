package com.ncme.springboot.mapper;

import com.ncme.springboot.model.HysUsers;

public interface HysUsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HysUsers record);

    int insertSelective(HysUsers record);

    HysUsers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HysUsers record);

    int updateByPrimaryKey(HysUsers record);
}