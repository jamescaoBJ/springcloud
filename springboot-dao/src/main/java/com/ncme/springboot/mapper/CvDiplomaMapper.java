package com.ncme.springboot.mapper;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.CvDiploma;

public interface CvDiplomaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvDiploma record);

    int insertSelective(CvDiploma record);

    CvDiploma selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvDiploma record);

    int updateByPrimaryKey(CvDiploma record);
    
    /**
     * getCvDiplomaByUserIdAndCode:
     * 根据用户id和项目编号查询证书信息
     * @param  @param userId
     * @param  @param itemNumber
     * @param  @return    
     * @return Record    
     * @throws 
     * @since  　version 1.0
    */
    Record getCvDiplomaByUserIdAndCode(@Param("userId")Integer userId, @Param("itemNumber")String itemNumber); 
    
    /**
     * getScoreByUserId:
     * 根据用户id查询该用户所有的学分之和
     * @param  @param userId
     * @param  @return    
     * @return double    
     * @throws 
     * @since  　version 1.0
    */
    Double getScoreByUserId(@Param("userId")Integer userId, @Param("year")Integer year);
}