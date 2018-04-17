package com.wjw.service;

import java.math.BigDecimal;
import java.util.Date;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.CvSetScore;
import com.ncme.springboot.model.CvSetScoreLog;

public interface CvSetScoreService {
	/**
	 * 添加项目评价
	 * @param record
	 * @return
	 */
	  void insert(Integer cvSetId,Integer systemUserId,  BigDecimal score1,BigDecimal score2,BigDecimal score3,BigDecimal score4,Date scoreDate,String scoreContent);

	/**
	 * getScoreByCvSetId:
	 * 根据项目id查询项目评分
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return CvSetScore    
	 * @throws 
	 * @since  　version 1.0
	*/
	CvSetScore getScoreByCvSetId(Integer cvSetId);
	
	/**
	 * listScoreLogByCvSetId:
	 * 根据项目id查询项目评价信息
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return PageInfo<CvSetScoreLog>    
	 * @throws 
	 * @since  　version 1.0
	*/
	PageInfo<Record> listScoreLogByCvSetId(Integer cvSetId, String pageNum, String pageSize);
}
