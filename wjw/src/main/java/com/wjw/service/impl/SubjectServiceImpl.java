package com.wjw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.mapper.ExamPropValMapper;
import com.ncme.springboot.model.ExamPropVal;
import com.wjw.service.SubjectService;

/**
 * ClassName:SubjectServiceImpl
 * Function: 学科service
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月6日	上午11:09:09
 *
 * @see 	 
 *  
 */
@Service
public class SubjectServiceImpl implements SubjectService {
	/**
	 * propValMapper:TODO 调用数据库属性相关表的功能
	 *
	 * @since version 1.0
	 */
	@Autowired
	ExamPropValMapper propValMapper;

	@Override
	public List<Record> getSubjectByIdAndName(Integer propId, String name, Integer extType) {
		return propValMapper.getSubjectByIdAndName(propId, name, extType);

	}

	/**
	 * 获取一级学科
	 * @see com.wjw.service.SubjectService#getSubject(java.lang.String)
	 */
	@Override
	public Record getSubject(String id) {
		
		// TODO Auto-generated method stub
		return propValMapper.getSubject(id);
		
	}

	/**
	 * 根据职位id 获取学科
	 * @see com.wjw.service.SubjectService#getSubjectByPostId(java.lang.String)
	 */
	@Override
	public List<Record> getSubjectByPostId(String postId) {
		ExamPropVal post = propValMapper.selectByPrimaryKey(Integer.valueOf(postId));
		List<Record> subjectList = propValMapper.getSubjectByPostType(Integer.valueOf(post.getCode()));
		return subjectList;
		
	}

	/**
	 * 根据父学科查询子学科,即根据一级学科ID查询其二级学科、根据二级学科ID查询其三级学科
	 * @see com.wjw.service.SubjectService#getSubjectById(java.lang.String)
	 */
	@Override
	public List<Record> getSubjectById(String parentId) {
		return propValMapper.getSubjectById(parentId);
	}

}
