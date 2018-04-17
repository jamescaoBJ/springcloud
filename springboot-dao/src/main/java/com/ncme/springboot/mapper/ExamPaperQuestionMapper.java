package com.ncme.springboot.mapper;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.model.ExamPaperQuestion;

public interface ExamPaperQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamPaperQuestion record);

    int insertSelective(ExamPaperQuestion record);

    ExamPaperQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamPaperQuestion record);

    int updateByPrimaryKey(ExamPaperQuestion record);
    
    /**
     * getQuestionByQIdAndPId:
     * 根据问题Id和试卷id查询该试题分数
     * @param  @param questionId
     * @param  @param paperId
     * @param  @return    
     * @return ExamPaperQuestion    
     * @throws 
     * @since  　version 1.0
    */
    Double getQueScoreByQIdAndPId(@Param("questionId") Integer questionId, @Param("paperId") Integer paperId);
}