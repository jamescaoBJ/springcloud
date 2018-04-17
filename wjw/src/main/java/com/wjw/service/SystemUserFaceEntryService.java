/**
 * 2018年1月10日 上午11:59:09
 * @author 王印涛
 * SystemUserFaceEntryService.java
 */
package com.wjw.service;

import java.util.Map;

import com.ncme.springboot.footstone.response.Record;

/**
 * @author 王印涛
 * SystemUserFaceEntryService.java
 * 2018年1月10日 上午11:59:09
 */
public interface SystemUserFaceEntryService {

	/**
	 * @author 王印涛
	 * 2018年1月10日 下午12:01:44
	 * @Description: 获取面授报名信息
	 * @param userId 用户ID
	 * @param cvSetId 项目ID
	 * @param fid 期数ID
	 * @return com.ncm e.springboot.model.SystemUserFaceEntry
	 */
	Record getFaceInfo(Map<String,Object> map);

	/**
	 * @author 王印涛
	 * 2018年1月11日 上午11:06:18
	 * @Description:面授报名
	 * @param valueOf
	 * @param valueOf2
	 * @param valueOf3
	 * @return Record
	 */
	void signUp(Integer userId, Integer cvSetId, Integer fid);

	/**
	 * @author 王印涛
	 * 2018年1月11日 下午1:09:53
	 * @Description: 是否报名
	 * @param map
	 * @return int
	 */
	Map<String, Object> isSignUp(Map<String, Object> map);
	/**
	 * 
	 * @author 王印涛
	 * 2018年1月11日 下午2:43:01
	 * @Description: 专项能力根据期数查询信息
	 * @param map
	 * @return Record
	 */
	Record getFaceTeachById (Map<String, Object> map);
	/**
	 * 
	 * @author 王印涛
	 * 2018年1月11日 下午4:35:01
	 * @Description: 专项能力面授项目详情
	 * @param userId
	 * @param cvSetId
	 * @return Record
	 */
	Record getFaceProDetailById(Integer userId,Integer cvSetId);

}
