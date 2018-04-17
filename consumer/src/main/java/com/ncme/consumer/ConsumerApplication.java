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

package com.ncme.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;




/**
 * ClassName:Application
 * Function: TODO ribbon && feign 远程调用测试，ribbon:调用规范性不强，但是不用维护服务提供者太多的接口信息；feign：规范性强，但是需要维护接口信息。请酌情选择
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
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerApplication {
	
	public static void main(String[] args) {
		
        SpringApplication.run(ConsumerApplication.class, args);

		
	}
	
/*    @Bean   // feign 基本认证配置：暂时测试Spring http权限认证，由于此类认证算法可逆，安全性无法保证，所以暂时使用在eureka注册中心，其它的认证后续考虑替换成其它认证方式,
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
         return new BasicAuthRequestInterceptor("lyj","1989");
   }*/ 

	/**
	 * restTemplate:注册RestTemplate
	 * TODO 维护负载均衡
	 *
	 * @param  @return    
	 * @return RestTemplate    
	 * @throws 
	 * @since  　version 1.0
	*/
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new FastJsonHttpMessageConverter());
		
		return restTemplate;
	}
	
	
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1、需要先定义一个converter 转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
    

        // 3、在convert 中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 4、将convert 添加到converters当中
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
     }
	


}
