package com.ncme.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.CvSet;

public interface CvSetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvSet record);

    int insertSelective(CvSet record);

    CvSet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvSet record);

    int updateByPrimaryKey(CvSet record);

	/**
	 * list:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return List<CvSet>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<CvSet> list();
	
	/**
	 * 根据名称和省份查询项目
	 *
	 * @param  @param cvSet
	 * @param  @return    
	 * @return List<CvSet>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> getCVSetPageListByNameAndProvice(@Param("cvSet")CvSet cvSet, @Param("provinceId")Integer provinceId, @Param("domainName")String domainName);
	
	/**
	 * getProjectDetailById:(这里用一句话描述这个方法的作用)
	 * 根据项目id查询项目详情
	 * @param  @param id
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	Record getProjectDetailById(@Param("id")Integer id, @Param("provinceId")Integer provinceId, @Param("domainName")String domainName);
	
	/**
	 * 
	 * getReCommendProjectList:(这里用一句话描述这个方法的作用)
	 * TODO(获取首页推荐项目)
	 *
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getReCommendProjectList(Map<String,Object> map);
	
	/**
	 * getRefereeBookByCvSetId:
	 * 根据项目id查询书籍推荐
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> getRefereeBookByCvSetId(Integer cvSetId);
	/**
	 * getKnowledgebaseByCvSetId:
	 * 根据项目id查询指南共识
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> getKnowledgebaseByCvSetId(Integer cvSetId);
	/**
	 * getReferencelatelyByCvSetId:
	 * 根据项目id查询最新文献
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> getReferencelatelyByCvSetId(Integer cvSetId);

	/**
	 * projectDiscuss:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param projectId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> projectDiscuss(@Param("projectId") Integer projectId);

	/**
	 * unitDiscuss:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param valueOf
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> unitDiscuss(@Param("projectId") Integer unitId);

	/**
	 * unitDiscuss:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param unitId
	 * @param  @param projectId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> unitDiscuss(@Param("unitId") String unitId, @Param("projectId") String projectId);

	/**
	 * projectNote:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> projectNote(@Param("userId") Integer userId, @Param("projectId") String projectId);

	/**
	 * unitNote:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @param unitId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> unitNote(@Param("userId") Integer userId, @Param("projectId") String projectId,@Param("unitId") String unitId);

	/**
	 * myStudy:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id
	 * @param  @param domainName
	 * @param  @param noApplyCredit
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> myStudy(@Param("userId") Integer id,@Param("domainName") String domainName,@Param("noApplyCredit") Integer noApplyCredit);

	/**
	 * myCredit:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param domainName 
	 *
	 * @param  @param id
	 * @param  @param applyCreditState
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> myCredit(@Param("userId") Integer id, @Param("domainName") String domainName, @Param("applyCreditState") Integer applyCreditState, @Param("provinceId")Integer provinceId);
	
	/**
	 * myStudyCvSet:
	 * 我的学习中项目列表
	 * @param  @param userId
	 * @param  @param isApplyCredit
	 * @param  @param provinceId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> myStudyCvSet(@Param("userId")Integer userId, @Param("isApplyCredit")Integer isApplyCredit, @Param("provinceId")Integer provinceId);
	
	CvSet getCvSetById(@Param("cvSetId")Integer cvSetId, @Param("provinceId")Integer provinceId, @Param("domainName")String domainName);
	
	 /**
     * annualProjectReport:
     * 年度项目学习报告
     * @param  @param userId
     * @param  @param year
     * @param  @return    
     * @return List<Record>    
     * @throws 
     * @since  　version 1.0
    */
    List<Record> annualProjectReport(@Param("userId")Integer userId, @Param("year")Integer year);
    
    /**
     * listPeixunOrg:
     * 来源
     * @param  @param cvSetId
     * @param  @return    
     * @return List<Record>    
     * @throws 
     * @since  　version 1.0
    */
    List<Record> listPeixunOrg(Integer cvSetId);
}