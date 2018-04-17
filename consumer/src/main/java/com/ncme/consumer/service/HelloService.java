package com.ncme.consumer.service;
///**
// * HelloService.java
// * com.ncme.ribbon.one.service
// * Function： TODO add descript
// *
// *   ver     date      		author
// * ──────────────────────────────────
// *   		 2017年9月13日       lyj
// *
// * Copyright (c) 2017, TNT All Rights Reserved.
//*/
//
//package com.ncme.ribbon.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//
///**
// * ClassName:HelloService
// * Function: TODO ADD FUNCTION
// * Reason:	 TODO ADD REASON
// *
// * @author   lyj
// * @version  
// * @since    version 1.0
// * @Date	 2017年9月13日	下午2:52:03
// *
// * @see 	 
// *  
// */
//
//@Service
//public class HelloService {
////
////    @Autowired
////    RestTemplate restTemplate;
////
////    @HystrixCommand(fallbackMethod = "serviceError")
////    public String hello() {
////        return restTemplate.getForObject("http://springboot-eureka-server/hello",String.class);
////    }
////
////    public String serviceError() {
////        return "微服务不可用，为避免错误，启动断路器模式，你好，服务不可用，请稍后再试！";
////    }
//}
