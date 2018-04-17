package com.ncme.springboot.mapper;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.model.PeixunOrg;

public interface PeixunOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PeixunOrg record);

    int insertSelective(PeixunOrg record);

    PeixunOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PeixunOrg record);

    int updateByPrimaryKey(PeixunOrg record);

	/**
	 * @author 王印涛
	 * 2018年1月11日 下午6:30:16
	 * @Description: 根据项目ID获取项目所属机构
	 * @param cvSetId
	 * @return PeixunOrg
	 */
	PeixunOrg getOrg(@Param("cvSetId")Integer cvSetId);
}
