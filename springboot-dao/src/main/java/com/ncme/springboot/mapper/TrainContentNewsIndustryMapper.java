package com.ncme.springboot.mapper;

import com.ncme.springboot.model.TrainContentNewsIndustry;

public interface TrainContentNewsIndustryMapper {
    int insert(TrainContentNewsIndustry record);

    int insertSelective(TrainContentNewsIndustry record);
}