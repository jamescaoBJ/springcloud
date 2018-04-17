/**
 * RtnBody.java
 * com.ncme.springboot.footstone.response
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年9月21日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.footstone.response;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicStampedReference;

import com.alibaba.fastjson.JSONObject;
import com.ncme.springboot.footstone.constant.Constant;
import com.ncme.springboot.footstone.util.PK;

/**
 * ClassName:RtnBody
 * Function: TODO 返回结果统一工具类
 * Reason:	 TODO 采用方法链式调用方式，可以连续调用类中的提供的方法;格式:{code:"1","message":"msg","data":{}}
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年9月21日	下午3:50:58
 *
 * @see 	 
 *  
 */
@SuppressWarnings("all")
public  class RtnBody extends JSONObject{
	
	
	/**
	 * me:可以避免直接new 对象，可选方案之一
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	public  static RtnBody me(){
		
		return new RtnBody();
	}
	

	
	
	
	/**
	 * code:返回结果码，可在constant常量嘞定义，也可自己写入任何自定义的码
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param code
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 * 
	*/
	public  RtnBody code(Integer code){
		
		this.put(Constant.S_REPONSE_CODE, code) ;
		return this;
		
		
	}
	
	
	/**
	 * message:返回结果消息
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param message
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	public RtnBody message(String message){
		
		this.put(Constant.S_REPONSE_MESSAGE, message) ;
		return this;
		
	}
	
	
	
	
	/**
	 * kvData:简单键值对设置方式
	 * <pre>
	 * 
	 * new RtnBody().kvData("key","1989")
	 *</pre>
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param key
	 * @param  @param t
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	public <T> RtnBody kvData(String key , T t){
		
		
		this.put(key,t);
		return this;
		
		

	}
	
	
	
	/**
	 * data: 复杂对象设置方式
	 * <pre>
	 * 
	 * new RtnBody().data(object)
	 *</pre>
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param t
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 * @see

	*/
	public <T> RtnBody data( T t){
		
		
		this.put(Constant.S_REPONSE_DATA,t);
		
		return this;
		
		

	}
	
	
	
	// *********************************以下为非链式，主要编写获取各个要素和清空方法，其它更新之类的操作可根据后期需求添加，一般没必要写，可直接new 新的返回结果集*********************************************
	
	
	
	
	

	/**
	 * get:得到任意键的值
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param key
	 * @param  @param c
	 * @param  @return
	 * @param  @throws InstantiationException
	 * @param  @throws IllegalAccessException    
	 * @return T    
	 * @throws 
	 * @since  　version 1.0
	*/
	public  <T> T get(String key,Class<T> c) {
		
		T t;
		try {
			t = c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		t = (T) this.get(key);
		
		
	  return t;
		
	}
	
	
	
	/**
	 * getData:直接得到data
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return JSONObject    
	 * @throws 
	 * @since  　version 1.0
	*/
	public  <T> T getData(Class<T> c) {
		
		
	  return this.get(Constant.S_REPONSE_DATA, c);
		
	}
	
	/**
	 * getCode:得到code
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	*/
	public  String getCode(){
		
		return (String) this.get(Constant.S_REPONSE_CODE);
		
		
	}
	
	
	
	/**
	 * getMessage:得到message
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	*/
	public  String getMessage(){
		
		return (String) this.get(Constant.S_REPONSE_MESSAGE);
		
		
	}



	
	/**
	 * clear: 清除返回结果内容
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * 
	 * @see com.alibaba.fastjson.JSONObject#clear()
	 */
	public  void clear(){
		
		super.clear();
		
		
	}
	


	


}
