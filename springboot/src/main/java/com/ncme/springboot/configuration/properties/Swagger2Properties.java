/**
 * SwaggerProperties.java
 * com.ncme.springboot.configuration.properties
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年9月22日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName:SwaggerProperties
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年9月22日	下午1:51:39
 *
 * @see 	 
 *  
 */
@Component
@ConfigurationProperties(prefix="swagger2")
public class Swagger2Properties {
	
	/**
	 * enable:TODO 控制swagger是否可用，生产环境一般情况下需要关闭，测试环境可开启
	 *
	 * @since version 1.0
	 */
	public boolean enable;

	/**
	 * enable
	 *
	 * @return  the enable
	 * @since    Ver 1.0
	*/
	
	public boolean isEnable() {
		return enable;
	}

	/**
	 * enable
	 *
	 * @param   enable    the enable to set
	 * @since    Ver 1.0
	 */
	
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	
}
