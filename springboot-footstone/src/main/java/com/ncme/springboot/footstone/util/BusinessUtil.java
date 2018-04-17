package com.ncme.springboot.footstone.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class BusinessUtil {

	public static String getIpAddr(HttpServletRequest request) { 
	       String ip = request.getHeader("x-forwarded-for"); 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("WL-Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getRemoteAddr(); 
	       } 
	       return ip; 
	    }
	
	public static String readFile(String path){
		BufferedReader br = null;
		String resStr = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fileInputStream,"UTF-8");
			br = new BufferedReader(isr);
			String tempString = null;
			while((tempString = br.readLine()) != null){
				resStr += tempString.trim();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
		}
		return resStr;
	}
	
}
