package com.wjw.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;

/**
 * ClassName:StudyService
 * Function: 学习Service
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2018年2月26日	上午10:51:33
 *
 * @see 	 
 *  
 */
public interface StudyService {

	/**
	 * annualReport:
	 * 年度学习报告
	 * @param  @param userId
	 * @param  @param year
	 * @param  @param domainName
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	Record annualReport(Integer userId, Integer year, String domainName);
	
	/**
	 * annualProjectReport:
	 * 年度项目学习报告
	 * @param  @param userId
	 * @param  @param year
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	PageInfo<Record> annualProjectReport(Integer userId, Integer year ,String pageNum, String pageSize);
	
	/**
	 * reportDetail:
	 * 项目学习报告详情
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	Record reportDetail(Integer userId, Integer projectId);
	
	/**
	 * studyTime:
	 * 学习时长折线图
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @param year
	 * @param  @param month
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> studyTime(Integer userId, Integer projectId, Integer year, Integer month);
}
