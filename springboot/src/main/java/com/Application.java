package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;



/**
 * ClassName:Application
 * Function: TODO  springboot 启动类
 * Reason:	 TODO  boot 官方文档推荐配置
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年8月24日	上午11:56:16
 *
 * @see 	 
 *  
 */

@SpringBootApplication


//@其他需要注册的服务：监控器，总线，路由器等
@EnableScheduling
@EnableCaching
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
    
    /**
     * fastJsonHttpMessageConverters: jackson ——> fastjson
     * TODO fastjson比较方便，所以使用它
     *
     * @param  @return    
     * @return HttpMessageConverters    
     * @throws 
     * @since  　version 1.0
    */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1、需要先定义一个converter 转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteDateUseDateFormat);

        // 3、在convert 中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 4、将convert 添加到converters当中
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
     }
    
}