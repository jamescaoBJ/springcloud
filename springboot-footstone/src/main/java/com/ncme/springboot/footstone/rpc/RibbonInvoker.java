package com.ncme.springboot.footstone.rpc;
///**
// * RibbonInvoker.java
// * com.ncme.springboot.footstone.rpc
// * Function： TODO add descript
// *
// *   ver     date      		author
// * ──────────────────────────────────
// *   		 2017年10月18日       lyj
// *
// * Copyright (c) 2017, TNT All Rights Reserved.
//*/
//
//package com.ncme.springboot.footstone.rpc;
//
//import org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration.RestTemplateConfiguration;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.cloud.netflix.metrics.RestTemplateUrlTemplateHolder;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import com.netflix.ribbon.RequestTemplate;
//
///**
// * ClassName:RibbonInvoker
// * Function: TODO ribbon 调用器
// * Reason:	 TODO 封装ribbon调用方式，精简调用方式
// *
// * @author   lyj
// * @version  
// * @since    version 1.0
// * @Date	 2017年10月18日	下午2:24:55
// *
// * @see 	 
// *  
// */
//
//public final class RibbonInvoker extends RestTemplateBuilder{
//	
//	
//	private static final String CONTENT_TYPE_PRE = "Content-Type";
//	
//	private static final String CHARSET_PRE = "charset";
//	
//
//	
//	
//	
//	public static void defaultHeader(){
//		
//		setHeader(ContentType.X_WWW_FORM_URLENCODED, charsets.UTF_8);
//	}
//	
//	public static void setHeader(ContentType contentType,charsets charsets){
//		
//		HttpHeaders headers = new HttpHeaders();
//		
//		headers.set(CONTENT_TYPE_PRE, contentType.getEncoded()+";"+CHARSET_PRE+"="+charsets.getCharset());
//		
//		
//	}
//	
//	public static void setRequestBody(ContentType contentType,charsets charsets){
//		
//		
//		
//		
//	}
//	
//	public static void restTemplate(){
//		
//		
//		RestTemplate restTemplate = new RibbonInvoker().build();
////		restTemplate.post
//		
//		
//		
//	}
//	
////	log.info(accountName);
////	   HttpHeaders headers = new HttpHeaders();
////     headers.set("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
////
////	
////	
////	
////    
////	///
////	
////	MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
////	
////	map.add("accountName", accountName);
////	HttpEntity<MultiValueMap<String, String>> etity = new HttpEntity<>(map,headers);
////	String cluster = restTemplate.postForObject("http://springboot/teacher/map", etity,String.class); //restful 仅仅测试get，其它的情况比较多，时间有限，请自行测试
//////	String cluster = restTemplate.postForObject("http://springboot/teacher/user", etity,String.class); //--可用，map——》转换为user对象对应字段 ok
////	
////	return new String (cluster.getBytes("ISO-8859-1"),"UTF-8");
//	
//	public enum charsets{
//		
//		UTF_8("UTF-8"),
//		ISO_8859_1("ISO-8859-1");
//		
//		private String charset;
//		charsets(String charset){
//			
//			this.charset = charset;
//		}
//		/**
//		 * charset
//		 *
//		 * @return  the charset
//		 * @since    Ver 1.0
//		*/
//		
//		public String getCharset() {
//			return charset;
//		}
//		/**
//		 * charset
//		 *
//		 * @param   charset    the charset to set
//		 * @since    Ver 1.0
//		 */
//		
//		public void setCharset(String charset) {
//			this.charset = charset;
//		}
//		
//		
//	}
//	public enum ContentType{
//		
//		//暂归纳七种编码格式
//		X_WWW_FORM_URLENCODED("x-www-form-urlencoded"),
//		APPLICATION_JSON("application/json"),
//		APPLICATION_XML("application/xml"),
//		TEXT_XML("text/xml"),
//		TEXT_HTML("text/html"),
//		TEXT_PLAIN("text/plain"),
//		MULTIPART_FORM_DATA("multipart/form-data");
//		
//		
//		
//		private String encoded;
//		
//		ContentType(String encoded){
//			
//			this.encoded = encoded;
//			
//			
//		}
//
//		/**
//		 * encoded
//		 *
//		 * @return  the encoded
//		 * @since    Ver 1.0
//		*/
//		
//		public String getEncoded() {
//			return encoded;
//		}
//
//		/**
//		 * encoded
//		 *
//		 * @param   encoded    the encoded to set
//		 * @since    Ver 1.0
//		 */
//		
//		public void setEncoded(String encoded) {
//			this.encoded = encoded;
//		}
//		
//	
//		
//		
//	}
//	
//	public static void main(String[] args) {
//		
//	}
//	
//
//}
