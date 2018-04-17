package com.ncme.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.LogStudyCvUnitVideoCensus;

public interface LogStudyCvUnitVideoCensusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogStudyCvUnitVideoCensus record);

    int insertSelective(LogStudyCvUnitVideoCensus record);

    LogStudyCvUnitVideoCensus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogStudyCvUnitVideoCensus record);

    int updateByPrimaryKey(LogStudyCvUnitVideoCensus record);
    
    /**
     * getStudyLengthByUserId:
     * 根据用户id查询该用户的学习长度
     * @param  @param userId
     * @param  @return    
     * @return int    
     * @throws 
     * @since  　version 1.0
    */
    Integer getStudyLengthByUserId(@Param("userId")Integer userId, @Param("year")Integer year, @Param("cvSetId")Integer cvSetId);
    
    /**
     * studyTime:
     * 学习报告折线图
     * @param  @param userId
     * @param  @param cvSetId
     * @param  @param year
     * @param  @param month
     * @param  @return    
     * @return List<Record>    
     * @throws 
     * @since  　version 1.0
    */
    List<Record> studyTime(@Param("userId")Integer userId, @Param("cvSetId")Integer cvSetId, @Param("year")Integer year, @Param("month")Integer month);
}