package com.ncme.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.CvUnit;

public interface CvUnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvUnit record);

    int insertSelective(CvUnit record);

    CvUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvUnit record);

    int updateByPrimaryKey(CvUnit record);
    
    /**
     * countPoints:
     * 根据项目id统计该项目中所有课程的任务点(isPoint 0:代表不是任务点，1：代表是任务点)
     * @param  @param cvSetId
     * @param  @return    
     * @return int    
     * @throws 
     * @since  　version 1.0
    */
    Integer countPoints(@Param("cvSetId")Integer cvSetId, @Param("isPoint")Integer isPoint);
    
    /**
     * completedLogUnits:
     * 根据项目id查询用户已经完成的课程任务点个数(isPoint 0:代表不是任务点，1：代表是任务点)
     * @param  @param userId
     * @param  @param cvSetId
     * @param  @return    
     * @return int    
     * @throws 
     * @since  　version 1.0
    */
    Integer completedLogUnits(@Param("userId")Integer userId, @Param("cvSetId")Integer cvSetId, @Param("isPoint")Integer isPoint);
    
    /**
     * getUnitListByCvId:
     * 根据课程id返回单元信息
     * @param  @param cvId
     * @param  @return    
     * @return List<Record>    
     * @throws 
     * @since  　version 1.0
    */
    List<Record> getUnitListByCvId(Integer cvId);
    
    /**
     * queryUnitLogStudyByCvSetIdAndUserId:
     * 根据项目Id和userId查询单元的学习记录信息
     * @param  @param userId
     * @param  @param cvSetId
     * @param  @return    
     * @return List<Record>    
     * @throws 
     * @since  　version 1.0
    */
    List<Record> queryUnitLogStudyByCvSetIdAndUserId(@Param("userId")Integer userId, @Param("cvSetId")Integer cvSetId);
    
    /**
     * queryCVUnitLogStudyByUnitIdAndUserId:
     *  根据单元Id和userId查询单元的学习记录信息、单元信息
     * @param  @param userId
     * @param  @param cvSetId
     * @param  @return    
     * @return List<Record>    
     * @throws 
     * @since  　version 1.0
    */
    Record getCVUnitLogStudyByUnitIdAndUserId(@Param("userId")Integer userId, @Param("unitId")Integer unitId);
    
    /**
     * getExamPaperByUnitId:
     * 根据单元id得到随堂考试试卷id，试卷名称，达标要求
     * @param  @param unitId
     * @param  @return    
     * @return Record    
     * @throws 
     * @since  　version 1.0
    */
    Record getExamPaperByUnitId(Integer unitId);
    
    /**
     * getPointsByCvId:
     * 查询课程下总的任务点单元数量
     * @param  @param cvId
     * @param  @return    
     * @return Integer    
     * @throws 
     * @since  　version 1.0
    */
    Integer getPointsByCvId(@Param("cvId")Integer cvId, @Param("unitMakeType")Integer unitMakeType);
    
    /**
     * getCompletePointsByUIdAndCvId:
     * 查询会员已学过的任务点单元数量
     * @param  @param userId
     * @param  @param cvId
     * @param  @param unitMakeType
     * @param  @return    
     * @return Integer    
     * @throws 
     * @since  　version 1.0
    */
    Integer getCompletePointsByUIdAndCvId(@Param("userId")Integer userId, @Param("cvId")Integer cvId, @Param("unitMakeType")Integer unitMakeType);
}