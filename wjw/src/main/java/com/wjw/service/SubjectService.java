package com.wjw.service;

import java.util.List;

import com.ncme.springboot.footstone.response.Record;

public interface SubjectService {

	/**
	 * getSubjectByIdAndName:
	 * 根据学科id和名称查询下一级学科
	 * @param  @param propId
	 * @param  @param name
	 * @param  @param extType
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> getSubjectByIdAndName(Integer propId, String name, Integer extType);

	/**
	 * getSubject:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	Record getSubject(String id);
	
	/**
	 * getSubjectByPostId:
	 * 根据职务类型获取一级学科
	 * @param  @param postId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> getSubjectByPostId(String postId);
	
	/**
	 * 
	 * getSubjectById:
	 * TODO(根据父学科查询子学科,即根据一级学科ID查询其二级学科、根据二级学科ID查询其三级学科)
	 *
	 * @param  @param postId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getSubjectById(String parentId);
	
}
