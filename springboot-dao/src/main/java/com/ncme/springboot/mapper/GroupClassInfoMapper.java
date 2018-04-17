package com.ncme.springboot.mapper;

import com.ncme.springboot.model.GroupClassInfo;

public interface GroupClassInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GroupClassInfo record);

    int insertSelective(GroupClassInfo record);

    GroupClassInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupClassInfo record);

    int updateByPrimaryKey(GroupClassInfo record);
    
    /**
     * getClassInfoByUnitId:
     * 根据单元id查询组课信息
     * @param  @param unitId
     * @param  @return    
     * @return GroupClassInfo    
     * @throws 
     * @since  　version 1.0
    */
    GroupClassInfo getClassInfoByUnitId(Integer unitId);
}