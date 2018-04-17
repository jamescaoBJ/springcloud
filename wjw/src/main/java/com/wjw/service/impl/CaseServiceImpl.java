/**
 * CaseServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月7日       juniorice
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.mapper.CvLiveMapper;
import com.ncme.springboot.mapper.CvMapper;
import com.ncme.springboot.mapper.CvUnitMapper;
import com.wjw.service.CaseService;

/**
 * ClassName:CaseServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月7日	下午4:27:53
 *
 * @see 	 
 *  
 */
@Service
public class CaseServiceImpl implements CaseService {
	@Autowired
	CvLiveMapper cvLiveMapper;
	@Autowired
	CvMapper cvMapper;
	@Autowired
	CvUnitMapper cvUnitMapper;

	@Override
	public PageInfo<Record> getCaseCvList(Map<String, Object> map, String pageCurrent, String pageSize) {
//		PageHelper.startPage(StrKit.str2Int(pageCurrent), StrKit.str2Int(pageSize));
		
		//根据二级学科ID 获取其三级学科ID 包含: 妇产科学510004、 儿科学510005、医学教育与卫生管理610010809
		List<Record> xkList = new ArrayList<Record>();
		if(map.get("xueke")!=null ) {
			if (Integer.parseInt(map.get("xueke").toString())==510004 || Integer.parseInt(map.get("xueke").toString())==510005 || Integer.parseInt(map.get("xueke").toString())==610010809 || Integer.parseInt(map.get("xueke").toString())==580005) {
				xkList = cvMapper.getXueKeList(Integer.parseInt(map.get("xueke").toString()));
				if (xkList!=null && xkList.size()>0) {
					int[] aaa = new int[xkList.size()];
					for (int i=0;i<xkList.size();i++) {
						aaa[i]=Integer.parseInt(xkList.get(i).get("id").toString());
					}
					map.put("xk", aaa);
				}
			}
		}
		
		List<Record> cvList = cvMapper.getCaseCvList(map);
		for (Record cv : cvList) {
			List<Record> teacherList = cvLiveMapper.selectTeacher((Integer)cv.get("typicalId"));
			if (teacherList != null && teacherList.size() > 0) {
				cv.put("typicalTeacher", teacherList.get(0).get("name"));
			} else {
				cv.put("typicalTeacher", "");
			}
			//根据课程ID获取其项目
			Record cvset = cvLiveMapper.getCvSet((Integer)cv.get("typicalId"));
			if (cvset != null && cvset.get("costType") != null) {
				cv.put("costType", cvset.get("costType"));
			} else {
				cv.put("costType", 0);
			}
		}
		PageInfo<Record> page;
		if (pageCurrent!=null) {
			if (cvList.size() > Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)) {
				page = new PageInfo<Record>(cvList.subList((Integer.parseInt(pageCurrent)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)));
			} else {
				page = new PageInfo<Record>(cvList.subList((Integer.parseInt(pageCurrent)-1)*Integer.parseInt(pageSize), cvList.size()));
			}
				
			if (cvList.size() > Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)) {
				page.setIsLastPage(false);
			} else {
				page.setIsLastPage(true);
			}
			page.setTotal(cvList.size());
			return page;
		} else {
			if (cvList.size() > Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)) {
				page = new PageInfo<Record>(cvList.subList((Integer.parseInt(pageCurrent)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)));
			} else {
				page = new PageInfo<Record>(cvList.subList((Integer.parseInt(pageCurrent)-1)*Integer.parseInt(pageSize), cvList.size()));
			}
				
			if (cvList.size() > Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)) {
				page.setIsLastPage(false);
			} else {
				page.setIsLastPage(true);
			}
			page.setTotal(cvList.size());
			return page;
		}
	}

	@Override
	public Record getCvDetailById(Map<String, Object> map) {
		//根据课程id查询其详情
		Record record = null;
		record = cvMapper.getCvDetailById(map);
		if (record!=null && record.get("typicalId")!=null) {
			List<Record> teacherList = cvLiveMapper.selectTeacher((Integer)record.get("typicalId"));
			if (teacherList != null && teacherList.size() > 0) {
				record.put("typicalTeacher", teacherList.get(0).get("name"));
				record.put("teacherPhoto", teacherList.get(0).get("photo"));
				record.put("teacherIntroduce", teacherList.get(0).get("summary"));
			} else {
				record.put("typicalTeacher", "");
				record.put("teacherPhoto", "");
				record.put("teacherIntroduce", "");
			}
			//根据课程ID获取其项目
			Record cvset = cvLiveMapper.getCvSet((Integer)record.get("typicalId"));
			if (cvset != null && cvset.get("costType") != null) {
				record.put("costType", cvset.get("costType"));
				record.put("cvSetId", cvset.get("id"));
			} else {
				record.put("costType", 0);
				record.put("cvSetId", "");
			}
			//根据课程ID获取 本课程下第一单元的vedioUrl (与 下面的 getCvCatalogById()方法中的  根据课程id查询其目录 功能相同 sql不同)
			List<Record> cvUnitList = cvUnitMapper.getUnitListByCvId((Integer)record.get("typicalId"));
			if (cvUnitList!=null && cvUnitList.size()>0) {
				String vedioUrl = (String)cvUnitList.get(0).get("mediaId");
				record.put("ccId", vedioUrl);
			} else {
				record.put("ccId", "");
			}
			record.put("guidIntroduce", "");
			record.put("newIntroduce", "");

			//判断该课程学习状态 0:未学习    1:学习中   2:已完成
			if (map.get("userId")!=null) {
				String no = "";
				no = cvMapper.getCvStudyStatue(map);
				if(no!=null && no!=""){
					if (no.equals("1")) {
						record.put("logCVSetStatus", 1);
					} else if (no.equals("2")) {
						record.put("logCVSetStatus", 2);
					} else {
						record.put("logCVSetStatus", 0);
					}
				} else {
					record.put("logCVSetStatus", 0);
				}
			} else {
				record.put("logCVSetStatus", 0);
			}
			//返回该课程当前学习的单元ID(cvUnitId)--若未学习过,则返回该课程的第一个单元ID(返回增加: 及单元对应的类别  1:理论讲解 2:主题讨论 3:随堂考试 4:操作演示 5:扩展阅读 6:病例分享)
			Record cvUnit = cvMapper.getCvStudyingCvUnitId(map);
			if (cvUnit!=null) {
				record.put("unitId", cvUnit.get("cvUnitId").toString());
				record.put("type", cvUnit.get("type").toString());
			} else {
				if (cvUnitList!= null && cvUnitList.size() > 0){
					try{
						if (cvUnitList.get(0).get("id").toString()!=null) {
							record.put("unitId", cvUnitList.get(0).get("id").toString());
							record.put("type", cvUnitList.get(0).get("type").toString());
						}
					}catch(Exception e){
						record.put("unitId", "");
						record.put("type", "");
					}
				} else {
					record.put("unitId", "");
					record.put("type", "");
				}
			}
			//判断该课程是否被收藏过
			if (map.get("userId")!=null) {
				//0 项目 1课程 2直播课程 以下为课程 设置值为1
				map.put("type", 1); 
				map.put("CvSetId",(Integer)record.get("typicalId"));
				int no = 0;
				no = cvMapper.getMyFavIsFavById(map);
				if (no>0) {
					record.put("isFav", 1);
				} else {
					record.put("isFav", 0);
				}
			} else {
				record.put("isFav", 0);
			}
		}
		return record;
	}

	@Override
	public Record getCvCatalogById(Map<String, Object> map) {
		Record res = new Record();
		//获取课程详情
		Record record = null;
		record = cvMapper.getCvDetailById(map);
		if (record !=null && record.get("typicalId") != null){
			res.put("typicalId", record.get("typicalId"));
			res.put("unitName", record.get("typicalTitle"));
			res.put("cvType", record.get("cvType"));
			//根据课程id查询其目录
			List<Record> cvUnitList = cvMapper.getCvCatalogById(map);
			if (cvUnitList!= null){
				res.put("cvUnitList", cvUnitList);
			} else {
				res.put("cvUnitList", "");
			}
			//根据课程ID获取其项目
			Record cvset = cvLiveMapper.getCvSet((Integer)record.get("typicalId"));
			if (cvset != null && cvset.get("costType") != null) {
				res.put("costType", cvset.get("costType"));
			} else {
				res.put("costType", 0);
			}
		} else {
			res.put("typicalId", "");
			res.put("unitName", "");
			res.put("cvUnitList", "");
			res.put("cvType", "");
		}
		return res;
	}

	@Override
	public String getProjectIdByUnitId(String unitId) {
		String cvId ="",cvSetId="";
		//根据单元ID获取到 该单元 所在的课程ID
		cvId = cvMapper.getCvIdByUnitId(unitId);
		if (cvId!=null) {
			//再根据 课程ID 获取 其课程 所在的 项目ID
			cvSetId = cvMapper.getCvSetIdByCvId(cvId);
		}
		
		return cvSetId;
	}



}
