/**
 * 2018年1月10日 上午11:49:14
 * @author 王印涛
 * SystemUserFaceEntryMapper.java
 */
package com.ncme.springboot.mapper;

import java.util.Map;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.SystemUserFaceEntry;

/**
 * @author 王印涛
 * SystemUserFaceEntryMapper.java
 * 2018年1月10日 上午11:49:14
 */
public interface SystemUserFaceEntryMapper {

	int insert(SystemUserFaceEntry faceEntry);

	/**
	 * @author 王印涛
	 * 2018年1月10日 下午1:18:41
	 * @Description: 获取面授报名信息表
	 * @param userId
	 * @param cvSetId
	 * @param fid
	 * @return Record
	 */
	Record getFaceInfo(Map<String,Object> map);

	/**
	 * @author 王印涛
	 * 2018年1月11日 下午1:22:15
	 * @Description: 获取报名表
	 * @param map
	 * @return SystemUserFaceEntry
	 */
	SystemUserFaceEntry isSignUp(Map<String, Object> map);
	
}
