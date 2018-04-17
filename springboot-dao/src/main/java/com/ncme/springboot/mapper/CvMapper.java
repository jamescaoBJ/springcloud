package com.ncme.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.Cv;

public interface CvMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cv record);

    int insertSelective(Cv record);

    Cv selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cv record);

    int updateByPrimaryKey(Cv record);

	/**
	 * mySelectCvByCvsetId:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param userId 
	 *
	 * @param  @param projectId
	 * @param  @return    
	 * @return List<Cv>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Cv> mySelectCvByCvsetId(@Param("projectId")String projectId, @Param("userId") Integer userId);
	
	/**
	 * 
	 * getCaseCvList:(这里用一句话描述这个方法的作用)
	 * TODO(获取典型病例列表-同时根据type可获取VR/三维动画/名师课程)
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getCaseCvList(Map<String,Object> map);
	
	/**
	 * 
	 * studyCvCount:(这里用一句话描述这个方法的作用)
	 * TODO(统计此课程学习人数)
	 *
	 * @param  @param userId
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	 */
	int studyCvCount(@Param("userId")Integer userId, @Param("cvId")Integer cvSetId);
	
	/**
	 * 
	 * getCvDetailById:(这里用一句话描述这个方法的作用)
	 * TODO(获取典型病例详情 –同时根据type可获取VR/三维动画/名师课程)
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getCvDetailById(Map<String,Object> map);
	
	/**
	 * 
	 * getCvCatalogById:(这里用一句话描述这个方法的作用)
	 * TODO(获取典型病例目录 – 同时根据type可获取VR/三维动画/名师课程)
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getCvCatalogById(Map<String,Object> map);
	
	/**
	 * 
	 * getCvIdByUnitId:(获取课程ID)
	 * TODO(根据单元ID获取到 该单元 所在的课程ID)
	 *
	 * @param  @param unitId
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	 */
	String getCvIdByUnitId(String unitId);
	
	/**
	 * 
	 * getCvSetIdByCvId:(获取项目ID)
	 * TODO(再根据 课程ID 获取 其课程 所在的 项目ID)
	 *
	 * @param  @param cvId
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	 */
	String  getCvSetIdByCvId(String cvId);
	
	/**
	 * getCvCountByCvSetId:
	 * 根据项目id查询该项目的所有课程数量
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return Integer    
	 * @throws 
	 * @since  　version 1.0
	*/
	Integer getCvCountByCvSetId(Integer cvSetId);
	
	/**
	 * getCompleteCvCountByUIdAndCvSetId:
	 * 项目下已完成的课程数量
	 * @param  @param userId
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return Integer    
	 * @throws 
	 * @since  　version 1.0
	*/
	Integer getCompleteCvCountByUIdAndCvSetId(@Param("userId")Integer userId, @Param("cvSetId")Integer cvSetId);
	
	/**
	 * getCvStudyStatue:
	 * 判断该课程学习状态 0:未学习    1:学习中   2:已完成
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	 */
	String getCvStudyStatue(Map<String,Object> map);
	
	/**
	 * 
	 * getCvStudyingCvUnitId:
	 * 返回该课程当前学习的单元ID(cvUnitId)
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getCvStudyingCvUnitId(Map<String,Object> map);
	
	/**
	 * 
	 * getXueKeList:
	 * 根据儿科学二级学科ID 获取其三级学科ID
	 *
	 * @param  @param xueke
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getXueKeList(@Param("xueke")Integer xueke);
	
	/**
	 * 
	 * getMyFavIsFavById:
	 * 判断该(0 项目 1课程 2直播课程)是否被收藏过
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	 */
	int getMyFavIsFavById(Map<String,Object> map);
}