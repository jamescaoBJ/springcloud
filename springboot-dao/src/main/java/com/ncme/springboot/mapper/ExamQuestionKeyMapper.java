package com.ncme.springboot.mapper;

import java.util.List;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.ExamQuestionKey;

public interface ExamQuestionKeyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamQuestionKey record);

    int insertSelective(ExamQuestionKey record);

    ExamQuestionKey selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamQuestionKey record);

    int updateByPrimaryKey(ExamQuestionKey record);
    
    /**
     * listQuestionKeyByQId:
     * 根据试题id查询试题选项
     * @param  @param questionId
     * @param  @return    
     * @return List<ExamQuestionKey>    
     * @throws 
     * @since  　version 1.0
    */
    List<ExamQuestionKey> listQuestionKeyByQId(Integer questionId);
    
    /**
     * getQuestionKeyByQId:
     * 根据试题id查询试题选项
     * @param  @param questionId
     * @param  @return    
     * @return List<Record>    
     * @throws 
     * @since  　version 1.0
    */
    List<Record> getQuestionKeyByQId(Integer questionId);
}