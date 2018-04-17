/**
 * CvSetUnitDiscussServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月20日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.mapper.CvSetUnitDiscussMapper;
import com.ncme.springboot.mapper.CvSetUnitNoteMapper;
import com.ncme.springboot.model.CvSetUnitDiscuss;
import com.ncme.springboot.model.CvSetUnitNote;
import com.wjw.service.CvSetUnitDiscussService;

/**
 * ClassName:CvSetUnitDiscussServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月20日	下午1:01:51
 *
 * @see 	 
 *  
 */
@Service
public class CvSetUnitDiscussServiceImpl implements CvSetUnitDiscussService {

	/**
	 * cvSetUnitDiscussMapper:TODO 优质慕课讨论mapper
	 *
	 * @since version 1.0
	 */
	@Autowired
	CvSetUnitDiscussMapper cvSetUnitDiscussMapper;
	@Autowired
	CvSetUnitNoteMapper cvSetUnitNoteMapper;
	
	
	/**
	 * 优质慕课保存
	 */
	@Transactional
	@Override
	public int saveUnitDiscuss(CvSetUnitDiscuss cuc) {
		
		// TODO Auto-generated method stub
		return cvSetUnitDiscussMapper.insert(cuc);
		
	}


	/**
	 * 优质慕课笔记保存
	 */
	@Override
	public int saveUnitNote(CvSetUnitNote note) {
		
		// TODO Auto-generated method stub
		return cvSetUnitNoteMapper.saveUnitNote(note);
		
	}

}
