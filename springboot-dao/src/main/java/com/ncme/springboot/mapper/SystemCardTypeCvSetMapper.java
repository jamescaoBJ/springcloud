package com.ncme.springboot.mapper;

import java.util.List;

import com.ncme.springboot.model.SystemCardTypeCvSet;

public interface SystemCardTypeCvSetMapper {
    int insert(SystemCardTypeCvSet record);

    int insertSelective(SystemCardTypeCvSet record);
    
    /**
     * findCvSetListByCardType:
     * 根据卡类型查询相关联的项目
     * @param  @param cardType
     * @param  @return    
     * @return SystemCardTypeCvSet    
     * @throws 
     * @since  　version 1.0
    */
    List<SystemCardTypeCvSet> findCvSetListByCardType(Integer cardType);
    
    /**
     * findListBycvSetId:
     * 查询卡类型里是否包含该项目
     * @param  @param cvSetId
     * @param  @return    
     * @return List<SystemCardTypeCvSet>    
     * @throws 
     * @since  　version 1.0
    */
    List<SystemCardTypeCvSet> findListBycvSetId(Integer cvSetId);
}