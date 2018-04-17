package com.ncme.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;

public interface WeiXinMapper {
   
	
	/**
	 * 
	 * selectSpeciaByPage:
	 * 获取专项列表
	 *
	 * @param  @param userId
	 * @param  @param favType
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> selectSpeciaByPage();
	
	/**
	 * 
	 * isSignUp1:
	 * 验证本期是否已报名-专项列表专用
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return boolean    
	 * @throws 
	 * @since  　version 1.0
	 */
	int isSignUp1(Map<String,Object> map);
	
	/**
	 * 
	 * getSpecialDetail:
	 * 获取专项详情
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return Special    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getSpecialDetail(Map<String,Object> map);
	
	/**
	 * 
	 * getSpecialFaceteach:
	 * 获取专项期数
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getSpecialFaceteach(Map<String,Object> map);
	
	/**
	 * 
	 * isSignUp:
	 * TODO(验证本期是否已报名)
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return boolean    
	 * @throws 
	 * @since  　version 1.0
	 */
	int isSignUp(Map<String,Object> map);

	/**
	 * 
	 * getSpecialCourseList:
	 * 获取专项下课程
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getSpecialCourseList(Map<String,Object> map);
	
	/**
	 * 
	 * saveSignUp:
	 * 专项报名
	 *
	 * @param  @param map    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	 */
	void saveSignUp(Map<String,Object> map);
	
	/**
	 * 
	 * getSignUp:
	 * 查看报名表
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getSignUp(Map<String,Object> map);

}