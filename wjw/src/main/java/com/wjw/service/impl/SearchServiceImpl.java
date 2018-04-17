/**
 * SearchServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月3日       	 xh
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.mapper.CvLiveMapper;
import com.ncme.springboot.mapper.LogStudyCvSetMapper;
import com.ncme.springboot.mapper.SearchMapper;
import com.ncme.springboot.model.LogStudyCvSet;
import com.wjw.service.SearchService;

/**
 * ClassName:SearchServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月3日	上午9:34:15
 *
 * @see 	 
 *  
 */
@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	SearchMapper searchMapper;
	@Autowired
	LogStudyCvSetMapper logStudyCvSetMapper;
	@Autowired
	CvLiveMapper cvLiveMapper;
	@Autowired
	CvLiveServiceImpl cvLiveServiceImpl;
	@Override
	public PageInfo<Record> getSearchResultList(String keyWord, String pageCurrent, String pageSize, Integer provinceId, String domainName) {
		PageHelper.startPage(StrKit.str2Int(pageCurrent), StrKit.str2Int(pageSize));
		
		//首页全局搜索
		List<Record> cvSetList = searchMapper.getSearchResultList(keyWord, provinceId, domainName);
		for (Record r:cvSetList) {
			if(r.get("itemId")!=null && r.get("itemType").equals("0")){     		    //itemType=0 表示为项目
				List<LogStudyCvSet> logList = logStudyCvSetMapper.listLogStudyByCvSetId(null,(Integer)r.get("itemId"));
				if (logList != null && logList.size()>0) {
					r.put("itemHintTitle", logList.size());
				} else {
					r.put("itemHintTitle", 0);
				}
			}
			if(r.get("itemId")!=null && r.get("itemType").equals("1")){	    			//itemType=1 表示为课程
				if (r.get("itemStatus")!=null && !r.get("itemStatus").equals("0")) {    //直播课程: 1正在直播 2即将开始 3已结束 4直播回放 5 未完成转码
					String startDate="",invaliDate="",month="",day="",start="",invali="",str="";
					Integer currentType = Integer.valueOf((String) r.get("itemStatus"));
					startDate = (String) r.get("startDate");
					invaliDate = (String) r.get("endDate");
					if (startDate!=null && startDate!="" && invaliDate!=null && invaliDate!="") {
						month = startDate.substring(5, 7);
						day = startDate.substring(8, 10);
						start = startDate.substring(11, 16);
						invali = invaliDate.substring(11, 16);
						str=month+"月"+day+"日 "+start+"-"+invali;
					}
					List<Record> teacherList = cvLiveMapper.selectTeacher((Integer)r.get("itemId"));
					if (teacherList != null && teacherList.size() > 0) {
						r.put("itemTitleTeacher", teacherList.get(0).get("name"));
					} else {
						r.put("itemTitleTeacher", "");
					}
					if (currentType == 1) {
						r.put("itemPeopleNum", cvLiveServiceImpl.getStudyCountForOnline((Integer)r.get("itemId")));
						r.put("itemHintTitle", str);
						r.put("itemStatus", "正在直播");
					} else if (currentType == 2) {
						r.put("itemPeopleNum", 200);
						r.put("itemHintTitle", str);
						r.put("itemStatus", "即将开始");
					} else if (currentType == 3) {
						r.put("itemPeopleNum", cvLiveServiceImpl.getStudyCountForEnd((Integer)r.get("itemId")));
						r.put("itemHintTitle", str);
						r.put("itemStatus", "已结束");
					} else if(currentType == 4) {
						r.put("itemPeopleNum", cvLiveServiceImpl.getStudyCountForViewBack((Integer)r.get("itemId")));
						r.put("itemHintTitle", str);
						r.put("itemStatus", "直播回放");
					} else {
						r.put("itemPeopleNum", 200);
						r.put("itemHintTitle", str);
						r.put("itemStatus", "未完成转码");
					}
					/*
					CvLive cvLive=null;
					cvLive = cvLiveMapper.selectByCvId((Integer)r.get("itemId"));
					if(cvLive!=null && cvLive.getStartDate() !=null && cvLive.getInvalidDate() !=null) {
						Date currdate = new Date();
						Date startDate = cvLive.getStartDate();
						Date invaliDate = cvLive.getInvalidDate();
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						String month = df.format(startDate).substring(5, 7);
						String day = df.format(startDate).substring(8, 10);
						String start = df.format(startDate).substring(11, 16);
						String invali = df.format(invaliDate).substring(11, 16);
						String str=month+"月"+day+"日 "+start+"-"+invali;
						if(currdate.getTime() < startDate.getTime()) {
							r.put("itemStatus", "即将开始");
							//即将播放 已报名人数 默认设置200
							r.put("itemPeopleNum",200);
							r.put("itemHintTitle", str);
						} else if(startDate.getTime() < currdate.getTime() && currdate.getTime() < invaliDate.getTime()) {
							r.put("itemStatus", "正在播放");
							//当前直播在线人数
							if(cvLive.getClassNo()!=null){
								String no = cvLiveMapper.getOnlineNum(cvLive.getClassNo());
								r.put("itemPeopleNum",no);
							}else {
								r.put("itemPeopleNum",0);
							}
							r.put("itemHintTitle", str);
						} else if (currdate.getTime() > invaliDate.getTime() && cvLive.getClassNo() == null) {
							r.put("itemStatus", "已结束");
							r.put("itemPeopleNum",200);
							r.put("itemHintTitle", str);
						} else if (currdate.getTime() > invaliDate.getTime() && cvLive.getClassNo()!=null) {
							r.put("itemStatus", "直播回放");
							//直播回放人数
							if(cvLive.getClassNo()!=null){
								String no = cvLiveMapper.getHuiFangNum(cvLive.getCvId());
								r.put("itemPeopleNum",no);
							}else {
								r.put("itemPeopleNum",0);
							}
							r.put("itemHintTitle", str);
						}
					}*/
				} else {															   //0 非直播课程(根据其所属的项目是否收费显示：免费、学习卡、收费)
					//根据课程ID获取其项目
					Record cvset = cvLiveMapper.getCvSet((Integer)r.get("itemId"));
					if (cvset != null && cvset.get("costType") != null) {
						if (cvset.get("costType").equals("0")) {
							r.put("itemStatus", "免费");
						} else if (cvset.get("costType").equals("1")) {
							r.put("itemStatus", "学习卡");
						} else if (cvset.get("costType").equals("2")) {
							r.put("itemStatus", "收费");
						} else {
							r.put("itemStatus", "免费");
						}
					} else {
						r.put("itemStatus", "免费");
					}
					//获取课程学习次数
					int num = cvLiveMapper.getCourseLearnNum((Integer)r.get("itemId"));
					if ( num > 0) {
						r.put("itemHintTitle", num);
					} else {
						r.put("itemHintTitle", 0);
					}
				}
			}
			if (r.get("itemType").equals("2")) {
				if (r.get("itemPeopleNum") != null && r.get("itemPeopleNum") != "" && r.get("itemPeopleNum").toString()!=null) {
					switch (Integer.parseInt(r.get("itemPeopleNum").toString())) {
					case 1:
						r.put("itemPeopleNum", "院长");							//设置职务类型名称
						break;
					case 2:
						r.put("itemPeopleNum", "副院长");
						break;
					case 8:
						r.put("itemPeopleNum", "校长");
						break;
					case 9:
						r.put("itemPeopleNum", "副校长");
						break;
					case 10:
						r.put("itemPeopleNum", "书记");
						break;
					case 11:
						r.put("itemPeopleNum", "副书记");
						break;
					case 12:
						r.put("itemPeopleNum", "处长");
						break;
					case 13:
						r.put("itemPeopleNum", "副处长");
						break;
					case 5:
						r.put("itemPeopleNum", "所长");
						break;
					case 6:
						r.put("itemPeopleNum", "副所长");
						break;
					case 14:
						r.put("itemPeopleNum", "科长");
						break;
					case 15:
						r.put("itemPeopleNum", "副科长");
						break;
					case 3:
						r.put("itemPeopleNum", "主任");
						break;
					case 4:
						r.put("itemPeopleNum", "副主任");
						break;
					case 7:
						r.put("itemPeopleNum", "护士长");
						break;
					case 16:
						r.put("itemPeopleNum", "副护士长");
						break;
					case 17:
						r.put("itemPeopleNum", "秘书");
						break;
					default:
						r.put("itemPeopleNum", "请选择");
						break;
					}
				} else {
					r.put("itemPeopleNum", "请选择");
				}
			} 
		}
		PageInfo<Record> page = new PageInfo<Record>(cvSetList);
		return page;

	}

}
