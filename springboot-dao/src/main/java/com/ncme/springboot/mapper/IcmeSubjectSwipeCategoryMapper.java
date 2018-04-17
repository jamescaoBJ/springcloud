package com.ncme.springboot.mapper;

import com.ncme.springboot.model.IcmeSubjectSwipeCategory;

public interface IcmeSubjectSwipeCategoryMapper {
    int insert(IcmeSubjectSwipeCategory record);

    int insertSelective(IcmeSubjectSwipeCategory record);
}