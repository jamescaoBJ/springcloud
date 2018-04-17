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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.mapper.LogStudyCvSetMapper;
import com.ncme.springboot.mapper.SpecialMapper;
import com.ncme.springboot.model.LogStudyCvSet;
import com.wjw.service.SpecialService;

/**
 * 
 * ClassName:SpecialServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2018年2月27日	下午1:47:17
 *
 * @see 	 
 *
 */
@Service
public class SpecialServiceImpl implements SpecialService {
	@Autowired
	SpecialMapper specialMapper;
	@Autowired
	LogStudyCvSetMapper logStudyCvSetMapper;

	@Override
	public PageInfo<Record> getSpecialTrainList(String keyword, String state, String pageNum, String pageSize, HttpServletRequest request) {
		PageHelper.startPage(StrKit.str2Int(pageNum), StrKit.str2Int(pageSize));
		List<Record> sList = specialMapper.getSpecialTrainList(keyword, state);
		PageInfo<Record> page = new PageInfo<Record>(sList);
		return page;
	}

	@Override
	public Record getSpecialDetail(Integer userId, Integer zxSetId) {
		Record record = new Record();
		Record r = new Record();
		//根据专项ID,获取专项详情
		record = specialMapper.getSpecialDetail(zxSetId);
		if (record != null) {
			r.put("name", record.get("name"));
			r.put("coverUrl", record.get("coverUrl"));
			r.put("type", record.get("type"));
			r.put("code", record.get("code"));
			r.put("modeString", record.get("modeString"));
			r.put("phases", record.get("phases"));
			r.put("startTime", record.get("startTime"));
			r.put("endTime", record.get("endTime"));
			r.put("intro", record.get("intro"));
			
			//获取专项能力项目的学科,判断若不为空,则根据学科ID进行转换
			if(record.get("subjectIds") != null && !record.get("subjectIds").toString().equals("")) {
				String subjectNames = "";
				String subjectIds = record.get("subjectIds").toString();
				String []subjectIdsArr = subjectIds.split(",");
				for (String subjectId : subjectIdsArr) {
					if (subjectId!=null && !subjectId.equals("")) {
						//根据学科ID查询学科名称
						subjectNames += specialMapper.getSubjectNameById(subjectId)+" ";
					}
				}
				r.put("subject", subjectNames);
			}
			
			//获取专项能力项目的专家组信息,判断若不为空,则根据专家ID进行转换
			if(record.get("expertIds") != null && !record.get("expertIds").toString().equals("")) {
				List<Record> experts = new ArrayList<Record>();
				String expertIds = record.get("expertIds").toString();
				String []expertIdsArr = expertIds.split(",");
				for (String expertId : expertIdsArr) {
					if (expertId!=null && !expertId.equals("")) {
						//根据专家ID查询专家信息
						Record expertInfo = specialMapper.getExpertInfoById(expertId);
						experts.add(expertInfo);
					}
				}
				r.put("experts", experts);
			}

			//获取专项能力项目的教师组信息,判断若不为空,则根据教师ID进行转换
			if(record.get("teacherIds") != null && !record.get("teacherIds").toString().equals("")) {
				List<Record> teachers = new ArrayList<Record>();
				String teacherIds = record.get("teacherIds").toString();
				String []teacherIdsArr = teacherIds.split(",");
				for (String teacherId : teacherIdsArr) {
					if (teacherId!=null && !teacherId.equals("")) {
						//根据教师ID查询专家信息
						Record expertInfo = specialMapper.getExpertInfoById(teacherId);
						teachers.add(expertInfo);
					}
				}
				r.put("teachers", teachers);
			}
			
			//获取专项能力项目的远程项目信息,判断若不为空,则根据远程项目ID进行查询
			if(record.get("phase1NcmeProjectIds") != null && !record.get("phase1NcmeProjectIds").toString().equals("")) {
				List<Record> remotes = new ArrayList<Record>();
				String phase1NcmeProjectIds = record.get("phase1NcmeProjectIds").toString();
				String []phase1NcmeProjectIdsArr = phase1NcmeProjectIds.split(",");
				for (String phase1NcmeProjectId : phase1NcmeProjectIdsArr) {
					if(phase1NcmeProjectId!=null && !phase1NcmeProjectId.equals("")) {
						//根据专项项目阶段1包含的NCME项目ID查询项目信息
						Record Phase1NcmeProject = specialMapper.getPhase1NcmeProjectById(phase1NcmeProjectId);
						if (Phase1NcmeProject!=null) {
							//统计该项目被学习的次数
							List<LogStudyCvSet> logList = logStudyCvSetMapper.listLogStudyByCvSetId(null,(Integer)Phase1NcmeProject.get("projectId"));
							if (logList != null && logList.size()>0) {
								Phase1NcmeProject.put("learnNum", logList.size());
							} else {
								Phase1NcmeProject.put("learnNum", 0);
							}
						}
						remotes.add(Phase1NcmeProject);
					}
				}
				r.put("remote", remotes);
			}
			
			//获取专项能力项目的 面授项目 信息,判断若不为空,则根据 面授项目ID 进行查询
			if(record.get("phase2NcmeProjectIds") != null && !record.get("phase2NcmeProjectIds").toString().equals("")) {
				List<Record> faces = new ArrayList<Record>();
				String phase2NcmeProjectIds = record.get("phase2NcmeProjectIds").toString();
				String []phase2NcmeProjectIdsArr = phase2NcmeProjectIds.split(",");
				for (String phase2NcmeProjectId : phase2NcmeProjectIdsArr) {
					if(phase2NcmeProjectId!=null && !phase2NcmeProjectId.equals("")) {
						//根据专项项目阶段2包含的NCME项目ID查询项目信息
						Record Phase2NcmeProject = specialMapper.getPhase1NcmeProjectById(phase2NcmeProjectId);
						if (Phase2NcmeProject!=null) {
							//根据面授项目ID,统计 面授项目 的报名次数
							int no = 0;
							no = specialMapper.getLearnNumByProjectId((Integer)Phase2NcmeProject.get("projectId"));
							if (no > 0) {
								Phase2NcmeProject.put("learnNum", no);
							} else {
								Phase2NcmeProject.put("learnNum", 0);
							}
						}
						faces.add(Phase2NcmeProject);
					}
				}
				r.put("face", faces);
			}
			
			//获取专项能力项目的 临床实践项目 信息,判断若不为空,则根据 临床实践项目ID 进行查询
			if(record.get("phase3NcmeProjectIds") != null && !record.get("phase3NcmeProjectIds").toString().equals("")) {
				List<Record> practices = new ArrayList<Record>();
				String phase3NcmeProjectIds = record.get("phase3NcmeProjectIds").toString();
				String []phase3NcmeProjectIdsArr = phase3NcmeProjectIds.split(",");
				for (String phase3NcmeProjectId : phase3NcmeProjectIdsArr) {
					if(phase3NcmeProjectId!=null && !phase3NcmeProjectId.equals("")) {
						//根据专项项目阶段3包含的NCME项目ID查询项目信息
						Record Phase3NcmeProject = specialMapper.getPhase1NcmeProjectById(phase3NcmeProjectId);
						if (Phase3NcmeProject!=null) {
							//根据 临床实践项目ID,统计 临床实践项目 的报名次数
							int no = 0;
							no = specialMapper.getLearnNumByProjectId((Integer)Phase3NcmeProject.get("projectId"));
							if (no > 0) {
								Phase3NcmeProject.put("learnNum", no);
							} else {
								Phase3NcmeProject.put("learnNum", 0);
							}
						}
						practices.add(Phase3NcmeProject);
					}
				}
				r.put("practice", practices);
			}
		}
		return r;
		
	}

	

}
