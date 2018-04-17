/**
 * Page.java
 * com.ncme.springboot.footstone.request
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月20日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.footstone.request;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * ClassName:Page
 * Function: TODO page class
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月20日	上午10:59:45
 *
 * @see 	 
 *  
 */

public class Page {
	
	@NotNull(message="pageNum 不能为空！")
	@Min(value = 1,message="页码不能为0")
	private Integer pageNum; //页码
	@NotNull(message="pageSize 不能为空！")
	@Min(value = 1,message="页容量不能为0")
	private Integer pageSize; //页容量
	

	
	
	/**
	 * pageNum
	 *
	 * @return  the pageNum
	 * @since    Ver 1.0
	*/
	
	public Integer getPageNum() {
		return pageNum;
	}
	/**
	 * pageNum
	 *
	 * @param   pageNum    the pageNum to set
	 * @since    Ver 1.0
	 */
	
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	/**
	 * pageSize
	 *
	 * @return  the pageSize
	 * @since    Ver 1.0
	*/
	
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * pageSize
	 *
	 * @param   pageSize    the pageSize to set
	 * @since    Ver 1.0
	 */
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

	
	

}
