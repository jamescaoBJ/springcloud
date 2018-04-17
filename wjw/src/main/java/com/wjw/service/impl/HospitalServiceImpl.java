/**
 * HospitalServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月13日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.mapper.ExamHospitalMapper;
import com.wjw.service.HospitalService;

/**
 * ClassName:HospitalServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月13日	下午2:26:19
 *
 * @see 	 
 *  
 */

@Service

public class HospitalServiceImpl implements HospitalService{

	@Autowired
	ExamHospitalMapper examHospitalMapper;
	@Override
	public List<Record> getHospitalByArea(String countyId,String keyWord) {
		
		// TODO Auto-generated method stub
		return examHospitalMapper.getHospitalByArea(countyId,keyWord);
		
	}

}
