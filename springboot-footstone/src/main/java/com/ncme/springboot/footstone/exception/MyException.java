/**
 * MyException.java
 * com.ncme.springboot.footstone.exception
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年9月26日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.footstone.exception;

/**
 * ClassName:MyException
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年9月26日	上午10:02:44
 *
 * @see 	 
 *  
 */

public class MyException extends RuntimeException {
	
	
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since version 1.0
	 */
	
	private static final long serialVersionUID = 1L;


	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since version 1.0
	 */
	
	private Integer code;
	private String errMassege;


	public MyException(){
		
		super();
	}
	
	public MyException(String message){
		
		super("my exception * ：" + message);
	}

    public MyException(String message, Throwable cause) {
        super("my exception  ：" + message, cause);
    }
    
    
    public MyException(Throwable cause) {
        super(cause);
    }
    
    public MyException(Integer code ,String errMassege){
    	
    	super(code + ":" + errMassege);
    	this.code = code;
    	this.errMassege = errMassege;
    }

	/**
	 * code
	 *
	 * @return  the code
	 * @since    Ver 1.0
	*/
	
	public Integer getCode() {
		return code;
	}

	/**
	 * code
	 *
	 * @param   code    the code to set
	 * @since    Ver 1.0
	 */
	
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * errMassege
	 *
	 * @return  the errMassege
	 * @since    Ver 1.0
	*/
	
	public String getErrMassege() {
		return errMassege;
	}

	/**
	 * errMassege
	 *
	 * @param   errMassege    the errMassege to set
	 * @since    Ver 1.0
	 */
	
	public void setErrMassege(String errMassege) {
		this.errMassege = errMassege;
	}
    
    
    

}
