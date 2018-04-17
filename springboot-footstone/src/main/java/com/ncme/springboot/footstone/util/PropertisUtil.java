package com.ncme.springboot.footstone.util;

import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertisUtil {
	private static Logger log = Logger.getLogger(PropertisUtil.class);
	private static Properties agencyProperties;
	private PropertisUtil(){
	}
	static{
		try {
			FileReadUtil fileReadUtil=new FileReadUtil();
			//获取DTS配置信息
			agencyProperties=fileReadUtil.getProperties("angency.properties");
		} catch (Exception e) {
			log.error("读取配置文件错误",e);
		}
		
	}
	public static Properties getAgencyProperties() {
		return agencyProperties;
	}
}
