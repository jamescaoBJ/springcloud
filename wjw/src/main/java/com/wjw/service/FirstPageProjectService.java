package com.wjw.service;

import java.util.List;
import java.util.Map;

import com.ncme.springboot.footstone.response.Record;

/**
 * 
 * ClassName:FirstPageProjectService
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月2日	下午3:42:11
 *
 * @see 	 
 *
 */

public interface FirstPageProjectService {

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
	
	
	
	
}
