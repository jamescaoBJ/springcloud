package com.wjw.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.Cv;
import com.ncme.springboot.model.CvSet;

public interface CvSetService {

	/**
	 * getCVSetPageListByNameAndProvice:
	 * 根据名称和省份查询已发布的项目
	 *
	 * @param  @param cvSet
	 * @param  @param pageCurrent
	 * @param  @param pageSize
	 * @param  @return    
	 * @return PageInfo<CvSet>    
	 * @throws 
	 * @since  　version 1.0
	*/
	PageInfo<Record> getCVSetPageListByNameAndProvice(CvSet cvSet, Integer provinceId, String pageCurrent, String pageSize, String domainName);
	
	/**
	 * getProjectDetailById:
	 * 根据项目id查询项目详情
	 * @param  @param id
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	Record getProjectDetailById(Integer id, Integer provinceId, String domainName);

	/**
	 * mySelectCvByCvsetId:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param integer 
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param projectId
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	PageInfo<Cv> mySelectCvByCvsetId(String pageNum, String pageSize, String projectId, Integer userId);

	/**
	 * projectDiscuss:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param unitId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	PageInfo<Record> projectDiscuss(String pageNum, String pageSize, Integer unitId);

	/**
	 * unitDiscuss:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param valueOf
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	

	/**
	 * unitDiscuss:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param unitId
	 * @param  @param projectId
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	PageInfo<Record> unitDiscuss(String pageNum, String pageSize, String unitId, String projectId);

	/**
	 * projectNote:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param projectId
	 * @param  @param id
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	PageInfo<Record> projectNote(String pageNum, String pageSize, String projectId, Integer id);

	/**
	 * unitNote:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param projectId
	 * @param  @param unitId
	 * @param  @param id
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	PageInfo<Record> unitNote(String pageNum, String pageSize, String projectId, String unitId, Integer id);
	
	/**
	 * getProjectStudyDetail:
	 * 查询项目学习详情
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	Record getProjectStudyDetail(Integer userId, Integer cvSetId, String cvUnitId, String domainName);

	/**
	 * myStudy:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param string2 
	 * @param string 
	 *
	 * @param  @param id
	 * @param  @param domainName
	 * @param  @param noApplyCredit
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	PageInfo<Record> myStudy(Integer id, String domainName, Integer noApplyCredit, String string, String string2);
	
	/**
	 * getCvSetById:
	 * 根据项目id查询项目详情(单表数据)
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return CvSet    
	 * @throws 
	 * @since  　version 1.0
	*/
	CvSet getCvSetById(Integer cvSetId, Integer provinceId, String domainName);

	/**
	 * myCredit:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id
	 * @param  @param domainName
	 * @param  @param applyCreditState
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	PageInfo<Record> myCredit(Integer id, String domainName, Integer applyCreditState,Integer provinceId, String pageNum, String pageSize);
	
	List<Record> myCreditNew(Integer id, String domainName, Integer applyCreditState,Integer provinceId);
	
	/**
	 * checkBindCost:
	 * 检测项目是否需要付费和绑定相关的卡号
	 * //card=1表示成功，不需要再绑卡了，0代表需要绑卡
	 * @param  @param userId
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	Record checkBindCost(Integer userId, Integer cvSetId, String domainName);
	
	/**
	 * myStudyNew:我的学习列表
	 *
	 * @param  @param userId
	 * @param  @param isApplyCredit
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> myStudyNew(Integer userId, Integer isApplyCredit, Integer provinceId);
	
	/**
	 * 
	 * getMyFavIsFavById:
	 * 获取该项目是否被收藏
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	 */
	int getMyFavIsFavById(Map<String, Object> map);
}
