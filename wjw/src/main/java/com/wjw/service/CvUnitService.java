package com.wjw.service;

import com.ncme.springboot.model.CvUnit;

/**
 * ClassName:CvUnitService
 * Function: 课程单元Service
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月22日	上午9:31:12
 *
 * @see 	 
 *  
 */
public interface CvUnitService {

	/**
	 * getCvUnitById:
	 * 根据单元id查询单元详情
	 * @param  @param unitId
	 * @param  @return    
	 * @return CvUnit    
	 * @throws 
	 * @since  　version 1.0
	*/
	CvUnit getCvUnitById(Integer unitId);
}
