package com.ncme.springboot.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.CvSetScoreLog;
import com.ncme.springboot.model.CvSetScoreLogKey;

public interface CvSetScoreLogMapper {
    int deleteByPrimaryKey(CvSetScoreLogKey key);

    void insert(@Param("cvSetId")Integer cvSetId, @Param("systemUserId")Integer systemUserId ,@Param("score1")BigDecimal score1,@Param("score2")BigDecimal score2,@Param("score3")BigDecimal score3,@Param("score4")BigDecimal score4,@Param("scoreDate")Date scoreDate,@Param("scoreContent")String scoreContent);

    int insertSelective(CvSetScoreLog record);

    CvSetScoreLog selectByPrimaryKey(CvSetScoreLogKey key);

    int updateByPrimaryKeySelective(CvSetScoreLog record);

    int updateByPrimaryKey(CvSetScoreLog record);
    
    /**
     * listScoreLog:
     * 根据项目id查询项目评价信息
     * @param  @param cvSetId
     * @param  @return    
     * @return List<CvSetScoreLog>    
     * @throws 
     * @since  　version 1.0
    */
    List<Record> listScoreLogByCvSetId(Integer cvSetId);
    
    /**
     * getScoreLogByUserIdAndCvSetId:
     * 根据用户id和项目id查询该项目评价信息
     * @param  @param userId
     * @param  @param cvSetId
     * @param  @return    
     * @return CvSetScoreLog    
     * @throws 
     * @since  　version 1.0
    */
    CvSetScoreLog getScoreLogByUserIdAndCvSetId(@Param("userId")Integer userId, @Param("cvSetId")Integer cvSetId);
}