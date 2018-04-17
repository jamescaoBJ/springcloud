/**
 * CardController.java
 * com.wjw.controller
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月13日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.DateUtil;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.CvSet;
import com.ncme.springboot.model.SystemCard;
import com.ncme.springboot.model.SystemCardSetOrder;
import com.ncme.springboot.model.SystemCardTypeCvSet;
import com.ncme.springboot.model.SystemCardUser;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.CardService;
import com.wjw.service.CvSetService;
import com.wjw.service.SystemCardService;
import com.wjw.service.SystemUserService;
import com.wjw.util.SystemUserUtil;

/**
 * ClassName:CardController
 * Function: TODO ADD 学习卡控制器
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月13日	下午5:09:59
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/card")
public class CardController extends Controller {
	
	/**
	 * systemUserService:TODO 系统用户服务
	 *
	 * @since version 1.0
	 */
	@Autowired
	SystemUserService systemUserService;
	
	/**
	 * cardService:TODO 学习卡服务
	 *
	 * @since version 1.0
	 */
	@Autowired
	CardService cardService;
	/**
	 * systemCardService:TODO 学习卡服务
	 *
	 * @since version 1.0
	 */
	@Autowired
	SystemCardService systemCardService;
	/**
	 * cvSetService:TODO 项目服务
	 *
	 * @since version 1.0
	 */
	@Autowired
	CvSetService cvSetService;
	
	/**
	 * cardList: 学习卡列表服务
	 *
	 * @param  @param status
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/cardList") 
	public RtnBody cardList(String status){
		//获取用户信息
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		
		if(StrKit.isBlank(status)){
			
			status = "1"; // 1表示可使用，0表示已过期
		}
		
		List<Record> list = cardService.cardList(status,user.getId());
		return getRtnBody().data(list).code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功.");
		
	}
	
	/**
	 * cardDetails:学习卡详情
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param cardType
	 * @param  @param cardNumber
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/cardDetails") 
	public RtnBody cardDetails(String cardType,String cardNumber){// 卡类型；卡号
		
		if(StrKit.isBlank(cardNumber) || StrKit.isBlank(cardType) ){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("参数不能为空 .");
		}
		
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		
		//只有一个卡详细，直接返回record
		Record record = cardService.cardDetails(user.getId(),cardType,cardNumber);
		return getRtnBody().data(record).code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功。");
	}
	

	@RequestMapping("/cardBind")
	public RtnBody cardBind(String userId, String cardId, String cardPassword){
		RtnBody rtn = new RtnBody();
		SystemUser user = SystemUserUtil.getLoginUser(request);
		String domainName = request.getServerName(); //取到 域名地址
		if (StrKit.isBlank(cardId)) {
			return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("请输入卡号！");
		} else if (!StrKit.isBlank(cardId)) {
			SystemCard newCard = systemCardService.getSystemCardByNumAndPwd(cardId, null);
			if (newCard == null) {
				return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("卡号输入错误！");
			}
		} 
		if (StrKit.isBlank(cardPassword)) {
			return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("请输入密码！");
		} else if (!StrKit.isBlank(cardPassword)) {
			SystemCard newCard = systemCardService.getSystemCardByNumAndPwd(cardId, cardPassword);
			if (newCard == null) {
				return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("密码输入错误！");
			}
		}
		if (user != null) {
			//通过卡号和密码查询学习卡
			SystemCard newCard = systemCardService.getSystemCardByNumAndPwd(cardId, cardPassword);
			if (newCard != null) {
				//判断学习卡类型是否为空卡，如果为空卡，返回 该卡未绑定项目，无法添加成功
				if (BusinessConst.SystemCard_TYPE_NULL == newCard.getCardType()) {
					return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("该卡未绑定项目，无法添加成功！");
				}
				//判断学习卡是否过期
				int time = DateUtil.compareTo(newCard.getUsefulDate(), DateUtil.now("yyyy-MM-dd"));
				if (time < 0) {
					return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("该学习卡已过期，无法添加！");
				}
				//判断该学习卡是否已经被绑定
				if (newCard.getStatus() == 2) {
					return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("该学习卡已被使用，无法再次添加！");
				}
				//判断该学习卡是否被禁用
				if (newCard.getStatus() == -2) {
					return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("该学习卡已被停用，无法添加！");
				}
				if (newCard.getIsnotBind() != 1 && newCard.getStatus() == 1 && newCard.getUsefulDate() != null) {
					//判断卡类型是否绑定的有项目
					List<SystemCardTypeCvSet> cvSetList = systemCardService.findCvSetListByCardType(newCard.getCardType());
					if (cvSetList != null && cvSetList.size()>0) {
						for (SystemCardTypeCvSet s:cvSetList) {
							//查询订单表中是否有该用户绑卡信息
							SystemCardSetOrder setOrder = new SystemCardSetOrder();
							setOrder.setUserId(user.getId());
							setOrder.setCvSetId(s.getCvSetId());
							setOrder.setCardNumber(cardId);;
							Map param = new HashMap();
							param.put("cvSet", setOrder);
							param.put("cardTypeList", null);
							List<SystemCardSetOrder> orderList = systemCardService.findByUidProid(param);
							if (orderList != null && orderList.size() > 0) {
								continue;
							}
							//向system_card_set_order表中添加绑卡信息
							SystemCardSetOrder order = new SystemCardSetOrder();
							order.setCardTypeId(newCard.getCardType());// 卡类型
							order.setUserId(user.getId());// 用户id
							order.setUsefulDate(DateUtil.format(newCard.getUsefulDate(), "yyyy-MM-dd")+" 23:59:59");// 订单日期
							order.setPrice(newCard.getFaceValue()==null ? 0.00 : newCard.getFaceValue());// 价格
							order.setAmount(1D);
							order.setPayDate(DateUtil.getNow(DateUtil.FORMAT_LONG));// 支付日期
							order.setPaymodeCode("绑卡");// 订单类型
							order.setOrderNumber(System.currentTimeMillis() + "");
							order.setStatus(1);
							order.setOrderType(1);
							order.setCardNumber(newCard.getCardNumber());
							order.setCvSetId(s.getCvSetId());
							CvSet cvSet = cvSetService.getCvSetById(s.getCvSetId(),user.getUserProvinceId(),domainName);
							if (cvSet != null) {
								order.setItemName(cvSet.getName());
							} else {
								order.setItemName("");
							}
							//保存订单记录
							systemCardService.saveSystemCardSetOrder(order);
							// 用户卡绑定表中(绑定卡号之后保存绑卡用户的信息)
							SystemCardUser cardUser = new SystemCardUser();
							cardUser.setBindDate(DateUtil.now(DateUtil.FORMAT_LONG));
							cardUser.setUserId(user.getId());
							cardUser.setCardId(newCard.getId());
							cardUser.setSiteId(s.getCvSetId());
							systemCardService.saveBindUserinfor(cardUser);
						}
						//更改绑卡状态
						newCard.setStatus(2);
						systemCardService.updateSystemCard(newCard);
						return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("学习卡绑定成功！");
					} else {
						return rtn.code(BusinessConst.NEED_BIND_CARDTYPE).message("该项目需要绑定卡类型！");
					}
				}
			} else {
				return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("卡号和密码均输入错误！");
			}
		} else {
			return rtn.code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		return null;
	}
	
}
