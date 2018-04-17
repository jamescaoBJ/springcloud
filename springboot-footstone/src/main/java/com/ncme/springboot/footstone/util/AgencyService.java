package com.ncme.springboot.footstone.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncme.springboot.footstone.util.HttpClientUtil;
import com.ncme.springboot.footstone.util.PropertisUtil;
import com.ncme.springboot.footstone.util.StringUtil;

public class AgencyService {
	
	public String doPost(String projectName,String url, String type, String params) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		String urlPre="";
		//根据配置文件信息获取对应url
		Properties agencyProperties=PropertisUtil.getAgencyProperties();
		urlPre=agencyProperties.getProperty(projectName);
		if(StringUtil.isBlank(urlPre))
		throw new RuntimeException("没有找到对应url");
		String allUrl=urlPre+url;
		
		String resultStr="";//返回值
		//如果是postjson时
		if("postjson".equalsIgnoreCase(type)){
			resultStr=HttpClientUtil.doPostJson(allUrl, params);
		}else if("post".equalsIgnoreCase(type)){
		//如果是postForm方式
			Map map=new HashMap();;
			map = mapper.readValue(params, Map.class);
			resultStr=HttpClientUtil.doPost(allUrl, map);
		}
	  return resultStr;
	}
	
	
	/**
	 * get请求
	 * @param projectName
	 * @param request
	 * @return
	 */
	  public  String doGet(String projectName,HttpServletRequest request) {
			String url="";
			StringBuffer paramsSBtr=new StringBuffer();
			Map<String,String> map = new HashMap<String,String>(); 
			Enumeration paramNames = request.getParameterNames(); 
			while (paramNames.hasMoreElements()) { 
				String paramName = (String) paramNames.nextElement(); 
				String[] paramValues = request.getParameterValues(paramName); 
				if (paramValues.length == 1) { 
				    String paramValue = paramValues[0]; 
				    if (paramValue.length() != 0) {
				    	//如果为url了，则不添加参数
						if("url".equalsIgnoreCase(paramName)){
							url=paramValue;  
							continue;
						}
					    paramsSBtr.append(paramName+"="+paramValue+"&");
					    map.put(paramName, paramValue);
				    } 
				} 
			}
			  
			ObjectMapper mapper = new ObjectMapper();
			String urlPre="";
			//根据配置文件信息获取对应url
			Properties agencyProperties=PropertisUtil.getAgencyProperties();
			urlPre=agencyProperties.getProperty(projectName);
			if(StringUtil.isBlank(urlPre))
			throw new RuntimeException("没有找到对应url");
			String allUrl=urlPre+url;
			return HttpClientUtil.doGet(allUrl,map);			  
	    }
}
