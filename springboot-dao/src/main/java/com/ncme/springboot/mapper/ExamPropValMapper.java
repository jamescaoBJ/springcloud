package com.ncme.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.ExamPropVal;

public interface ExamPropValMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamPropVal record);

    int insertSelective(ExamPropVal record);

    ExamPropVal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamPropVal record);

    int updateByPrimaryKey(ExamPropVal record);
    
    /**
     * getExamPropValByCvSetId:
     * 根据项目id查询学科
     * @param  @param cvSetId
     * @param  @return    
     * @return ExamPropVal    
     * @throws 
     * @since  　version 1.0
    */
    List<ExamPropVal> getExamPropValByCvSetId(Integer cvSetId);

	/**
	 * getProvince:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param provinceId
	 * @param  @param provinceName
	 * @param  @return    
	 * @return List<ExamPropVal>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getProvince(@Param("provinceId") String provinceId, @Param("provinceName") String provinceName);

	/**
	 * getCityByProvinceId:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param provinceId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getCityByProvinceId(@Param("provinceId") String provinceId);

	/**
	 * getCountyByCityId:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param cityId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getCountyByCityId(String cityId);
	
	/**
	 * getSubjectByIdAndName:
	 * 根据prop_id和name查询学科
	 * @param  @param record
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> getSubjectByIdAndName(@Param("propId")Integer propId, @Param("name")String name, @Param("extType")Integer extType);

	/**
	 * getPostType:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getPostType(@Param("id") Integer id);

	/**
	 * getPost:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getPost(@Param("id") String id);

	/**
	 * getSubject:获取一级学科
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id ： 学科id
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	Record getSubject(@Param("id") String id);
	
	/**
	 * getSubjectByUserId:
	 * 根据用户id查询用户学科
	 * @param  @param userId
	 * @param  @return    
	 * @return ExamPropVal    
	 * @throws 
	 * @since  　version 1.0
	*/
	ExamPropVal getSubjectByUserId(@Param("userId")Integer userId);
	
	/**
	 * getSubjectByPostType:
	 * 根据职务类型获取一级学科
	 * @param  @param postType
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<Record> getSubjectByPostType(Integer postType);
	
	/**
	 * 
	 * getSubjectById:
	 * 根据父学科查询子学科,即根据一级学科ID查询其二级学科、根据二级学科ID查询其三级学科
	 *
	 * @param  @param parentId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getSubjectById(@Param("parentId") String parentId);
	
	/**
	 * 
	 * getSubjectBySubId:
	 * 根据子学科查询其父学科,即根据三级学科ID查询其二级学科、根据二级学科ID查询其一级学科
	 *
	 * @param  @param userId
	 * @param  @return    
	 * @return ExamPropVal    
	 * @throws 
	 * @since  　version 1.0
	 */
	ExamPropVal getSubjectBySubId(@Param("proId")Integer proId);
	
}