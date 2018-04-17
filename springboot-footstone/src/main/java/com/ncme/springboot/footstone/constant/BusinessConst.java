/**
 * BusinessConst.java
 * com.ncme.springboot.footstone.constant
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月9日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.footstone.constant;

/**
 * ClassName:BusinessConst
 * Function: 定义返回码，返回信息常量类，编码最好统一规则
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月9日	下午4:16:15
 *
 * @see 	 
 *  
 */

public class BusinessConst {
	
	/**参数合法性检查，最好统一编码,三位数字，保证有百十个预留位置*/
	
	public static final Integer CODE_PARAM_EMPTY = 100;
	
	
			
	/******************************业务成功和失败返回码******************************/		
	
	/**
	 * CODE_RESPONSE_SUCCESS:TODO 业务返回成功码
	 *
	 * @since version 1.0
	 */
	public static final Integer CODE_RESPONSE_SUCCESS = 1;
			
	/**
	 * CODE_RESPONSE_FAIL:TODO 业务返回失败码
	 *
	 * @since version 1.0
	 */
	public static final Integer CODE_RESPONSE_FAIL = 0;
	
	/**
	 * STUDY_HAVE_LEARN: 学习记录表状态——已学完
	 *
	 * @since version 1.0
	 */
	public static final Integer STUDY_HAVE_LEARN =2;
	
	/**
	 * STUDY_NOT_LEARND: 学习记录表状态——未学完
	 *
	 * @since version 1.0
	 */
	public static final Integer STUDY_NOT_LEARND =1;
	
	/**
	 * SystemCard_TYPE_NULL:TODO空白卡类型
	 *
	 * @since version 1.0
	 */
	public static final Integer SystemCard_TYPE_NULL =21;	
	
	/**
	 * ACCOUNT_INVALID:TODO 账户无效
	 *
	 * @since version 1.0
	 */
	public static final Integer  ACCOUNT_INVALID = 301;
	/**
	 * PASSWORD_INVALID:TODO 密码无效
	 *
	 * @since version 1.0
	 */
	public static final Integer  PASSWORD_INVALID = 302;
	
	public static final Integer ACCOUNT_LOCK = 303;
	/**
	 * ACCOUNT_NOT_LOGIN:TODO 用户未登录
	 *
	 * @since version 1.0
	 */
	public static final Integer USER_NOT_LOGIN = 304;
	
	/**
	 * NEED_BIND_CARD:TODO 用户需要绑定卡
	 *
	 * @since version 1.0
	 */
	public static final Integer NEED_BIND_CARD = 305;
	
	/**
	 * H5_URL_ADDR:TODO H5原生地址
	 *
	 * @since version 1.0
	 */
	public static final String H5_URL_ADDR = "http://dev.ncme.org.cn/ncmeapp/#/";
	
	/**
	 * NOT_BIND_WECHAT:微信号没有绑定NCME账号
	 *
	 * @since version 1.0
	 */
	public static final Integer NOT_BIND_WECHAT = 306;
	
	/**
	 * ALREADY_BIND_WECHAT:该账号已绑定其他微信号
	 *
	 * @since version 1.0
	 */
	public static final Integer ALREADY_BIND_WECHAT = 307;
	
	/**
	 * 该项目需要绑定卡类型
	 */
	public static final Integer NEED_BIND_CARDTYPE = 308;
	
	/**
	 * 随堂考试未通过
	 */
	public static final Integer NOT_PASS_EXAM = 309;
}
