/**
 * Application.java
 * com.lyj.eureka.server
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年9月12日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.ncme.zuul.filter.ErrorFilter;
import com.ncme.zuul.filter.PreFilter;



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

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
	
	public static void main(String[] args) {
		
        SpringApplication.run(ZuulApplication.class, args);
        
		
	}

	@Bean
	public ErrorFilter getErrorFilter() {
		return new ErrorFilter();
	}

	/*@Bean
    public PreFilter getPreFilter(){
        return new PreFilter();
    }*/

}
