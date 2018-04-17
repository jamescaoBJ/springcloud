package com.ncme.springboot.mapper;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.model.LogExam;

public interface LogExamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogExam record);

    int insertSelective(LogExam record);

    LogExam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogExam record);

    int updateByPrimaryKey(LogExam record);
    
    /**
     * getLogExamByUIdAndExamId:
     * 根据用户Id 考试Id查询是否参加过考试
     * 
     * @param  @param userId
     * @param  @param examId
     * @param  @return    
     * @return LogExam    
     * @throws 
     * @since  　version 1.0
    */
    LogExam getLogExamByUIdAndExamId(@Param("userId") Integer userId, @Param("examId") Integer examId);
    
    /**
     * saveLogExam:
     * 保存考试记录表
     * @param  @param record    
     * @return void    
     * @throws 
     * @since  　version 1.0
    */
    void saveLogExam(LogExam record);
}