package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeUserQaStatus;

public interface IcmeUserQaStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeUserQaStatus record);

    int insertSelective(IcmeUserQaStatus record);

    IcmeUserQaStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeUserQaStatus record);

    int updateByPrimaryKey(IcmeUserQaStatus record);
}