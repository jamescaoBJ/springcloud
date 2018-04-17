/**
 * MapWrapperFactory.java
 * com.ncme.springboot.configuration.mybatis
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月7日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.configuration.mybatis;

import java.util.Map;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

/**
 * ClassName:MapWrapperFactory
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月7日	下午1:03:51
 *
 * @see 	 
 *  
 */

public class MapWrapperFactory implements ObjectWrapperFactory{


	@Override
	public boolean hasWrapperFor(Object object) {
		
		return object != null && object instanceof Map;
		
	}

	@SuppressWarnings("all")
	@Override
	public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
		
		return new LYJMapWrapper(metaObject, (Map) object);
		
	}

}
