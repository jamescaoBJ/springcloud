package com.ncme.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.SystemMessage;

public interface SystemMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemMessage record);

    int insertSelective(SystemMessage record);

    SystemMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemMessage record);

    int updateByPrimaryKey(SystemMessage record);
    
    /**
     * getMessageList:
     * 根据用户id查询消息列表
     * @param  @param userId
     * @param  @return    
     * @return List<Record>    
     * @throws 
     * @since  　version 1.0
    */
    List<Record> getMessageList(Integer userId);
    
    /**
     * getNotReadCount:
     * 根据用户id查询该用户未读消息数量
     * @param  @param userId
     * @param  @return    
     * @return int    
     * @throws 
     * @since  　version 1.0
    */
    int getNotReadCount(Integer userId);
    
    /**
     * markReadMessageByUserId:
     * 根据用户id标记为已读信息
     * @param  @param userId
     * @param  @param isRead    
     * @return void    
     * @throws 
     * @since  　version 1.0
    */
    void markReadMessageByUserId(@Param("userId") Integer userId, @Param("isRead") Integer isRead);
}