package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeProjectScoreSubject;

public interface IcmeProjectScoreSubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IcmeProjectScoreSubject record);

    int insertSelective(IcmeProjectScoreSubject record);

    IcmeProjectScoreSubject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IcmeProjectScoreSubject record);

    int updateByPrimaryKey(IcmeProjectScoreSubject record);
}