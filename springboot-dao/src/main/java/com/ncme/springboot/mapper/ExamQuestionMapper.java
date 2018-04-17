package com.ncme.springboot.mapper;

import java.util.List;

import com.ncme.springboot.model.ExamQuestion;

public interface ExamQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamQuestion record);

    int insertSelective(ExamQuestion record);

    ExamQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamQuestion record);

    int updateByPrimaryKey(ExamQuestion record);
    
    /**
     * getQuestionByPaperId:
     * 根据试卷id查询试题列表
     * @param  @param paperId
     * @param  @return    
     * @return List<ExamQuestion>    
     * @throws 
     * @since  　version 1.0
    */
    List<ExamQuestion> getQuestionByPaperId(Integer paperId);
    
    /**
     * listQuestionByParentId:
     * 根据parentId查询子试题
     * @param  @param parentId
     * @param  @return    
     * @return List<ExamQuestion>    
     * @throws 
     * @since  　version 1.0
    */
    List<ExamQuestion> listQuestionByParentId(Integer parentId);
}