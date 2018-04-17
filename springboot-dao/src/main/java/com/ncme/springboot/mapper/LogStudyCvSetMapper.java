package com.ncme.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.model.LogStudyCvSet;

public interface LogStudyCvSetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogStudyCvSet record);

    int insertSelective(LogStudyCvSet record);

    LogStudyCvSet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogStudyCvSet record);

    int updateByPrimaryKey(LogStudyCvSet record);
    
    /**
     * 根据用户id和项目id查询学习日志表（用户id可以传null或0，代表用项目id查询）
     * @param  @param cvSetId
     * @param  @return    
     * @return List<LogStudyCvSet>    
     * @since  　version 1.0
    */
    List<LogStudyCvSet> listLogStudyByCvSetId(@Param("userId")Integer userId, @Param("cvSetId")Integer cvSetId);
    
    /**
     * getCompletedCvSetNum:
     * 年度报告获得已完成项目个数
     * @param  @param userId
     * @param  @param cvSetId
     * @param  @return    
     * @return Integer    
     * @throws 
     * @since  　version 1.0
    */
    Integer getCompletedCvSetNum(@Param("userId")Integer userId, @Param("year")Integer year, @Param("domainName")String domainName);
    
}