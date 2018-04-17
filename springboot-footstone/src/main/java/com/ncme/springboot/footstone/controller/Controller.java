package com.ncme.springboot.footstone.controller;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.alibaba.fastjson.JSONObject;
import com.ncme.springboot.footstone.request.LayaMap;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.StrKit;


/**
 * ClassName:Controller
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年9月30日	下午3:49:54
 *
 * @see 	 
 *  
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class Controller {
	
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	
	/**
	 * log:TODO 基石控制器定义log对象，子类可直接使用
	 *
	 * @since version 1.0
	 */
	public Logger log = LoggerFactory.getLogger(this.getClass());

	public String validate(BindingResult result){
		
		if(result.hasErrors()){
			
			 List<ObjectError>  list = result.getAllErrors();
			 return  list.get(0).getDefaultMessage();
	      
		}else{
			
			return null;
		}
	}
	/**
	 * Stores an attribute in this request
	 * @param name a String specifying the name of the attribute
	 * @param value the Object to be stored
	 */
	public Controller setAttr(String name, Object value) {
		request.setAttribute(name, value);
		return this;
	}
	
	/**
	 * Removes an attribute from this request
	 * @param name a String specifying the name of the attribute to remove
	 */
	public Controller removeAttr(String name) {
		request.removeAttribute(name);
		return this;
	}
	
	/**
	 * Stores attributes in this request, key of the map as attribute name and value of the map as attribute value
	 * @param attrMap key and value as attribute of the map to be stored
	 */
	public Controller setAttrs(Map<String, Object> attrMap) {
		for (Map.Entry<String, Object> entry : attrMap.entrySet())
			request.setAttribute(entry.getKey(), entry.getValue());
		return this;
	}
	
	/**
	 * Returns the value of a request parameter as a String, or null if the parameter does not exist.
	 * <p>
	 * You should only use this method when you are sure the parameter has only one value. If the 
	 * parameter might have more than one value, use getParaValues(java.lang.String). 
	 * <p>
	 * If you use this method with a multivalued parameter, the value returned is equal to the first 
	 * value in the array returned by getParameterValues.
	 * @param name a String specifying the name of the parameter
	 * @return a String representing the single value of the parameter
	 */
	public String getPara(String name) {
		return request.getParameter(name);
	}
	
	/**
	 * Returns the value of a request parameter as a String, or default value if the parameter does not exist.
	 * @param name a String specifying the name of the parameter
	 * @param defaultValue a String value be returned when the value of parameter is null
	 * @return a String representing the single value of the parameter
	 */
	public String getPara(String name, String defaultValue) {
		String result = request.getParameter(name);
		return result != null && !"".equals(result) ? result : defaultValue;
	}
	
	/**
	 * Returns the values of the request parameters as a Map.
	 * @return a Map contains all the parameters name and value
	 */
	public Map<String, String[]> getParaMap() {
		return request.getParameterMap();
	}
	
	public LayaMap laya(){
		
		LayaMap laya = new LayaMap();
		Map<String, String[]> map = getParaMap();
		
		for (Entry<String, String[]> entry : map.entrySet()) {  
			  
		    laya.put(entry.getKey(), entry.getValue()[0]);
		}  
		return laya;
	}
	
	public JSONObject getJsonPara(String name){
		JSONObject jo = JSONObject.parseObject(name);
		return jo;
	}
	
	/**
	 * Returns an Enumeration of String objects containing the names of the parameters
	 * contained in this request. If the request has no parameters, the method returns
	 * an empty Enumeration.
	 * @return an Enumeration of String objects, each String containing the name of 
	 * 			a request parameter; or an empty Enumeration if the request has no parameters
	 */
	public Enumeration<String> getParaNames() {
		return request.getParameterNames();
	}
	
	/**
	 * Returns an array of String objects containing all of the values the given request 
	 * parameter has, or null if the parameter does not exist. If the parameter has a 
	 * single value, the array has a length of 1.
	 * @param name a String containing the name of the parameter whose value is requested
	 * @return an array of String objects containing the parameter's values
	 */
	public String[] getParaValues(String name) {
		return request.getParameterValues(name);
	}
	
	/**
	 * Returns an array of Integer objects containing all of the values the given request 
	 * parameter has, or null if the parameter does not exist. If the parameter has a 
	 * single value, the array has a length of 1.
	 * @param name a String containing the name of the parameter whose value is requested
	 * @return an array of Integer objects containing the parameter's values
	 */
	public Integer[] getParaValuesToInt(String name) {
		String[] values = request.getParameterValues(name);
		if (values == null)
			return null;
		Integer[] result = new Integer[values.length];
		for (int i=0; i<result.length; i++)
			result[i] = Integer.parseInt(values[i]);
		return result;
	}
	
	public Long[] getParaValuesToLong(String name) {
		String[] values = request.getParameterValues(name);
		if (values == null)
			return null;
		Long[] result = new Long[values.length];
		for (int i=0; i<result.length; i++)
			result[i] = Long.parseLong(values[i]);
		return result;
	}
	
	/**
	 * Returns an Enumeration containing the names of the attributes available to this request.
	 * This method returns an empty Enumeration if the request has no attributes available to it. 
	 * @return an Enumeration of strings containing the names of the request's attributes
	 */
	public Enumeration<String> getAttrNames() {
		return request.getAttributeNames();
	}
	
	/**
	 * Returns the value of the named attribute as an Object, or null if no attribute of the given name exists.
	 * @param name a String specifying the name of the attribute
	 * @return an Object containing the value of the attribute, or null if the attribute does not exist
	 */
	public <T> T getAttr(String name) {
		return (T)request.getAttribute(name);
	}
	
	/**
	 * Returns the value of the named attribute as an Object, or null if no attribute of the given name exists.
	 * @param name a String specifying the name of the attribute
	 * @return an String Object containing the value of the attribute, or null if the attribute does not exist
	 */
	public String getAttrForStr(String name) {
		return (String)request.getAttribute(name);
	}
	
	/**
	 * Returns the value of the named attribute as an Object, or null if no attribute of the given name exists.
	 * @param name a String specifying the name of the attribute
	 * @return an Integer Object containing the value of the attribute, or null if the attribute does not exist
	 */
	public Integer getAttrForInt(String name) {
		return (Integer)request.getAttribute(name);
	}
	
	/**
	 * Returns the value of the specified request header as a String.
	 */
	public String getHeader(String name) {
		return request.getHeader(name);
	}
	
	private Integer toInt(String value, Integer defaultValue) {
			if (StrKit.isBlank(value))
				return defaultValue;
			value = value.trim();
			if (value.startsWith("N") || value.startsWith("n"))
				return -Integer.parseInt(value.substring(1));
			return Integer.parseInt(value);
	
	}
	
	/**
	 * Returns the value of a request parameter and convert to Integer.
	 * @param name a String specifying the name of the parameter
	 * @return a Integer representing the single value of the parameter
	 */
	public Integer getParaToInt(String name) {
		return toInt(request.getParameter(name), null);
	}
	
	/**
	 * Returns the value of a request parameter and convert to Integer with a default value if it is null.
	 * @param name a String specifying the name of the parameter
	 * @return a Integer representing the single value of the parameter
	 */
	public Integer getParaToInt(String name, Integer defaultValue) {
		return toInt(request.getParameter(name), defaultValue);
	}
	
	private Long toLong(String value, Long defaultValue) {
			if (StrKit.isBlank(value))
				return defaultValue;
			value = value.trim();
			if (value.startsWith("N") || value.startsWith("n"))
				return -Long.parseLong(value.substring(1));
			return Long.parseLong(value);

	}
	
	/**
	 * Returns the value of a request parameter and convert to Long.
	 * @param name a String specifying the name of the parameter
	 * @return a Integer representing the single value of the parameter
	 */
	public Long getParaToLong(String name) {
		return toLong(request.getParameter(name), null);
	}
	
	/**
	 * Returns the value of a request parameter and convert to Long with a default value if it is null.
	 * @param name a String specifying the name of the parameter
	 * @return a Integer representing the single value of the parameter
	 */
	public Long getParaToLong(String name, Long defaultValue) {
		return toLong(request.getParameter(name), defaultValue);
	}
	

	


	



	
	/**
	 * Return HttpServletRequest. Do not use HttpServletRequest Object in constructor of Controller
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	
	/**
	 * Return HttpServletResponse. Do not use HttpServletResponse Object in constructor of Controller
	 */
	public HttpServletResponse getResponse() {
		return response;
	}
	
	/**
	 * Return HttpSession.
	 */
	public HttpSession getSession() {
		return request.getSession();
	}
	
	/**
	 * Return HttpSession.
	 * @param create a boolean specifying create HttpSession if it not exists
	 */
	public HttpSession getSession(boolean create) {
		return request.getSession(create);
	}
	
	/**
	 * Return a Object from session.
	 * @param key a String specifying the key of the Object stored in session
	 */
	public <T> T getSessionAttr(String key) {
		HttpSession session = request.getSession(false);
		return session != null ? (T)session.getAttribute(key) : null;
	}
	
	/**
	 * Store Object to session.
	 * @param key a String specifying the key of the Object stored in session
	 * @param value a Object specifying the value stored in session
	 */
	public Controller setSessionAttr(String key, Object value) {
		request.getSession(true).setAttribute(key, value);
		return this;
	}
	
	/**
	 * Remove Object in session.
	 * @param key a String specifying the key of the Object stored in session
	 */
	public Controller removeSessionAttr(String key) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.removeAttribute(key);
		return this;
	}
	
	/**
	 * Get cookie value by cookie name.
	 */
	public String getCookie(String name, String defaultValue) {
		Cookie cookie = getCookieObject(name);
		return cookie != null ? cookie.getValue() : defaultValue;
	}
	
	/**
	 * Get cookie value by cookie name.
	 */
	public String getCookie(String name) {
		return getCookie(name, null);
	}
	
	/**
	 * Get cookie value by cookie name and convert to Integer.
	 */
	public Integer getCookieToInt(String name) {
		String result = getCookie(name);
		return result != null ? Integer.parseInt(result) : null;
	}
	
	/**
	 * Get cookie value by cookie name and convert to Integer.
	 */
	public Integer getCookieToInt(String name, Integer defaultValue) {
		String result = getCookie(name);
		return result != null ? Integer.parseInt(result) : defaultValue;
	}
	
	/**
	 * Get cookie value by cookie name and convert to Long.
	 */
	public Long getCookieToLong(String name) {
		String result = getCookie(name);
		return result != null ? Long.parseLong(result) : null;
	}
	
	/**
	 * Get cookie value by cookie name and convert to Long.
	 */
	public Long getCookieToLong(String name, Long defaultValue) {
		String result = getCookie(name);
		return result != null ? Long.parseLong(result) : defaultValue;
	}
	
	/**
	 * Get cookie object by cookie name.
	 */
	public Cookie getCookieObject(String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals(name))
					return cookie;
		return null;
	}
	
	/**
	 * Get all cookie objects.
	 */
	public Cookie[] getCookieObjects() {
		Cookie[] result = request.getCookies();
		return result != null ? result : new Cookie[0];
	}
	
	/**
	 * Set Cookie.
	 * @param name cookie name
	 * @param value cookie value
	 * @param maxAgeInSeconds -1: clear cookie when close browser. 0: clear cookie immediately.  n>0 : max age in n seconds.
	 * @param isHttpOnly true if this cookie is to be marked as HttpOnly, false otherwise
	 */
	public Controller setCookie(String name, String value, int maxAgeInSeconds, boolean isHttpOnly) {
		return doSetCookie(name, value, maxAgeInSeconds, null, null, isHttpOnly);
	}
	
	/**
	 * Set Cookie.
	 * @param name cookie name
	 * @param value cookie value
	 * @param maxAgeInSeconds -1: clear cookie when close browser. 0: clear cookie immediately.  n>0 : max age in n seconds.
	 */
	public Controller setCookie(String name, String value, int maxAgeInSeconds) {
		return doSetCookie(name, value, maxAgeInSeconds, null, null, null);
	}
	
	/**
	 * Set Cookie to response.
	 */
	public Controller setCookie(Cookie cookie) {
		response.addCookie(cookie);
		return this;
	}
	
	/**
	 * Set Cookie to response.
	 * @param name cookie name
	 * @param value cookie value
	 * @param maxAgeInSeconds -1: clear cookie when close browser. 0: clear cookie immediately.  n>0 : max age in n seconds.
	 * @param path see Cookie.setPath(String)
	 * @param isHttpOnly true if this cookie is to be marked as HttpOnly, false otherwise
	 */
	public Controller setCookie(String name, String value, int maxAgeInSeconds, String path, boolean isHttpOnly) {
		return doSetCookie(name, value, maxAgeInSeconds, path, null, isHttpOnly);
	}
	
	/**
	 * Set Cookie to response.
	 * @param name cookie name
	 * @param value cookie value
	 * @param maxAgeInSeconds -1: clear cookie when close browser. 0: clear cookie immediately.  n>0 : max age in n seconds.
	 * @param path see Cookie.setPath(String)
	 */
	public Controller setCookie(String name, String value, int maxAgeInSeconds, String path) {
		return doSetCookie(name, value, maxAgeInSeconds, path, null, null);
	}
	
	/**
	 * Set Cookie to response.
	 * @param name cookie name
	 * @param value cookie value
	 * @param maxAgeInSeconds -1: clear cookie when close browser. 0: clear cookie immediately.  n>0 : max age in n seconds.
	 * @param path see Cookie.setPath(String)
	 * @param domain the domain name within which this cookie is visible; form is according to RFC 2109
	 * @param isHttpOnly true if this cookie is to be marked as HttpOnly, false otherwise
	 */
	public Controller setCookie(String name, String value, int maxAgeInSeconds, String path, String domain, boolean isHttpOnly) {
		return doSetCookie(name, value, maxAgeInSeconds, path, domain, isHttpOnly);
	}
	
	/**
	 * Remove Cookie.
	 */
	public Controller removeCookie(String name) {
		return doSetCookie(name, null, 0, null, null, null);
	}
	
	/**
	 * Remove Cookie.
	 */
	public Controller removeCookie(String name, String path) {
		return doSetCookie(name, null, 0, path, null, null);
	}
	
	/**
	 * Remove Cookie.
	 */
	public Controller removeCookie(String name, String path, String domain) {
		return doSetCookie(name, null, 0, path, domain, null);
	}
	
	private Controller doSetCookie(String name, String value, int maxAgeInSeconds, String path, String domain, Boolean isHttpOnly) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAgeInSeconds);
		// set the default path value to "/"
		if (path == null) {
			path = "/";
		}
		cookie.setPath(path);
		
		if (domain != null) {
			cookie.setDomain(domain);
		}
		if (isHttpOnly != null) {
			cookie.setHttpOnly(isHttpOnly);
		}
		response.addCookie(cookie);
		return this;
	}
	
	// --------
	


	
	/**
	 * Keep all parameter's value except model value
	 */
	public Controller keepPara() {
		Map<String, String[]> map = request.getParameterMap();
		for (Entry<String, String[]> e: map.entrySet()) {
			String[] values = e.getValue();
			if (values.length == 1)
				request.setAttribute(e.getKey(), values[0]);
			else
				request.setAttribute(e.getKey(), values);
		}
		return this;
	}
	
	/**
	 * Keep parameter's value names pointed, model value can not be kept
	 */
	public Controller keepPara(String... names) {
		for (String name : names) {
			String[] values = request.getParameterValues(name);
			if (values != null) {
				if (values.length == 1)
					request.setAttribute(name, values[0]);
				else
					request.setAttribute(name, values);
			}
		}
		return this;
	}

	
	public Controller keepPara(Class type, String... names) {
		if (type == String.class)
			return keepPara(names);
		
		if (names != null)
			for (String name : names)
				keepPara(type, name);
		return this;
	}
	
	
	public RtnBody getRtnBody(){
		
		return new RtnBody();
		
	}

	

}


