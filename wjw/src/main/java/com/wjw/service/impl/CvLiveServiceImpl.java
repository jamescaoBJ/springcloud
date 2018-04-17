/**
 * CvLiveServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月6日       juniorice
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.mapper.CvLiveMapper;
import com.ncme.springboot.mapper.CvMapper;
import com.ncme.springboot.mapper.SystemCardSetOrderMapper;
import com.ncme.springboot.mapper.SystemCardTypeCvSetMapper;
import com.ncme.springboot.model.CvLive;
import com.ncme.springboot.model.LogStudyCvUnit;
import com.ncme.springboot.model.SystemCardSetOrder;
import com.ncme.springboot.model.SystemCardTypeCvSet;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.CvLiveService;
import com.wjw.util.SystemUserUtil;

/**
 * ClassName:CvLiveServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月6日	下午6:07:02
 *
 * @see 	 
 *  
 */
@Service
public class CvLiveServiceImpl implements CvLiveService {
	@Autowired
	CvLiveMapper cvLiveMapper;
	@Autowired
	SystemCardTypeCvSetMapper cardTypeCvSetMapper;
	@Autowired
	SystemCardSetOrderMapper cardSetOrderMapper;
	@Autowired
	CvMapper cvMapper;

	@Override
	public PageInfo<Record> getCvList(Map<String,Object> map, String pageCurrent, String pageSize,HttpServletRequest request) {
		PageHelper.startPage(StrKit.str2Int(pageCurrent), StrKit.str2Int(pageSize));
		//获取直播列表信息
		List<Record> cvList = cvLiveMapper.getCvList(map);
		Integer flagg = 1;	//1:没过期  304:用户未登录或者Token已过期！
		//获取用户信息
		SystemUser user = SystemUserUtil.getLoginUser(request); //权限信息应该在项目展示阶段进行鉴权,原系统设计不合理，暂时复用

		List<Record> allArry = new ArrayList<Record>();
		allArry.addAll(cvList);
		if (user == null) {
			flagg = BusinessConst.USER_NOT_LOGIN;
		} 
		
		if(cvList!=null && cvList.size()>0) {
			for (Record record : cvList) {
				//根据课程ID获取项目List
				List<Record> cvsetList = cvLiveMapper.cvForProvinceManager((Integer)record.get("cvId"));
				if (cvsetList!=null && cvsetList.size()>0) {
					//如果该项目授权不是全国则进行处理
					List<Record> propCount = cvLiveMapper.propCount((Integer)cvsetList.get(0).get("id"));
					if(propCount == null || propCount.size() == 0) {//如果该项目授权不是全国则进行处理
						if (user != null) {
							Map<String,Object> map1=new HashMap<String, Object>();
							map1.put("userId", user.getId());
							map1.put("cvSetId",cvsetList.get(0).get("id").toString());
							int user_propCount = cvLiveMapper.userPropCount(map1);
							if(user_propCount < 1){					//如果该项目不是该会员所在省时则移除
	    						allArry.remove(record);
	    					}
						} else {
							allArry.remove(record);
						}
					}
				}
			}
		}
		
		for (Record cv : allArry) {
			Integer currentType = (Integer)cv.get("type");
			
			List<Record> teacherList = cvLiveMapper.selectTeacher((Integer)cv.get("cvId"));
			if (teacherList != null && teacherList.size() > 0) {
				cv.put("teacherName", teacherList.get(0).get("name"));
				cv.put("teacherPhoto", teacherList.get(0).get("photo"));
				cv.put("teacherIntroduce", teacherList.get(0).get("summary"));
			} else {
				cv.put("teacherName", "");
				cv.put("teacherPhoto", "");
				cv.put("teacherIntroduce", "");
			}
			if (currentType == 1) {
				cv.put("studentNum", getStudyCountForOnline((Integer)cv.get("cvId")));
			} else if (currentType == 2) {
				cv.put("studentNum", 200);
			} else if (currentType == 3) {
				cv.put("studentNum", getStudyCountForEnd((Integer)cv.get("cvId")));
			} else if(currentType == 4) {
				cv.put("studentNum", getStudyCountForViewBack((Integer)cv.get("cvId")));
			} else {
				cv.put("studentNum", getStudyCountForEnd((Integer)cv.get("cvId")));		//未转码的直接取观看过直播的人数
			}
			cv.put("startDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(cv.get("startDate")));
			cv.put("endDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(cv.get("endDate")));
			cv.put("tokenflag", flagg);
			if (user!=null && user.getId()!=null) {
				if (checkSignUp(user.getId().toString(),cv.get("cvId").toString())){
					cv.put("isSignup", 0);  //是否报名 0 已报名 1 未报名
				} else {
					cv.put("isSignup", 1);
				}
			} else {
				cv.put("isSignup", 1);  	
			}
			
			String startDate="",invaliDate="",month="",day="",start="",invali="",str="";
			startDate = (String) cv.get("startDate");
			invaliDate = (String) cv.get("endDate");
			if (startDate!=null && startDate!="" && invaliDate!=null && invaliDate!="") {
				month = startDate.substring(5, 7);
				day = startDate.substring(8, 10);
				start = startDate.substring(11, 16);
				invali = invaliDate.substring(11, 16);
				str=month+"月"+day+"日 "+start+"-"+invali;
			}
			cv.put("itemHintTitle", str);
			
			//回放地址
			String classNo = (String)cv.get("classNo");
			if (classNo != null && !"".equals(classNo)) {
				List<Record> wareList = cvLiveMapper.getCoursewareList(classNo);
				if (wareList != null && wareList.size() > 0) {
					cv.put("viewBackUrlList", wareList);
				} else {
					cv.put("viewBackUrlList", "");
				}
			} else {
				cv.put("viewBackUrlList", "");
			}
			//根据课程ID获取其项目
			Record cvset = cvLiveMapper.getCvSet((Integer)cv.get("cvId"));
			if (cvset != null && cvset.get("costType") != null) {
				cv.put("costType", cvset.get("costType"));
			} else {
				cv.put("costType", 0);
			}
			
			//判断该课程是否被收藏过
			if (user!=null && user.getId()!=null) {
				//0 项目 1课程 2直播课程 以下为课程 设置值为1
				map.put("userId", user.getId());
				map.put("type", 2); 
				map.put("CvSetId",(Integer)cv.get("cvId"));
				int no = 0;
				no = cvMapper.getMyFavIsFavById(map);
				if (no>0) {
					cv.put("isFav", 1);
				} else {
					cv.put("isFav", 0);
				}
			} else {
				cv.put("isFav", 0);
			}
		}
		PageInfo<Record> page = new PageInfo<Record>(allArry);
		return page;
	}
	
	public int getStudyCountForOnline(Integer cvId){
		int count = 0;
		try{
			count = cvLiveMapper.getStudyNumForOnline(cvId);
		}catch(Exception ex){
			count = 0;
		}
		return count;
	}
	
	public int getStudyCountForEnd(Integer cvId){
		int count = 0;
		try{
			count = cvLiveMapper.getStudyNumForEnd(cvId);
		}catch(Exception ex){
			count = 0;
		}
		return count;
	}
	
	public int getStudyCountForViewBack(Integer cvId){
		int count = 0;
		try{
			count = cvLiveMapper.getStudyNumForViewBack(cvId);
		}catch(Exception ex){
			count = 0;
		}
		return count;
	}
	
	public int getStudentNum(Integer type, Integer cvId){
		int lel = type == null ? 0 : type;
		int num = 0;
		switch (lel) {
		case 1:
			num = getStudyCountForOnline(cvId);
			break;
		case 2:
			num = 200;
			break;
		case 3:
			num = getStudyCountForEnd(cvId);
			break;
		case 4:
			num = getStudyCountForViewBack(cvId);
			break;
		case 5:
			num = getStudyCountForEnd(cvId);
			break;
		default:
			num = 200;
		}
		return num;
	}

	@Override
	public Record getDetail(Map<String, Object> map,HttpServletRequest request) {
		//获取直播列表信息
		Integer flagg = 1;//1:没过期  304:用户未登录或者Token已过期！
		//获取用户信息
		SystemUser user = SystemUserUtil.getLoginUser(request); //权限信息应该在项目展示阶段进行鉴权,原系统设计不合理，暂时复用
		if (user == null) {
			flagg = BusinessConst.USER_NOT_LOGIN;
		}
		
		List<Record> cvList = cvLiveMapper.getDetail(map);
		if (cvList!=null && cvList.size()>0) {
			for (Record cv : cvList) {
				Integer currentType = (Integer) cv.get("type");
				
				List<Record> teacherList = cvLiveMapper.selectTeacher((Integer)cv.get("cvId"));
				if (teacherList != null && teacherList.size() > 0) {
					cv.put("teacherName", teacherList.get(0).get("name"));
					cv.put("teacherPhoto", teacherList.get(0).get("photo"));
					cv.put("teacherIntroduce", teacherList.get(0).get("summary"));
				} else {
					cv.put("teacherName", "");
					cv.put("teacherPhoto", "");
					cv.put("teacherIntroduce", "");
				}

				if (user!=null && user.getId()!=null) {
					if (checkSignUp(user.getId().toString(),cv.get("cvId").toString())){
						cv.put("isSignup", 0);  //是否报名 0 已报名 1 未报名 
					} else {
						cv.put("isSignup", 1);
					}
				} else {
					cv.put("isSignup", 1);  	
				}
				//cv.put("isSignup", 1);  		//是否报名 0 已报名 1 未报名 。此字段因后台暂未设置报名表，不能实际获取数据进行判断，故先返回一个值 0
				
				if (currentType == 1) {
					cv.put("studentNum", getStudyCountForOnline((Integer)cv.get("cvId")));
				} else if (currentType == 2) {
					cv.put("studentNum", 200);
				} else if (currentType == 3) {
					cv.put("studentNum", getStudyCountForEnd((Integer)cv.get("cvId")));
				} else if(currentType == 4) {
					cv.put("studentNum", getStudyCountForViewBack((Integer)cv.get("cvId")));
				} else {
					cv.put("studentNum", getStudyCountForEnd((Integer)cv.get("cvId"))); //未转码的直接取观看过直播的人数
				}
				cv.put("startDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(cv.get("startDate")));
				cv.put("endDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(cv.get("endDate")));
				cv.put("tokenflag", flagg);
				String startDate="",invaliDate="",month="",day="",start="",invali="",str="";
				startDate = (String) cv.get("startDate");
				invaliDate = (String) cv.get("endDate");
				if (startDate!=null && startDate!="" && invaliDate!=null && invaliDate!="") {
					month = startDate.substring(5, 7);
					day = startDate.substring(8, 10);
					start = startDate.substring(11, 16);
					invali = invaliDate.substring(11, 16);
					str=month+"月"+day+"日 "+start+"-"+invali;
				}
				cv.put("itemHintTitle", str);
				
				//回放地址
				String classNo = (String)cv.get("classNo");
				if (classNo != null && !"".equals(classNo)) {
					List<Record> wareList = cvLiveMapper.getCoursewareList(classNo);
					if (wareList != null && wareList.size() > 0) {
						cv.put("viewBackUrlList", wareList);
					} else {
						cv.put("viewBackUrlList", "");
					}
				} else {
					cv.put("viewBackUrlList", "");
				}
				//根据课程ID获取其项目
				Record cvset = cvLiveMapper.getCvSet((Integer)cv.get("cvId"));
				if (cvset != null && cvset.get("costType") != null) {
					cv.put("costType", cvset.get("costType"));
				} else {
					cv.put("costType", 0);
				}

				//判断该课程是否被收藏过
				if (user!=null && user.getId()!=null) {
					//0 项目 1课程 2直播课程 以下为课程 设置值为1
					map.put("userId", user.getId());
					map.put("type", 2); 
					map.put("CvSetId",(Integer)cv.get("cvId"));
					int no = 0;
					no = cvMapper.getMyFavIsFavById(map);
					if (no>0) {
						cv.put("isFav", 1);
					} else {
						cv.put("isFav", 0);
					}
				} else {
					cv.put("isFav", 0);
				}
			}
			return cvList.get(0);
		} else {
			return null;
		}
		
	}

	
	@Override
	public Record checkBindCost(String userId, String cvId) {
		//根据课程ID获取其项目
		Record cvset = cvLiveMapper.getCvSet(Integer.valueOf(cvId));
		//bindFlag值   0:用户需要绑定学习卡才能开始学习  1:不需要绑定学习卡  2:此课程不隶属于一个项目
		Record r = new Record();
		if (cvset != null && cvset.get("costType") != null) {
			Integer costType = (Integer)cvset.get("costType");
			//第一步先判断该项目是否为卡项目
			if (costType == 1) {//学习卡项目
				//如果是，第二步判断卡类型里是否包含该项目
				List<SystemCardTypeCvSet> cvSetList = cardTypeCvSetMapper.findListBycvSetId((Integer)cvset.get("id"));
				List<Integer> cardTypeList = new ArrayList<Integer>();
				if (cvSetList != null && cvSetList.size() > 0) {
					for (SystemCardTypeCvSet c:cvSetList) {
						cardTypeList.add(c.getCardtypeId());
					}
					//查询订单表中是否有该用户绑卡信息
					SystemCardSetOrder setOrder = new SystemCardSetOrder();
					setOrder.setUserId(Integer.valueOf(userId));
					//setOrder.setCvSetId((Integer)cvset.get("id"));
					//setOrder.setCardTypeId(cvSetList.get(0).getCardtypeId());
					Map param = new HashMap();
					param.put("cvSet", setOrder);
					param.put("cardTypeList", cardTypeList);
					List<SystemCardSetOrder> orderList = cardSetOrderMapper.findByUidProid(param);
					if (orderList != null && orderList.size() > 0) {
						r.put("bindFlag", 1);
					} else {
						r.put("bindFlag", 0);
					}
				} else {//如果不包含则该项目非绑卡项目
					r.put("bindFlag", BusinessConst.NEED_BIND_CARDTYPE);
				}
			} else if (costType == 2) {//付费项目，目前暂不考虑
				//r.put("cost", 0);
				r.put("bindFlag", 1);
			} else {
				r.put("bindFlag", 1);
			}
			r.put("projectId", cvset.get("id"));
			return r;
		} else {
			r.put("bindFlag", 2);
			r.put("projectId", "");
		}
		return r;
		
	}

	@Override
	public void signUpInfo(String userId, String cvId) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		cvLiveMapper.signUpInfo(userId, cvId,date);
	}

	@Override
	public boolean checkSignUp(String userId, String cvId) {
		int no = 0;
		no = cvLiveMapper.checkSignUp(userId, cvId);
		if (no>0) {
			return true;
		}
		return false;
	}

	@Override
	public CvLive selectByPrimaryKey(Integer id) {
		return cvLiveMapper.selectByCvId(id);
	}
	
	/**
	 * 直播记录保存或更新
	 */
	@Override
	public String maintainLogStudySave(String userId, String cvId) {
		//根据课程ID获取其项目
		Record cvset = cvLiveMapper.getCvSet(Integer.valueOf(cvId));
		if (cvset == null || cvset.get("id") == null || cvset.get("id") =="") {
			return "1";
		} 
		List<Record> unitList = cvLiveMapper.selectCVUnitByCvId(cvId == null?0:Integer.parseInt(cvId));
    	if(unitList == null || unitList.size() < 1){
    		return "2";
    	}
    	Integer cvUnitId = (Integer)unitList.get(0).get("id");//直播默认创建一个单元
    	
    	LogStudyCvUnit cvs = new LogStudyCvUnit();
		cvs.setLogStudyCvSetId(Integer.parseInt(cvset.get("id").toString()));
		cvs.setCvId(cvId == null?0:Integer.parseInt(cvId));
		cvs.setCvUnitId(cvUnitId);
		cvs.setSystemUserId(userId == null?0:Integer.parseInt(userId));
    	
		//根据单元id判断是否存在记录(log_study_cv_unit)
		Map<String,Object> map = new HashMap<String, Object>();
    	map.put("userId", userId);
    	map.put("cvUnitId", cvUnitId);
    	
        List<Record> list = cvLiveMapper.queryLogStudyCVUnitByUnitId(map);
        if(list!=null && list.size()>0){
			//执行修改记录
        	cvLiveMapper.updLogStudyCVUnit(cvs);
		}else{
			//执行保存记录
			cvLiveMapper.insertLogStudyCVUnit(cvs);
		}
        /*
        //判断是否存在记录(log_study_cv_set)
        map.put("cvSetId", Integer.parseInt(cvset.get("id").toString()));
        
        List<Record> cvSetlist = cvLiveMapper.queryLogStudyCVSet(map);
        if(cvSetlist!=null && cvSetlist.size()>0){
			//执行修改记录
        	cvLiveMapper.updLogStudyCVSet(cvs);
		}else{
			//执行保存记录
			cvLiveMapper.insertLogStudyCVSet(cvs);
		}
        
        map.put("cvId", Integer.parseInt(cvId));
        //判断是否存在记录(log_study_cv) 
        List<Record> cvlist = cvLiveMapper.queryLogStudyCv(map);
        if(cvlist!=null && cvlist.size()>0){
			//执行修改记录
        	cvLiveMapper.updLogStudyCv(cvs);
		}else{
			//执行保存记录
			cvLiveMapper.insertLogStudyCv(cvs);
		}
        */
        
		return "0";
	}



}
