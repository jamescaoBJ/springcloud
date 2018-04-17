package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooEventCategories;

public interface QuestSooEventCategoriesMapper {
    int insert(QuestSooEventCategories record);

    int insertSelective(QuestSooEventCategories record);
}