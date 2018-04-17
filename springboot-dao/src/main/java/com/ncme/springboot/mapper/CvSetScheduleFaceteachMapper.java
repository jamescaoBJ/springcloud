package com.ncme.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;import com.ncme.springboot.model.CvSetScheduleFaceteach;

public interface CvSetScheduleFaceteachMapper {
    int insert(CvSetScheduleFaceteach record);

    int insertSelective(CvSetScheduleFaceteach record);
	/**
     * getFaceteachByUserIdAndCvSetId:
     * 根据用户id和项目id查询面授项目期数
     * @param  @param userId
     * @param  @param cvSetId
     * @param  @return    
     * @return List<CvSetScheduleFaceteach>    
     * @throws 
     * @since  　version 1.0
    */
    List<CvSetScheduleFaceteach> getFaceteachByUserIdAndCvSetId(@Param("userId")Integer userId, @Param("cvSetId")Integer cvSetId);

	Record getFaceTeachById(Map<String, Object> map);

	/**
	 * @author 王印涛
	 * 2018年1月11日 下午5:57:25
	 * @Description: 根据项目ID获取面授期数
	 * @param cvSetId
	 * @return List<CvSetScheduleFaceteach>
	 */
	List<Record> faceTeachList(@Param("cvSetId")Integer cvSetId);

}