/**
 * AreaServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月3日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.mapper.ExamIcdPropValMapper;
import com.ncme.springboot.mapper.ExamPropValMapper;
import com.ncme.springboot.model.ExamPropVal;
import com.wjw.service.AreaService;

/**
 * ClassName:AreaServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月3日	下午4:44:45
 *
 * @see 	 
 *  
 */
@Service
public class AreaServiceImpl implements AreaService{

	/**
	 * examPropValMapper:TODO 属性表mapper
	 *
	 * @since version 1.0
	 */
	@Autowired
	ExamPropValMapper examPropValMapper;
	/**
	 * 获取省信息
	 * @see com.wjw.service.AreaService#getProvince(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Record> getProvince(String provinceId,String provinceName) {
		
		return examPropValMapper.getProvince(provinceId,provinceName);
		
	}
	
	/**
	 * 获取市信息
	 * @see com.wjw.service.AreaService#getCityByProvinceId(java.lang.String)
	 */
	@Override
	public List<Record> getCityByProvinceId(String provinceId) {
		
		List<Record> cities = examPropValMapper.getCityByProvinceId(provinceId);
		
		return cities;
		
	}


	/**
	 * 获取市信息，按照市id
	 * @see com.wjw.service.AreaService#getCountyByCityId(java.lang.String)
	 */
	@Override
	public List<Record> getCountyByCityId(String cityId) {
		
		List<Record> counties = examPropValMapper.getCountyByCityId(cityId);
		
		return counties;
		
	}

}
