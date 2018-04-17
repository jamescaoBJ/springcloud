package com.wjw.service;

import java.util.List;
import java.util.Map;

import com.ncme.springboot.model.SystemCard;
import com.ncme.springboot.model.SystemCardSetOrder;
import com.ncme.springboot.model.SystemCardTypeCvSet;
import com.ncme.springboot.model.SystemCardUser;

/**
 * ClassName:SystemCardService
 * Function: 学习卡service
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月7日	上午10:47:21
 *
 * @see 	 
 *  
 */
public interface SystemCardService {

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
	SystemCard getSystemCardByNumAndPwd(String cardNumber, String cardPassword);
	
	/**
	 * getSystemCardByNumAndCvSetId
	 * 通过项目id和学习卡号查找学习卡
	 * @param  @param cardNumber
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return SystemCard    
	 * @throws 
	 * @since  　version 1.0
	*/
	SystemCard getSystemCardByNumAndCvSetId(String cardNumber, Integer cvSetId);
	
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
	 * findByUidProid:
	 * 通过用户id和项目id查询订单是否存在
	 * @param  @param order
	 * @param  @return    
	 * @return List<SystemCardSetOrder>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<SystemCardSetOrder> findByUidProid(Map map);
	
	/**
	 * saveSystemCardSetOrder:
	 * 保存绑卡订单信息
	 * @param  @param order
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	int saveSystemCardSetOrder(SystemCardSetOrder order);
	
	/**
	 * saveBindUserinfor:
	 * 绑定卡号之后保存绑卡用户的信息
	 * @param  @param systemCardUser
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	int saveBindUserinfor(SystemCardUser systemCardUser);
	
	/**
	 * updateSystemCard:
	 * 更新学习卡信息
	 * @param  @param systemCard
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	int updateSystemCard(SystemCard systemCard);
}
