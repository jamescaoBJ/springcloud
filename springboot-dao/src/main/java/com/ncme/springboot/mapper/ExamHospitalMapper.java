package com.ncme.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.ExamHospital;

public interface ExamHospitalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamHospital record);

    int insertSelective(ExamHospital record);

    ExamHospital selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamHospital record);

    int updateByPrimaryKey(ExamHospital record);

	/**
	 * getHospitalByArea:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param countyId
	 * @param  @param keyWord
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getHospitalByArea(@Param("regionId") String countyId,@Param("keyWord") String keyWord);
}