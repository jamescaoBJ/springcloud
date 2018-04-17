/**
 * DruidConfiguration.java
 * com.ncme.springboot.configuration
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年8月24日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.configuration;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.ncme.springboot.configuration.mybatis.MapWrapperFactory;
import com.ncme.springboot.configuration.properties.DruidProperties;

/**
 * ClassName:DruidConfiguration
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年8月24日	下午1:53:22
 *
 * @see 	 
 *  
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.ncme.springboot.**.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class MasterConfiguration {
	
	   @Autowired 
	    private DruidProperties druidProperties; 	
	
	
    /**
     * 配置DataSource
     * @return
     * @throws SQLException
     */
    @Bean(name = "dataSource")
    public DataSource druidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(druidProperties.getUsername());
        druidDataSource.setPassword(druidProperties.getPassword());
        druidDataSource.setUrl(druidProperties.getUrl());
        druidDataSource.setMaxActive(Integer.valueOf(druidProperties.getMaxActive()));
        druidDataSource.setFilters("stat,wall");
        druidDataSource.setInitialSize(Integer.valueOf(druidProperties.getInitialSize()));
        druidDataSource.setMinIdle(Integer.valueOf(druidProperties.getMinIdle()));
        druidDataSource.setTestWhileIdle(Boolean.valueOf(druidProperties.getTestWhileIdle()));
        
        druidDataSource.setMinEvictableIdleTimeMillis(Long.valueOf(druidProperties.getMinEvictableIdleTimeMillis()));
        
        druidDataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(druidDataSource.getTimeBetweenEvictionRunsMillis()));
        
        druidDataSource.setValidationQuery(druidProperties.getValidationQuery());
        druidDataSource.setTestOnBorrow(Boolean.valueOf(druidProperties.getTestOnBorrow()));
        druidDataSource.setTestOnReturn(Boolean.valueOf(druidProperties.getTestOnReturn()));
        druidDataSource.setDefaultAutoCommit(true);
        return druidDataSource;
    }
    
    
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(druidDataSource());
    }
 
    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapping/*.xml"));
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        sessionFactory.getObject().getConfiguration().setObjectWrapperFactory(myMapWrapperFactory());
        @SuppressWarnings(value = { "all" })
        PageHelper pageHelper = new PageHelper();
        

        return sessionFactory.getObject();
    }
    
    
    @Bean
    
    public MapWrapperFactory  myMapWrapperFactory(){
    	
    	return new MapWrapperFactory();
    	
    }
    
/*	
    *//**
     * 注册DruidServlet
     *
     * @return
     *//*
    @Bean
    public ServletRegistrationBean druidServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        
        servletRegistrationBean.setServlet(new StatViewServlet());
        
        servletRegistrationBean.addUrlMappings("/druid/*");
        
        Map<String,String> map = new HashMap<String,String>();
        map.put("loginUsername", "lyj");
        map.put("loginPassword", "1989");
        servletRegistrationBean.setInitParameters(map);
        
        return servletRegistrationBean;
    }

    *//**
     * 注册DruidFilter拦截
     *
     * @return
     *//*
    @Bean
    public FilterRegistrationBean duridFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<String, String>();
        //设置忽略请求
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.setInitParameters(initParams);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }*/
    
    
    
    
    //**********************************pagehelper********************************//
    
    
    
    @Bean  
    public PageHelper pageHelper() {  
    	
        PageHelper pageHelper = new PageHelper();  
        Properties p = new Properties();  
        p.setProperty("offsetAsPageNum", "true");  
        p.setProperty("rowBoundsWithCount", "true");  
        p.setProperty("reasonable", "true");  
        pageHelper.setProperties(p);  
        return pageHelper;  
    }  	

}
