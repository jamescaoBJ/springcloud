package com.ncme.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.ExpertInfo;

public interface ExpertInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpertInfo record);

    int insertSelective(ExpertInfo record);

    ExpertInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpertInfo record);

    int updateByPrimaryKey(ExpertInfo record);

	/**
	 * getTeachersByPage:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param expertInfo
	 * @param  @return    
	 * @return PageInfo<ExpertInfo>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<ExpertInfo> getTeachersByPage(ExpertInfo expertInfo);

	/**
	 * getTeachersByPageRecord:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param expertInfo
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getTeachersByPageRecord(ExpertInfo expertInfo);

	/**
	 * getExportById:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param personage 
	 *
	 * @param  @param id
	 * @param  @return    
	 * @return ExpertInfo    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	ExpertInfo getExportById(@Param("id") String id, @Param("personage") String personage);

	/**
	 * deleteExpertPropVal:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	int deleteExpertPropVal(Integer id);

	/**
	 * deleteExpertGroupVal:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	int deleteExpertGroupVal(Integer id);

	/**
	 * deleteCvRefTeacher:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	int deleteCvRefTeacher(Integer id);
	
	/**
	 * listExpertByCvSetId:
	 * 根据项目id查询项目负责人或者示教教师(type=1为项目负责人，type=2为示教老师)
	 * @param  @param cvSetId
	 * @param  @param type
	 * @param  @return    
	 * @return List<Record>  
	 * @since  　version 1.0
	*/
	List<Record> listExpertByCvSetId(@Param("cvSetId")Integer cvSetId, @Param("type")Integer type);
	
	/**
	 * listTeachersByCvSetId:
	 * 获取项目授课老师
	 * @param  @param cvSetId
	 * @param  @param type
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> listTeachersByCvSetId(@Param("cvSetId")Integer cvSetId, @Param("type")Integer type);
	  /**
     * 
     * getFamousTeacherList:
     * 获取名师列表
     *
     * @param  @param map
     * @param  @param pageCurrent
     * @param  @param pageSize
     * @param  @return    
     * @return PageInfo<ExpertInfo>    
     * @throws 
     * @since  　version 1.0
     */
	List<Record> getFamousTeacherList(Map<String,Object> map);
	
	/**
	 * 
	 * getProjectNumByExpertId:
	 * 获取专家负责的项目数量
	 *
	 * @param  @param expertId
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	 */
	int getProjectNumByExpertId(@Param("expertId") Integer expertId);
	
	/**
	 * 
	 * getFamousTeacherList:
	 * 获取专委会列表
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getCommitteeList(Map<String,Object> map);
	
	/**
	 * 
	 * getCommitteeDetail:
	 * 根据专委会ID,获取专委会详情
	 *
	 * @param  @param userId
	 * @param  @param specialId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getCommitteeDetail(Map<String,Object> map);
	
	/**
	 * 
	 * getViceSpecial:
	 * 根据专委会ID获取副主任委员信息
	 *
	 * @param  @param expertId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getViceSpecial(@Param("specialId") Integer specialId, @Param("type") Integer type);
	
	/**
	 * 
	 * getLearnGroup:
	 * 根据专委会ID获取学组信息
	 *
	 * @param  @param specialId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getLearnGroup(@Param("specialId") Integer specialId);
	
	/**
	 * 
	 * getLearnGroupMember:
	 * 根据学组ID,获取学组下的学员(包含学组长)信息
	 *
	 * @param  @param id
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getLearnGroupMember(@Param("id") Integer id);
}