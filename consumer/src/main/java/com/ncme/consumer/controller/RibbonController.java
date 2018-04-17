/**
 * RibbonController.java
 * com.ncme.ribbon.one.controller
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年9月13日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.consumer.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.RtnBody;

/**
 * ClassName:RibbonController
 * Function: TODO 所有的服务建议放到service层调用，demo示例中为了快速展示效果，放在本层即controller层调用
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年9月13日	下午12:46:41
 *
 * @see 	 
 *  
 */
@RestController
public class RibbonController extends Controller{
	
	@Autowired
	private RestTemplate restTemplate;
	

	
	/**
	 * consume:验证服务提供集群（非注册中心集群）
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/hello")
	public String helloString(String accountName){
		
		
		String cluster = restTemplate.getForObject("http://springboot/teacher/hello?accountName="+accountName, String.class);//测试String简单参数传递	，返回String	
	
		
		return cluster;
		
		
	}
	
	
	@RequestMapping("/restful")
	public String restful(String accountName ){
		log.info(accountName);
		
		String cluster = restTemplate.getForObject("http://springboot/teacher/restful/{accountName}", String.class,accountName); //restful 仅仅测试get，其它的情况比较多，时间有限，请自行测试	
		
		return cluster;
		
		
	}
	
	
//	@RequestMapping("/user")
//	public String user(String accountName ){
//		log.info(accountName);
//		
//		
//		   HttpHeaders headers = new HttpHeaders();
//	        headers.set("Content-Type", "application/json;charset=UTF-8");
//		SystemAccount user = new SystemAccount();
//		user.setAccountName(accountName);
//		
//		HttpEntity<SystemAccount> etity = new HttpEntity<>(user,headers);
//		String cluster = restTemplate.postForObject("http://springboot/teacher/user", etity,String.class); //restful 仅仅测试get，其它的情况比较多，时间有限，请自行测试	
//		
//		return cluster;
//		
//		
//	}//待测试，ribbon支持pojo，目前还不支持，只支持map
	
	@RequestMapping("/map")
	public String map(String accountName ) throws UnsupportedEncodingException{
		log.info(accountName);
		   HttpHeaders headers = new HttpHeaders();
		   
//		   String s = new String(org.apache.commons.codec.binary.Base64.encodeBase64("lyj:1989".getBytes()));
//		   headers.set("Authorization", "Basic "+s);  //ribbon spring http 基本认证测试 ok ，后续寻求其他替代方案，此类方案算法可逆，安全性不高
	        headers.set("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
	      
		
		
	       
		///
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		
		map.add("accountName", accountName);
		HttpEntity<MultiValueMap<String, String>> etity = new HttpEntity<>(map,headers);
		String cluster = restTemplate.postForObject("http://springboot/boot/teacher/map", etity,String.class); //restful 仅仅测试get，其它的情况比较多，时间有限，请自行测试
//		String cluster = restTemplate.postForObject("http://springboot/teacher/user", etity,String.class); //--可用，map——》转换为user对象对应字段 ok
		
		return new String (cluster.getBytes("ISO-8859-1"),"UTF-8");
		
		
	}

	@RequestMapping("/getRtnBody")
	public RtnBody getRtnBody(String accountName ) throws UnsupportedEncodingException{
		log.info(accountName);
		   HttpHeaders headers = new HttpHeaders();
	        headers.set("Content-Type", "application/json;charset=UTF-8");
	
		
		
		
	       
		///
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		
		map.add("accountName", accountName);
		HttpEntity<MultiValueMap<String, String>> etity = new HttpEntity<>(map,headers);
		ResponseEntity<RtnBody> RtnBody  = restTemplate.postForEntity("http://springboot/teacher/getRtnBody", etity,RtnBody.class); //restful 仅仅测试get，其它的情况比较多，时间有限，请自行测试
	/*	RtnBody rtnBody  = restTemplate.postForObject("http://springboot/teacher/getRtnBody", etity,RtnBody.class); //restful 仅仅测试get，其它的情况比较多，时间有限，请自行测试
		return rtnBody;*///--可用，返回object
//		String cluster = restTemplate.postForObject("http://springboot/teacher/user", etity,String.class); //--可用，map——》转换为user对象对应字段 ok
		
		return RtnBody.getBody();
		
		
	}

}
