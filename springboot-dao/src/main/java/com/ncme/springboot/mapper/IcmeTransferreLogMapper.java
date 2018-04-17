package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeTransferreLog;

public interface IcmeTransferreLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeTransferreLog record);

    int insertSelective(IcmeTransferreLog record);

    IcmeTransferreLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeTransferreLog record);

    int updateByPrimaryKey(IcmeTransferreLog record);
}