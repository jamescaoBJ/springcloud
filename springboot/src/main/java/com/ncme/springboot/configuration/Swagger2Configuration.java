package com.ncme.springboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;
import com.ncme.springboot.configuration.properties.Swagger2Properties;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ClassName:Swagger2Configuration
 * Function: TODO swagger2 boot配置
 * Reason:	 TODO 配置swagger环境
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年8月25日	下午1:29:41
 *
 * @see 	 
 *  
 */
@EnableSwagger2
@Configuration
public class Swagger2Configuration {
	
	@Autowired
	Swagger2Properties swagger2Properties;
	
	@Value("${swagger2.enable}")
	
	boolean enable ;

    @SuppressWarnings("unchecked")
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.enable(swagger2Properties.isEnable())
                .apiInfo(apiInfo()).pathMapping("/")//required ：一般是项目路径
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.ncme.springboot.core.swagger"))
                .paths(Predicates.or(PathSelectors.regex("/api/.*")))//匹配符合规则的访问路径可以生成swagger接口文档
                .build();
    }
    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot & swagger2")
                //创建人
                .contact(new Contact("lyj", "https://my.oschina.net/lyj1989", "18703867846@163.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}