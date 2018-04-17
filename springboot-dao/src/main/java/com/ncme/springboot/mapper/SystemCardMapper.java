package com.ncme.springboot.mapper;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.model.SystemCard;

public interface SystemCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemCard record);

    int insertSelective(SystemCard record);

    SystemCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemCard record);

    int updateByPrimaryKey(SystemCard record);
    
    /**
     * getSystemCardByNumAndPwd:
     * 根据卡号和密码查询学习卡信息
     * TODO(这里描述这个方法适用条件 – 可选)
     *
     * @param  @param cardNumber
     * @param  @param cardPassword
     * @param  @return    
     * @return SystemCard    
     * @throws 
     * @since  　version 1.0
    */
    SystemCard getSystemCardByNumAndPwd(@Param("cardNumber")String cardNumber, @Param("cardPassword")String cardPassword);
    
    /**
     * getSystemCardByNumAndCvSetId:(
     * 通过项目id和学习卡号查找学习卡
     * @param  @param cardNumber
     * @param  @param cvSetId
     * @param  @return    
     * @return SystemCard    
     * @throws 
     * @since  　version 1.0
    */
    SystemCard getSystemCardByNumAndCvSetId(@Param("cardNumber")String cardNumber, @Param("cvSetId")Integer cvSetId);
}