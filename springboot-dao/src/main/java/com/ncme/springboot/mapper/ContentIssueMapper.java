package com.ncme.springboot.mapper;

import com.ncme.springboot.model.ContentIssue;

public interface ContentIssueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContentIssue record);

    int insertSelective(ContentIssue record);

    ContentIssue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContentIssue record);

    int updateByPrimaryKey(ContentIssue record);
}