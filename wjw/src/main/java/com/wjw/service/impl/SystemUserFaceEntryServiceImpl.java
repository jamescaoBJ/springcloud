/**
 * 2018年1月10日 上午11:58:45
 * @author 王印涛
 * SystemUserFaceEntryServiceImpl.java
 */
package com.wjw.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.mapper.CvMapper;
import com.ncme.springboot.mapper.CvSetMapper;
import com.ncme.springboot.mapper.CvSetScheduleFaceteachMapper;
import com.ncme.springboot.mapper.ExpertInfoMapper;
import com.ncme.springboot.mapper.LogStudyCvSetMapper;
import com.ncme.springboot.mapper.PeixunOrgMapper;
import com.ncme.springboot.mapper.SystemUserFaceEntryMapper;
import com.ncme.springboot.model.Cv;
import com.ncme.springboot.model.CvSet;
import com.ncme.springboot.model.LogStudyCvSet;
import com.ncme.springboot.model.PeixunOrg;
import com.ncme.springboot.model.SystemUserFaceEntry;
import com.wjw.service.SystemUserFaceEntryService;

/**
 * @author 王印涛
 * SystemUserFaceEntryServiceImpl.java
 * 2018年1月10日 上午11:58:45
 */
@Service
public class SystemUserFaceEntryServiceImpl implements SystemUserFaceEntryService{

	@Autowired
	SystemUserFaceEntryMapper systemUserFaceEntryMapper;
	
	@Autowired
	LogStudyCvSetMapper logStudyCvSetMapper;
	
	@Autowired
	CvSetScheduleFaceteachMapper cvSetScheduleFaceteachMapper;
	
	@Autowired
	CvSetMapper cvSetMapper;
	
	@Autowired
	ExpertInfoMapper expertInfoMapper;
	
	@Autowired
	PeixunOrgMapper peixunOrgMapper;
	
	@Autowired
	CvMapper cvMapper;

	/**
	 * @author 王印涛
	 * 2018年1月10日 下午1:14:54
	 * @Description 获取面授报名信息
	 */
	@Override
	public Record getFaceInfo(Map<String,Object> map) {

		return systemUserFaceEntryMapper.getFaceInfo(map);
	}

	/**
	 * @author 王印涛
	 * 2018年1月11日 上午11:16:11
	 * @Description 面授报名
	 */
	@Override
	public void signUp(Integer userId, Integer cvSetId, Integer fid) {
        //保存面授报名表
		Date now = new Date();
		SystemUserFaceEntry faceEntry = new SystemUserFaceEntry();
		faceEntry.setFid(fid);
		faceEntry.setUserId(userId);
		faceEntry.setEntryTime(now);
		systemUserFaceEntryMapper.insert(faceEntry);
		//保存项目学习表
		LogStudyCvSet logStudy = new LogStudyCvSet();
		logStudy.setCvSetId(cvSetId);
		logStudy.setApplyDate(now);
		logStudy.setLastUpdateDate(now);
		logStudy.setState(1);
		logStudy.setSystemUserId(userId);
		logStudy.setIsApplyCredit(1);//1:未申请学分 2:已申请
		logStudy.setSiteId(1);
		logStudyCvSetMapper.insertSelective(logStudy);
	}

	/**
	 * @author 王印涛
	 * 2018年1月11日 下午1:14:08
	 * @Description 是否报名
	 */
	@Override
	public Map<String, Object> isSignUp(Map<String, Object> map) {
		SystemUserFaceEntry signUp = systemUserFaceEntryMapper.isSignUp(map);
		Map<String, Object> record = new  HashMap<String, Object>();
		int up = 0;
		if (signUp !=null ) {
			up =1;
		}
		record.put("isSignUp", up);
		return record;
	}

	/**
	 * @author 王印涛
	 * 2018年1月11日 下午2:42:49
	 * @Description 专项能力根据期数查询信息
	 */
	@Override
	public Record getFaceTeachById(Map<String, Object> map) {
		
		return cvSetScheduleFaceteachMapper.getFaceTeachById(map);
	}

	/**
	 * @author 王印涛
	 * 2018年1月11日 下午4:35:37
	 * @Description 专项能力面授项目详情
	 */
	@Override
	public Record getFaceProDetailById(Integer userId, Integer cvSetId) {
		Record record = new Record();
		//根据项目ID查找项目编码 
		CvSet cvset = cvSetMapper.selectByPrimaryKey(cvSetId);
		record.put("code", cvset.getCode());
		//根据项目id查询项目负责人
		List<Record> perList = expertInfoMapper.listExpertByCvSetId(cvSetId, 1);
		record.put("expertName", perList.get(0).get("expertName"));
		//根据项目id获取项目所属机构
		PeixunOrg  org = peixunOrgMapper.getOrg(cvSetId);
		record.put("organization", org.getName());
		//根据项目id查询授课老师
		List<Record> teacherList = expertInfoMapper.listExpertByCvSetId(cvSetId, 2);
		record.put("teachers", teacherList);
		//根据项目ID获取面授项目期数
		List<Record> faceList = cvSetScheduleFaceteachMapper.faceTeachList(cvSetId);
		record.put("faceList", faceList);
		//根据项目ID获取课程信息
		List<Cv> cvList = cvMapper.mySelectCvByCvsetId(String.valueOf(cvSetId),userId);
		record.put("cvList", cvList);
		return record;
	}

}
