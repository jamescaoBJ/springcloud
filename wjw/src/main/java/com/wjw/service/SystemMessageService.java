package com.wjw.service;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.SystemMessage;

/**
 * ClassName:SystemMessageService
 * Function: 系统消息service
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月8日	下午5:28:28
 *
 * @see 	 
 *  
 */
public interface SystemMessageService {

	/**
	 * getMessageList:
	 * 得到系统消息列表
	 * @param  @param userId
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	PageInfo<Record> getMessageList(Integer userId, String pageNum, String pageSize);
	
	/**
	 * 
	 * saveMessage:
	 * TODO(保存推送消息)
	 *
	 * @param  @param userId
	 * @param  @param messageContent    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void saveMessage(SystemMessage record);
	
	/**
	 * getNotReadCount:
	 * 得到未读消息数量
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
	void markReadMessageByUserId(Integer userId, Integer isRead);
}
