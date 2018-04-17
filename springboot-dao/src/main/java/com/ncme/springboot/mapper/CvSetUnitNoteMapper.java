package com.ncme.springboot.mapper;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.model.CvSetUnitNote;

public interface CvSetUnitNoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvSetUnitNote record);

    int insertSelective(CvSetUnitNote record);

    CvSetUnitNote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CvSetUnitNote record);

    int updateByPrimaryKey(CvSetUnitNote record);

	/**
	 * saveUnitNote:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param note
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	
		
	int saveUnitNote(@Param("note") CvSetUnitNote note);
}