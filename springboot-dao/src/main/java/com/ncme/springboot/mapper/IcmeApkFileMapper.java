package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeApkFile;

public interface IcmeApkFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeApkFile record);

    int insertSelective(IcmeApkFile record);

    IcmeApkFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeApkFile record);

    int updateByPrimaryKey(IcmeApkFile record);
}