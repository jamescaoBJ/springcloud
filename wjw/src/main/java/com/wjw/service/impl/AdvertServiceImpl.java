/**
 * AdvertServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月1日       juniorice
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.mapper.AdvertMapper;
import com.ncme.springboot.model.Advert;
import com.wjw.service.AdvertService;

/**
 * ClassName:AdvertServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xuehong
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月1日	下午2:25:11
 *
 * @see 	 
 *  
 */
@Service
public class AdvertServiceImpl implements AdvertService {
	@Autowired
	AdvertMapper advertMapper;
	
	
	/**
	 * (non-Javadoc)
	 * @see com.wjw.service.AdvertService#getBannerList()
	 */
	@Override
	public List<Advert> getBannerList() {
		return advertMapper.getBannerList();
	}
	

}
