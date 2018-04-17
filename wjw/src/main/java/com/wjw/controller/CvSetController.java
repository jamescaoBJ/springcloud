package com.wjw.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.DateUtil;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.Cv;
import com.ncme.springboot.model.CvSet;
import com.ncme.springboot.model.CvSetScore;
import com.ncme.springboot.model.CvSetUnitDiscuss;
import com.ncme.springboot.model.CvSetUnitNote;
import com.ncme.springboot.model.LogStudyCvSet;
import com.ncme.springboot.model.SystemCard;
import com.ncme.springboot.model.SystemCardSetOrder;
import com.ncme.springboot.model.SystemCardTypeCvSet;
import com.ncme.springboot.model.SystemCardUser;
import com.ncme.springboot.model.SystemUser;
import com.ncme.springboot.model.SystemUserConfig;
import com.wjw.service.CvSetScoreService;
import com.wjw.service.CvSetService;
import com.wjw.service.LogStudyCvSetService;
import com.wjw.service.SubjectService;
import com.wjw.service.SystemCardService;
import com.wjw.service.SystemUserService;
import com.wjw.util.SystemUserUtil;

/**
 * ClassName:CvSetController
 * Function: 项目Controller
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月2日	上午11:52:43
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/mooc")
public class CvSetController extends Controller {
	
	@Autowired
	CvSetService cvSetService;
	@Autowired
	LogStudyCvSetService logStudyCvSetService;
	@Autowired
	SystemUserService systemUserService;
	@Autowired
	CvSetScoreService cvSetScoreService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	SystemCardService systemCardService;

	/**
	 * getMoocDetailByProjectId:
	 * 项目详情接口
	 * @param  @param userId
	 * @param  @param peojectId
	 * @param  @return    
	 * @return RtnBody    
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/getMoocDetailByProjectId")
	public RtnBody getMoocDetailByProjectId(String projectId){
		if(StrKit.isBlank(projectId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("项目id必输。");
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		/*SystemUserConfig userConfig = null;
		if (user != null) {
			userConfig = systemUserService.getConfigByUserId(user.getId());
		}*/
		String domainName = request.getServerName(); //取到 域名地址
		RtnBody rtn = new RtnBody();
		Record cvSet = new Record();
		if (user != null && user.getUserProvinceId() != null) {
			cvSet = cvSetService.getProjectDetailById(Integer.valueOf(projectId), user.getUserProvinceId(), domainName);
		} else {
			cvSet = cvSetService.getProjectDetailById(Integer.valueOf(projectId), null, domainName);
		}
		//查询学习日志表用于判断学习状态（0:开始学习，1：继续学习，2：已学完）
		if (user != null) {
			List<LogStudyCvSet> logStudyCvSetList = logStudyCvSetService.listLogStudyByCvSetId(Integer.valueOf(user.getId()), 
					Integer.valueOf(projectId));
			if (logStudyCvSetList != null && logStudyCvSetList.size()>0) {
				cvSet.put("logCVSetStatus", logStudyCvSetList.get(0).getState());
			}else {
				cvSet.put("logCVSetStatus", 0);
			}
			Map<String,Object> map=new HashMap<String, Object>();
			//0 项目 1课程 2直播课程 以下为项目 设置值为0
			map.put("type", 0); 
			map.put("CvSetId",Integer.valueOf(projectId));
			map.put("userId", user.getId());
			int no = 0;
			no = cvSetService.getMyFavIsFavById(map);
			if (no>0) {
				cvSet.put("isFav", 1);
			} else {
				cvSet.put("isFav", 0);
			}
		} else {
			cvSet.put("logCVSetStatus", 0);
			cvSet.put("isFav", 0);
		}
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(cvSet); 
	}
	
	/**
	 * getScoreLogByProjectId:
	 * 根据项目id查询该项目的评价信息
	 * @param  @param projectId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/getScoreLogByProjectId")
	public RtnBody getScoreLogByProjectId(String projectId){
		if(StrKit.isBlank(projectId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("项目id必输。");
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		RtnBody rtn = new RtnBody();
		String pageNum = getPara("pageNum"); // 当前页码
		if (StrKit.isBlank(pageNum)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		String pageSize = getPara("pageSize", "20"); // 每页条数
		if (StrKit.isBlank(pageSize)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("每页面条数未指定！");
		}
		PageInfo<Record> page = cvSetScoreService.listScoreLogByCvSetId(Integer.valueOf(projectId), pageNum, pageSize);
		//查询项目综合评分
		CvSetScore cvSetScore = cvSetScoreService.getScoreByCvSetId(Integer.valueOf(projectId));
		String evaluateScore = "100";
		if (cvSetScore != null) {
			evaluateScore = cvSetScore.getGrade().toString();
		}
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(page).kvData("evaluateScore", evaluateScore); 
	}
	
	/**
	 * getMoocList:
	 * 慕课项目列表
	 * @param  @param xueke
	 * @param  @param sign
	 * @param  @param level
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/getMoocList")
	public RtnBody getMoocList(String xueke, String sign, String level){
		try {
			if (StrKit.notBlank(xueke)) {
				xueke = URLDecoder.decode(xueke,"UTF-8");
			}
			if (StrKit.notBlank(sign)) {
				sign = URLDecoder.decode(sign,"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		/*SystemUserConfig userConfig = null;
		if (user != null) {
			userConfig = systemUserService.getConfigByUserId(user.getId());
		}*/
		RtnBody rtn = new RtnBody();
		//查询 page分页
		String pageNum = getPara("pageNum"); // 当前页
		if (StrKit.isBlank(pageNum)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		String pageSize = getPara("pageSize", "20"); // 每页条数
		if (StrKit.isBlank(pageSize)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("每页面条数未指定！");
		}
		//1)未登录状态时，默认显示培训后台发布的授权到全国的乡医类型项目，按照发布时间倒叙排序；
		//2）已登录后，将根据用户注册所在地自动筛选更新，显示培训后台发布的授权到对应省份和全国的乡医类型项目，按照发布时间倒叙排序；
		CvSet cvSet = new CvSet();
		cvSet.setStatus(5);//已发布
		if (StrKit.notBlank(sign) && !"全部".equals(sign)) {
			cvSet.setSign(sign);//标签
		}
		if (StrKit.notBlank(level) && !"-1".equals(level)) {
			cvSet.setLevel(Integer.valueOf(level));;//级别
		}
		//筛选项为学科时
		if (StrKit.notBlank(xueke) && !"全部".equals(xueke)) {
			if ("儿科学".equals(xueke)) {
			 	//查询儿科学下的三级学科
				List<Record> subSubject = subjectService.getSubjectByIdAndName(510005, "", 1);
				List<String> xuekeName = new ArrayList<String>();
				for (Record r:subSubject) {
					xuekeName.add((String)r.get("name"));
				}
				cvSet.setXuekeName(xuekeName);
			} else if ("妇产科学".equals(xueke)) {
			 	//查询妇产科学下的三级学科
				List<Record> subSubject = subjectService.getSubjectByIdAndName(510004, "", 1);
				List<String> xuekeName = new ArrayList<String>();
				for (Record r:subSubject) {
					xuekeName.add((String)r.get("name"));
				}
				cvSet.setXuekeName(xuekeName);
			} else if ("医学教育与卫生管理".equals(xueke)) {
			 	//查询医学教育与卫生管理下的三级学科
				List<Record> subSubject = subjectService.getSubjectByIdAndName(610010809, "", 1);
				List<String> xuekeName = new ArrayList<String>();
				for (Record r:subSubject) {
					xuekeName.add((String)r.get("name"));
				}
				cvSet.setXuekeName(xuekeName);
			} else if ("儿科护理学".equals(xueke)) {
			 	//查询医儿科护理学下的三级学科
				List<Record> subSubject = subjectService.getSubjectByIdAndName(580005, "", 1);
				List<String> xuekeName = new ArrayList<String>();
				for (Record r:subSubject) {
					xuekeName.add((String)r.get("name"));
				}
				cvSet.setXuekeName(xuekeName);
			} else {
				cvSet.setPropName(xueke);
			}
		}
		String domainName = request.getServerName(); //取到 域名地址
		PageInfo<Record> page = new PageInfo<Record>();
		if (user != null && user.getUserProvinceId() != null) {
			page = cvSetService.getCVSetPageListByNameAndProvice(cvSet, user.getUserProvinceId(), pageNum, pageSize, domainName);
		} else {
			page = cvSetService.getCVSetPageListByNameAndProvice(cvSet, null, pageNum, pageSize, domainName);
		}
		
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(page);
		return rtn;
	}
	
	/**
	 * getCatalog: 获取项目目录
	 * TODO 根据原业务所编写代码
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/getCatalog")
	public RtnBody  getCatalog(String pageNum,String pageSize,String projectId){
		
		if(StrKit.isBlank(pageNum) || StrKit.isBlank(pageSize) ){
			
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("分页参数有误，请检查！");
		}
		
		
		if(StrKit.isBlank(projectId)){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("工程id必输。");

		}
		
		//* 原业务接口任务分工不明确，应该在返回拥有权限范围内的课程时，根据是否拥有权限而显示项目，获取目录则不必重复判断权限，所以此业务忽略掉权限过滤 ，
		//  模块分工化有益于复用和简化每个接口复杂度，有利于提高效率，
		//	维护和扩展@lyj
		
	
		
		//获取用户信息
		
//		SystemUser user = SystemUserUtil.getLoginUser(request); //权限信息应该在项目展示阶段进行鉴权,原系统设计不合理，暂时复用
		
		
		
		
		//获取目录
		PageInfo<Cv> page = cvSetService.mySelectCvByCvsetId(pageNum,pageSize,projectId,0);
		
		
		
		
		
		return  getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success.").data(page);
		
		
		
		
		
		
		
		
	}
	
	/**
	 * projectDiscuss:项目讨论
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/projectDiscuss") //权限限制目前参照原系统只在查询项目控制住就ok，所以讨论接口只暂时单纯提供查询，后续随业务改变。
	public RtnBody projectDiscuss(String pageNum,String pageSize,String projectId){
		
//		SystemAccount account = Token.USER(request, SystemAccount.class);
//		
//		//获取用户信息
//		
//		SystemUser user = systemUserService.getSystemUserByAccountName(account.getAccountName()); 
		
		//目前分析，讨论是针对所用用户，不是本人，不需要当前用户信息
		
		if(StrKit.isBlank(pageNum) || StrKit.isBlank(pageSize) || StrKit.isBlank(projectId)){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请检查必输项！");

			
		}
		
		PageInfo<Record>  page = cvSetService.projectDiscuss(pageNum,pageSize,Integer.valueOf(projectId));//test
		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success.").data(page);
		
		
	}
	
	
	/**
	 * unitDiscuss:获取项目单元讨论
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param unitId
	 * @param  @param projectId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/unitDiscuss")
	public RtnBody unitDiscuss(String pageNum,String pageSize,String unitId,String projectId){
		
		
		if(StrKit.isBlank(pageNum) || StrKit.isBlank(pageSize) || StrKit.isBlank(projectId) ||  StrKit.isBlank(unitId)){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请检查必输项！");

			
		}
		
		
		PageInfo<Record>  page = cvSetService.unitDiscuss(pageNum,pageSize,unitId,projectId);//test

		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success.").data(page);
		
		
	}
	
	
	/**
	 * projectNote:项目笔记
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param projectId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/projectNote")
	public RtnBody projectNote(String pageNum,String pageSize,String projectId){
		if(StrKit.isBlank(pageNum) || StrKit.isBlank(pageSize) || StrKit.isBlank(projectId) ){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请检查必输项！");

			
		}
		
		
		//获取用户信息
		
		SystemUser user = SystemUserUtil.getLoginUser(request); //权限信息应该在项目展示阶段进行鉴权,原系统设计不合理，暂时复用
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		
		PageInfo<Record>  page = cvSetService.projectNote(pageNum,pageSize,projectId,user.getId());//test
		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success.").data(page);
		
		
	}
	
	
	/**
	 * unitNote:项目单元笔记
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param projectId
	 * @param  @param unitId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/unitNote")
	public RtnBody unitNote(String pageNum,String pageSize,String projectId,String unitId){
		
		if(StrKit.isBlank(pageNum) || StrKit.isBlank(pageSize) || StrKit.isBlank(projectId) || StrKit.isBlank(unitId)){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请检查必输项！");

			
		}
		
		
		//获取用户信息
		
		SystemUser user = SystemUserUtil.getLoginUser(request); //权限信息应该在项目展示阶段进行鉴权,原系统设计不合理，暂时复用
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		
		PageInfo<Record>  page = cvSetService.unitNote(pageNum,pageSize,projectId,unitId,user.getId());//test
		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success.").data(page);
		
		
	}
	/**
	 * bindStudyCard:优质慕课绑定学习卡
	 * @param  @param userId
	 * @param  @param cardNum
	 * @param  @param cardPassWord
	 * @param  @param projectId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/bindStudyCard")
	public RtnBody bindStudyCard(String userId, String cardNum, String cardPassWord, String projectId){
		RtnBody rtn = new RtnBody();
		SystemUser user = SystemUserUtil.getLoginUser(request);
		String domainName = request.getServerName(); //取到 域名地址
		cardNum = cardNum.trim();
		if (StrKit.isBlank(cardNum)) {
			return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("请输入卡号！");
		}
		if (StrKit.isBlank(cardPassWord)) {
			return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("请输入密码！");
		}
		if (user != null) {
			//通过卡号和密码查询学习卡
			SystemCard systemCard = systemCardService.getSystemCardByNumAndPwd(cardNum, cardPassWord);
			if (systemCard != null) {
				//通过项目id和学习卡号查找学习卡,用于判断该学习卡是否绑定项目
				SystemCard newCard = systemCardService.getSystemCardByNumAndCvSetId(cardNum, Integer.valueOf(projectId));
				if (newCard != null) {
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
					if (StrKit.notBlank(cardNum) && cardNum.equals(newCard.getCardNumber())) {
						//判断卡类型是否绑定的有项目
						List<SystemCardTypeCvSet> cvSetList = systemCardService.findCvSetListByCardType(newCard.getCardType());
						if (cvSetList != null && cvSetList.size()>0) {
							for (SystemCardTypeCvSet s:cvSetList) {
								//查询订单表中是否有该用户绑卡信息
								SystemCardSetOrder setOrder = new SystemCardSetOrder();
								setOrder.setUserId(user.getId());
								setOrder.setCvSetId(s.getCvSetId());
								setOrder.setCardNumber(cardNum);;
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
					return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("该学习卡无法学习此项目，请输入匹配的卡号和密码！");
				}
			} else {
				return rtn.code(BusinessConst.CODE_RESPONSE_FAIL).message("输入的卡号或密码错误！");
			}
		} else {
			return rtn.code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		return null;
	}
	
	/**
	 * studyDetail:
	 * 优质慕课项目学习详情页
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/studyDetail")
	public RtnBody studyDetail(String userId, String projectId, String unitId){
		RtnBody rtn = new RtnBody();
		if(StrKit.isBlank(projectId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请检查必输项！");
		}
		//获取用户信息
		SystemUser user = SystemUserUtil.getLoginUser(request); //权限信息应该在项目展示阶段进行鉴权,原系统设计不合理，暂时复用
		if (user == null) {
			return rtn.code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		String domainName = request.getServerName();//取到 域名地址
		//检测项目是否需要付费和绑定相关的卡号
		Record r = cvSetService.checkBindCost(Integer.valueOf(user.getId()), Integer.valueOf(projectId), domainName);
		Record record = new Record();
		if (r.get("card")!=null) {
			if ((Integer)r.get("card") == 0) {
				return rtn.code(BusinessConst.NEED_BIND_CARD).message("用户需要绑定学习卡才能开始学习！");
			}
			//查询项目学习详情
			record = cvSetService.getProjectStudyDetail(Integer.valueOf(user.getId()), Integer.valueOf(projectId), unitId, domainName);
		}
		
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(record);
	}
	
	/**
	 * CvSetUnitDiscussService:TODO 优质慕课讨论服务
	 *
	 * @since version 1.0
	 */
	@Autowired
	com.wjw.service.CvSetUnitDiscussService CvSetUnitDiscussService;
	/**
	 * saveUnitDiscuss:优质慕课保存操作
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param cuc
	 * @param  @param result
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/saveUnitDiscuss")

	public RtnBody saveUnitDiscuss(@Validated CvSetUnitDiscuss cuc,BindingResult result){// 字段校验
		
		String message = validate(result);// 字段校验动作
		if(message != null){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message(message);
		}
		SystemUser user = SystemUserUtil.getLoginUser(request); //权限信息应该在项目展示阶段进行鉴权,原系统设计不合理，暂时复用

		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		cuc.setSystemUserId(user.getId());
		try {
			cuc.setDiscussContent(URLDecoder.decode(cuc.getDiscussContent(),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		if(CvSetUnitDiscussService.saveUnitDiscuss(cuc) >= 1){ //保存结果
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("发布成功。");
		}
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("发布失败。");
	}
	
	
	@RequestMapping(value="/saveUnitNote")

	public RtnBody saveUnitNote(@Validated CvSetUnitNote note,BindingResult result){
		String message = validate(result);// 字段校验动作

		if(message != null){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message(message);
		}

		SystemUser user = SystemUserUtil.getLoginUser(request); //权限信息应该在项目展示阶段进行鉴权,原系统设计不合理，暂时复用
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		note.setSystemUserId(user.getId());//userid
		note.setStatus(2);//参照原业务，设置为常量2
		try {
			note.setNoteContent(URLDecoder.decode(note.getNoteContent(),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		if(CvSetUnitDiscussService.saveUnitNote(note) >= 1){ //保存结果
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("发布成功。");
		}
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("发布失败。");
		
		
	}
}
