/**
 * PostServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月8日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.mapper.ExamPropValMapper;
import com.wjw.service.PostService;

/**
 * ClassName:PostServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月8日	下午4:28:45
 *
 * @see 	 
 *  
 */
@Service
public class PostServiceImpl implements PostService {

	/**
	 * examPropValMapper:TODO 属性表mapper
	 *
	 * @since version 1.0
	 */
	@Autowired
	ExamPropValMapper examPropValMapper;
	/**
	 * 职务类型
	 * @see com.wjw.service.PostService#getPostType(java.lang.Integer)
	 */
	@Override
	public List<Record> getPostType(Integer id) {//职务类型id
		
		// TODO Auto-generated method stub
		return examPropValMapper.getPostType(id);
		
	}

	/**
	 * 职务
	 * @see com.wjw.service.PostService#getPost(java.lang.String)
	 */
	@Override
	public List<Record> getPost(String id) {//职务类型id
		
		// TODO Auto-generated method stub
		return examPropValMapper.getPost(id);
		
	}

}
