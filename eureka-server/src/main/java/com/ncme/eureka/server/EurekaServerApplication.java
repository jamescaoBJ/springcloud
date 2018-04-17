/**
 * Application.java
 * com.ncme.eureka.server
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年9月12日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;



/**
 * ClassName:Application
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年9月12日	下午12:33:18
 *
 * @see 	 
 *  
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
	
	public static void main(String[] args) {
		
        SpringApplication.run(EurekaServerApplication.class, args);
		
	}

}
