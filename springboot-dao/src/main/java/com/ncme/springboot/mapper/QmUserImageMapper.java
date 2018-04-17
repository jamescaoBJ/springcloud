package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QmUserImage;

public interface QmUserImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QmUserImage record);

    int insertSelective(QmUserImage record);

    QmUserImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QmUserImage record);

    int updateByPrimaryKey(QmUserImage record);
}