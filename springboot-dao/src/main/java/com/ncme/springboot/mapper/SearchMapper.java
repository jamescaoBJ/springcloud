package com.ncme.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;

public interface SearchMapper {
    
	/**
	 * 
	 * getSearchResultList:(这里用一句话描述这个方法的作用)
	 * TODO(首页全局搜索)
	 *
	 * @param  @param keyWord
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	List<Record> getSearchResultList(@Param("keyWord")String keyWord,@Param("provinceId")Integer provinceId, @Param("domainName")String domainName);
	
	
	
}