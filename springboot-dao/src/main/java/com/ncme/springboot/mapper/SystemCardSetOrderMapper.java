package com.ncme.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.SystemCardSetOrder;

public interface SystemCardSetOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemCardSetOrder record);

    int insertSelective(SystemCardSetOrder record);

    SystemCardSetOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemCardSetOrder record);

    int updateByPrimaryKey(SystemCardSetOrder record);
    
    /**
     * findByUidProid:
     * 通过用户id和项目id查询订单是否存在
     * @param  @param record
     * @param  @return    
     * @return List<SystemCardSetOrder>    
     * @throws 
     * @since  　version 1.0
    */
    List<SystemCardSetOrder> findByUidProid(Map map);

	/**
	 * cardList:学习卡列表
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param status
	 * @param  @param id
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> cardList(@Param("status") String status,@Param("id") Integer id);

	/**
	 * cardDetails:学习卡详情
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param userId 
	 *
	 * @param  @param cardType
	 * @param  @param cardNumber
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	Record cardDetails( @Param("userId") Integer userId, @Param("cardType") String cardType, @Param("cardNumber") String cardNumber);
}