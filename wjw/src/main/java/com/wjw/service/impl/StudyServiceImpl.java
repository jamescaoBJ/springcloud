package com.wjw.service.impl;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.mapper.CvDiplomaMapper;
import com.ncme.springboot.mapper.CvMapper;
import com.ncme.springboot.mapper.CvSetMapper;
import com.ncme.springboot.mapper.CvUnitMapper;
import com.ncme.springboot.mapper.LogStudyCvSetMapper;
import com.ncme.springboot.mapper.LogStudyCvUnitVideoCensusMapper;
import com.ncme.springboot.model.CvSet;
import com.wjw.service.StudyService;

@Service
public class StudyServiceImpl implements StudyService {

	@Autowired
	LogStudyCvSetMapper logStudyCvSetMapper;
	@Autowired
	LogStudyCvUnitVideoCensusMapper videoCensusMapper;
	@Autowired
	CvDiplomaMapper cvDiplomaMapper;
	@Autowired
	CvSetMapper cvSetMapper;
	@Autowired
	CvUnitMapper cvUnitMapper;
	@Autowired
	CvMapper cvMapper;
	
	
	@Override
	public Record annualReport(Integer userId, Integer year, String domainName) {
		Record record = new Record();
		record.put("studyPresentation", year+"/01/01~"+year+"/12/31");
		//获取年度学习报告完成项目数量
		Integer completeNum = logStudyCvSetMapper.getCompletedCvSetNum(userId, year, domainName);
		record.put("completeNum", completeNum);
		//获取年度学习报告学习总时长
		Integer studyLength = videoCensusMapper.getStudyLengthByUserId(userId, year, null);
		int studyMinutes = 0;
		if (studyLength != null) {
			studyMinutes = studyLength/60;
		}
		record.put("studyMinutes", studyMinutes+"'");
		//获取年度学习报告获得学分
		Double score = 0.0;
		Double learnScore = cvDiplomaMapper.getScoreByUserId(userId,year);
		if (learnScore != null) {
			score = learnScore;
		}
		record.put("studyScore", score);
		return record;

	}


	@Override
	public PageInfo<Record> annualProjectReport(Integer userId, Integer year, String pageNum, String pageSize) {
		
		List<Record> list = cvSetMapper.annualProjectReport(userId, year);
		PageInfo<Record> page;
		if (pageNum!=null) {
			if (list.size() > Integer.parseInt(pageNum)*Integer.parseInt(pageSize)) {
				page = new PageInfo<Record>(list.subList((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageNum)*Integer.parseInt(pageSize)));
			} else {
				page = new PageInfo<Record>(list.subList((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), list.size()));
			}
				
			if (list.size() > Integer.parseInt(pageNum)*Integer.parseInt(pageSize)) {
				page.setIsLastPage(false);
			} else {
				page.setIsLastPage(true);
			}
			page.setTotal(list.size());
			return page;
		} else {
			if (list.size() > Integer.parseInt(pageNum)*Integer.parseInt(pageSize)) {
				page = new PageInfo<Record>(list.subList((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageNum)*Integer.parseInt(pageSize)));
			} else {
				page = new PageInfo<Record>(list.subList((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), list.size()));
			}
				
			if (list.size() > Integer.parseInt(pageNum)*Integer.parseInt(pageSize)) {
				page.setIsLastPage(false);
			} else {
				page.setIsLastPage(true);
			}
			page.setTotal(list.size());
			return page;
		}
		
	}


	@Override
	public Record reportDetail(Integer userId, Integer projectId) {
		Record record = new Record();
		CvSet cvSet = cvSetMapper.selectByPrimaryKey(projectId);
		record.put("name", cvSet.getName());
		//总任务点
		int points = cvUnitMapper.countPoints(projectId,1);
		//已完成的任务点
		int completePoints = cvUnitMapper.completedLogUnits(userId, projectId,1);
		//计算学习进度
		double progress = 0.0;
		if (points != 0 && completePoints != 0) {
			progress = (completePoints*1.0/points)*100;
			DecimalFormat df = new DecimalFormat("#.0");
			String pro = df.format(progress);
			record.put("learnProgress", pro+"%");
		} else if (points == 0) {
			int unitCount = cvUnitMapper.countPoints(projectId, 0);
			int comUnitCount = cvUnitMapper.completedLogUnits(userId, projectId, 0);
			progress = (comUnitCount*1.0/unitCount)*100;
			DecimalFormat df = new DecimalFormat("#.0");
			String pro = df.format(progress);
			record.put("learnProgress", pro+"%");
		}  else {
			progress = 0;
			record.put("learnProgress", progress+"%");
		}
		record.put("learnTask", completePoints+"/"+points);
		//获取学习报告学习总时长
		Integer studyLength = videoCensusMapper.getStudyLengthByUserId(userId, null, projectId);
		int studyMinutes = 0;
		int second = 0;
		if (studyLength != null) {
			studyMinutes = studyLength/60;
			second = studyLength%60;
		}
		record.put("learnCost", studyMinutes+"'"+second);
		//根据项目id查询该项目的所有课程数量
		int cvCount = cvMapper.getCvCountByCvSetId(projectId);
		//项目下已完成的课程数量
		int completedCv = cvMapper.getCompleteCvCountByUIdAndCvSetId(userId, projectId);
		record.put("learnNum", completedCv+"/"+cvCount);
		//项目总讨论数
		List<Record> discussList = cvSetMapper.projectDiscuss(projectId);
		record.put("myDiscuss", discussList.size());
		//项目总笔记数
		List<Record> noteList = cvSetMapper.projectNote(userId,projectId.toString());
		record.put("myNote", noteList.size());
		return record;
		
	}


	@Override
	public List<Record> studyTime(Integer userId, Integer projectId, Integer year, Integer month) {
		
		List<Record> studyList = videoCensusMapper.studyTime(userId, projectId, year, month);
		return studyList;
		
	}

}
