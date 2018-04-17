package com.ncme.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;

public interface SpecialMapper {
    
	/**
	 * 
	 * getSearchResultList:
	 * 专项能力列表
	 *
	 * @param  @param keyWord
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getSpecialTrainList(@Param("keyword")String keyword, @Param("state")String state);
	
	/**
	 * 
	 * getSpecialDetail:
	 * 根据专项ID,获取专项详情
	 *
	 * @param  @param zxSetId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getSpecialDetail(@Param("zxSetId")Integer zxSetId);
	
	/**
	 * 
	 * getSubjectNameById:
	 * 根据学科ID查询学科名称
	 *
	 * @param  @param subjectId
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	 */
	String getSubjectNameById(@Param("subjectId")String subjectId);
	
	/**
	 * 
	 * getExpertInfoById:
	 * 根据专家ID查询专家信息
	 *
	 * @param  @param expertId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getExpertInfoById(@Param("expertId")String expertId);
	
	/**
	 * 
	 * getPhase1NcmeProjectById:
	 * 根据专项项目阶段(1或2或3)包含的NCME项目ID查询项目信息
	 *
	 * @param  @param phaseNcmeProjectId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getPhase1NcmeProjectById(@Param("phaseNcmeProjectId")String phaseNcmeProjectId);
	
	/**
	 * 
	 * getLearnNumByProjectId:
	 * 根据面授项目ID 或 临床实践项目ID,统计报名次数
	 *
	 * @param  @param projectId
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	 */
	int getLearnNumByProjectId(@Param("projectId")Integer projectId);
	
}