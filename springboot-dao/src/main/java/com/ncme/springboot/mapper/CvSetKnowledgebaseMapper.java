package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvSetKnowledgebase;

public interface CvSetKnowledgebaseMapper {
    int insert(CvSetKnowledgebase record);

    int insertSelective(CvSetKnowledgebase record);
}