/**
 * TeacherServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月9日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.exception.MyException;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.mapper.ExpertInfoMapper;
import com.ncme.springboot.model.ExpertInfo;
import com.wjw.service.TeacherService;

/**
 * ClassName:TeacherServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月9日	上午10:59:54
 *
 * @see 	 
 *  
 */

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	ExpertInfoMapper expertInfoMapper;
	
	@Override
	public PageInfo<ExpertInfo> getTeachersByPage(ExpertInfo expertInfo,String pageCurrent, String pageSize) {
		PageHelper.startPage(StrKit.str2Int(pageCurrent), StrKit.str2Int(pageSize));
		List<ExpertInfo> list = expertInfoMapper.getTeachersByPage(expertInfo);
		
		PageInfo<ExpertInfo> page = new PageInfo<ExpertInfo>(list);
		
		return page;
	}

	@Override
	public PageInfo<Record> getTeachersByPageRecord(ExpertInfo expertInfo, String pageCurrent, String pageSize) {
		PageHelper.startPage(StrKit.str2Int(pageCurrent), StrKit.str2Int(pageSize));
		List<Record> list = expertInfoMapper.getTeachersByPageRecord(expertInfo);
		
		PageInfo<Record> page = new PageInfo<Record>(list);
		
		return page;
	}

	@Override
	public ExpertInfo getExportById(String id,String personage) {
		ExpertInfo  expertInfo = expertInfoMapper.getExportById(id,personage);
		return expertInfo;
	}

	@Override
	@Transactional
	public boolean delTeacherById(Integer id) {
		expertInfoMapper.deleteExpertPropVal(id);//关联表
		expertInfoMapper.deleteExpertGroupVal(id);//关联表
		expertInfoMapper.deleteCvRefTeacher(id);//关联表
		expertInfoMapper.deleteByPrimaryKey(id);//名师
		throw new  MyException("测试事务！");
	}

	@Override
	public PageInfo<ExpertInfo> getTeachersByPageVo(ExpertInfo expertInfo, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<ExpertInfo> list = expertInfoMapper.getTeachersByPage(expertInfo);
		
		PageInfo<ExpertInfo> page = new PageInfo<ExpertInfo>(list);
		return page;
	}

	@Override
	public PageInfo<Record> getFamousTeacherList(Map<String, Object> map, String pageCurrent, String pageSize) {
		List<Record> list = expertInfoMapper.getFamousTeacherList(map);
		if (list!=null && list.size()>0) {
			for (Record r : list) {
				if (r.get("teacherPost").toString()!=null) {
					switch (Integer.parseInt(r.get("teacherPost").toString())) {
					case 1:
						r.put("teacherPost", "院长");							//设置职务类型名称
						break;
					case 2:
						r.put("teacherPost", "副院长");
						break;
					case 8:
						r.put("teacherPost", "校长");
						break;
					case 9:
						r.put("teacherPost", "副校长");
						break;
					case 10:
						r.put("teacherPost", "书记");
						break;
					case 11:
						r.put("teacherPost", "副书记");
						break;
					case 12:
						r.put("teacherPost", "处长");
						break;
					case 13:
						r.put("teacherPost", "副处长");
						break;
					case 5:
						r.put("teacherPost", "所长");
						break;
					case 6:
						r.put("teacherPost", "副所长");
						break;
					case 14:
						r.put("teacherPost", "科长");
						break;
					case 15:
						r.put("teacherPost", "副科长");
						break;
					case 3:
						r.put("teacherPost", "主任");
						break;
					case 4:
						r.put("teacherPost", "副主任");
						break;
					case 7:
						r.put("teacherPost", "护士长");
						break;
					case 16:
						r.put("teacherPost", "副护士长");
						break;
					case 17:
						r.put("teacherPost", "秘书");
						break;
					default:
						r.put("teacherPost", "请选择");
						break;
					}
				} else {
					r.put("teacherPost", "请选择");
				}
				int no = 0;
				/* 暂不统计此值,即获取专家负责的项目数量
				if (r.get("teacherId").toString()!=null) {
					no = expertInfoMapper.getProjectNumByExpertId(Integer.parseInt(r.get("teacherId").toString()));
				}
				*/
				r.put("teacherProject", no);
			}
		}
		PageInfo<Record> page = new PageInfo<Record>(list);
		return page;
	}

	@Override
	public PageInfo<Record> getCommitteeList(Map<String, Object> map, String pageCurrent, String pageSize) {
		List<Record> list = expertInfoMapper.getCommitteeList(map);
		PageInfo<Record> page = new PageInfo<Record>(list);
		return page;
	}

	@Override
	public Record getCommitteeDetail(Map<String,Object> map) {
		Record r = expertInfoMapper.getCommitteeDetail(map);
		if (r != null && r.get("specialId") != null) {
			if (r.get("specialPost").toString()!=null) {
				switch (Integer.parseInt(r.get("specialPost").toString())) {
				case 1:
					r.put("specialPost", "院长");							//设置职务类型名称
					break;
				case 2:
					r.put("specialPost", "副院长");
					break;
				case 8:
					r.put("specialPost", "校长");
					break;
				case 9:
					r.put("specialPost", "副校长");
					break;
				case 10:
					r.put("specialPost", "书记");
					break;
				case 11:
					r.put("specialPost", "副书记");
					break;
				case 12:
					r.put("specialPost", "处长");
					break;
				case 13:
					r.put("specialPost", "副处长");
					break;
				case 5:
					r.put("specialPost", "所长");
					break;
				case 6:
					r.put("specialPost", "副所长");
					break;
				case 14:
					r.put("specialPost", "科长");
					break;
				case 15:
					r.put("specialPost", "副科长");
					break;
				case 3:
					r.put("specialPost", "主任");
					break;
				case 4:
					r.put("specialPost", "副主任");
					break;
				case 7:
					r.put("specialPost", "护士长");
					break;
				case 16:
					r.put("specialPost", "副护士长");
					break;
				case 17:
					r.put("specialPost", "秘书");
					break;
				default:
					r.put("specialPost", "请选择");
					break;
				}
			} else {
				r.put("specialPost", "请选择");
			}
			//根据专委会ID获取副主任委员信息
			List<Record> flist = new ArrayList<Record>();
			int type=2;  //副主任委员
			flist = expertInfoMapper.getViceSpecial(Integer.parseInt(r.get("specialId").toString()),type);
			r.put("viceSpecial", flist);
			//根据专委会ID获取秘书长信息
			type = 3;    //秘书长
			flist = expertInfoMapper.getViceSpecial(Integer.parseInt(r.get("specialId").toString()),type);
			r.put("secretary", flist);
			
			//根据专委会ID获取学组信息
			List <Map<String,Object>> llist = new ArrayList<Map<String,Object>>();
			List<Record> ltemp1 = new ArrayList<Record>();
			ltemp1 = expertInfoMapper.getLearnGroup(Integer.parseInt(r.get("specialId").toString()));
			if (ltemp1!=null && ltemp1.size()>0) {
				List<Record> ltemp2 = new ArrayList<Record>();
				for (Record record : ltemp1) {
					Map<String,Object> map1 = new HashMap<String,Object>();
					map1.put("lTitle",record.get("lTitle").toString());
					//根据学组ID,获取学组下的学员(包含学组长)信息
					ltemp2 = expertInfoMapper.getLearnGroupMember(Integer.parseInt(record.get("id").toString()));
					if (ltemp2!=null && ltemp2.size()>0) {
						map1.put("list", ltemp2);
					} else {
						map1.put("list", "");
					}
					llist.add(map1);
				}
			} else {
				llist.add(null);
			}
			r.put("learnGroup", llist);
		}
		return r;
	}
				
				
}
