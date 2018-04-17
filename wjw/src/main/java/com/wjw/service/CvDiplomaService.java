package com.wjw.service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.CvDiploma;

/**
 * ClassName:CvDiplomaService
 * Function: 证书Service
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月13日	下午3:38:59
 *
 * @see 	 
 *  
 */
public interface CvDiplomaService {

	/**
	 * saveCvDiploma:
	 * 保存学分证书
	 * @param  @param cvDiploma
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	int saveCvDiploma(CvDiploma cvDiploma);
	
	/**
	 * getCvDiplomaByUserIdAndCode:
	 * 根据用户id和项目编号查询证书
	 * @param  @param userId
	 * @param  @param itemNumber
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	Record getCvDiplomaByUserIdAndCode(Integer userId, Integer cvSetId, String itemNumber, Integer provinceId, String domainName);
}
