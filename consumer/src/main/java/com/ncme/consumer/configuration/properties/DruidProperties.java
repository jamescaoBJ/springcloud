/**
 * DruidProperty.java
 * com.ncme.ribbon.configuration.properties
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年8月24日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.consumer.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName:DruidProperty
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年8月24日	下午3:47:35
 *
 * @see 	 
 *  
 */
@Component
@ConfigurationProperties(prefix="datasource")
public class DruidProperties {
	
	private String driver;
	private String url;
	private String username;
	private String password;
	private String maxActive;
	private String initialSize;
	
	private String minIdle;
	private String testWhileIdle;
	private String timeBetweenEvictionRunsMillis;
	private String minEvictableIdleTimeMillis;
	private String validationQuery;

	


	/**
	 * driver
	 *
	 * @return  the driver
	 * @since    Ver 1.0
	*/
	
	public String getDriver() {
		return driver;
	}
	/**
	 * driver
	 *
	 * driver    the driver to set
	 * @since    Ver 1.0
	 */
	
	public void setDriver(String driver) {
		this.driver = driver;
	}
	/**
	 * url
	 *
	 * @return  the url
	 * @since    Ver 1.0
	*/
	
	public String getUrl() {
		return url;
	}
	/**
	 * url
	 *
	 * url    the url to set
	 * @since    Ver 1.0
	 */
	
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * username
	 *
	 * @return  the username
	 * @since    Ver 1.0
	*/
	
	public String getUsername() {
		return username;
	}
	/**
	 * username
	 *
	 * username    the username to set
	 * @since    Ver 1.0
	 */
	
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * password
	 *
	 * @return  the password
	 * @since    Ver 1.0
	*/
	
	public String getPassword() {
		return password;
	}
	/**
	 * password
	 *
	 * password    the password to set
	 * @since    Ver 1.0
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * maxActive
	 *
	 * @return  the maxActive
	 * @since    Ver 1.0
	*/
	
	public String getMaxActive() {
		return maxActive;
	}
	/**
	 * maxActive
	 *
	 * maxActive    the maxActive to set
	 * @since    Ver 1.0
	 */
	
	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}
	/**
	 * initialSize
	 *
	 * @return  the initialSize
	 * @since    Ver 1.0
	*/
	
	public String getInitialSize() {
		return initialSize;
	}
	/**
	 * initialSize
	 *
	 * initialSize    the initialSize to set
	 * @since    Ver 1.0
	 */
	
	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}
	/**
	 * minIdle
	 *
	 * @return  the minIdle
	 * @since    Ver 1.0
	*/
	
	public String getMinIdle() {
		return minIdle;
	}
	/**
	 * minIdle
	 *
	 * minIdle    the minIdle to set
	 * @since    Ver 1.0
	 */
	
	public void setMinIdle(String minIdle) {
		this.minIdle = minIdle;
	}
	/**
	 * testWhileIdle
	 *
	 * @return  the testWhileIdle
	 * @since    Ver 1.0
	*/
	
	public String getTestWhileIdle() {
		return testWhileIdle;
	}
	/**
	 * testWhileIdle
	 *
	 * testWhileIdle    the testWhileIdle to set
	 * @since    Ver 1.0
	 */
	
	public void setTestWhileIdle(String testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}
	/**
	 * timeBetweenEvictionRunsMillis
	 *
	 * @return  the timeBetweenEvictionRunsMillis
	 * @since    Ver 1.0
	*/
	
	public String getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}
	/**
	 * timeBetweenEvictionRunsMillis
	 *
	 * timeBetweenEvictionRunsMillis    the timeBetweenEvictionRunsMillis to set
	 * @since    Ver 1.0
	 */
	
	public void setTimeBetweenEvictionRunsMillis(String timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}
	/**
	 * minEvictableIdleTimeMillis
	 *
	 * @return  the minEvictableIdleTimeMillis
	 * @since    Ver 1.0
	*/
	
	public String getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}
	/**
	 * minEvictableIdleTimeMillis
	 *
	 * minEvictableIdleTimeMillis    the minEvictableIdleTimeMillis to set
	 * @since    Ver 1.0
	 */
	
	public void setMinEvictableIdleTimeMillis(String minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}
	/**
	 * validationQuery
	 *
	 * @return  the validationQuery
	 * @since    Ver 1.0
	*/
	
	public String getValidationQuery() {
		return validationQuery;
	}
	/**
	 * validationQuery
	 *
	 * validationQuery    the validationQuery to set
	 * @since    Ver 1.0
	 */
	
	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
	
	
	


}
