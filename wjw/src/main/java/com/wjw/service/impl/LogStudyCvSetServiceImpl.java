package com.wjw.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.util.DateUtil;
import com.ncme.springboot.mapper.CvMapper;
import com.ncme.springboot.mapper.CvUnitMapper;
import com.ncme.springboot.mapper.LogStudyCvMapper;
import com.ncme.springboot.mapper.LogStudyCvSetMapper;
import com.ncme.springboot.mapper.LogStudyCvUnitMapper;
import com.ncme.springboot.mapper.LogStudyCvUnitVideoCensusMapper;
import com.ncme.springboot.mapper.LogStudyCvUnitVideoMapper;
import com.ncme.springboot.model.Cv;
import com.ncme.springboot.model.CvUnit;
import com.ncme.springboot.model.LogStudyCv;
import com.ncme.springboot.model.LogStudyCvSet;
import com.ncme.springboot.model.LogStudyCvUnit;
import com.ncme.springboot.model.LogStudyCvUnitVideo;
import com.ncme.springboot.model.LogStudyCvUnitVideoCensus;
import com.wjw.service.LogStudyCvSetService;

@Service
public class LogStudyCvSetServiceImpl implements LogStudyCvSetService {

	@Autowired
	LogStudyCvSetMapper logStudyCvSetMapper;
	@Autowired
	CvMapper cvMapper;
	@Autowired
	CvUnitMapper cvUnitMapper;
	@Autowired
	LogStudyCvMapper logStudyCvMapper;
	@Autowired
	LogStudyCvUnitMapper logStudyCvUnitMapper;
	@Autowired
	LogStudyCvUnitVideoMapper logStudyCvUnitVideoMapper;
	@Autowired
	LogStudyCvUnitVideoCensusMapper logStudyCvUnitVideoCensusMapper;
	@Override
	public List<LogStudyCvSet> listLogStudyByCvSetId(Integer userId, Integer cvSetId) {

		return logStudyCvSetMapper.listLogStudyByCvSetId(userId, cvSetId);

	}
	@Override
	public int updateLogStudyCvSetById(LogStudyCvSet logStudyCvSet) {
		
		return logStudyCvSetMapper.updateByPrimaryKeySelective(logStudyCvSet);
		
	}

	@Override
	@Transactional
	public void updateCvForLogStudy(Integer userId, Integer cvSetId, Integer cvId) {
		//根据课程id查询课程信息
		Cv cv =cvMapper.selectByPrimaryKey(cvId);
		//根据用户id和课程id查询课程学习记录表
		LogStudyCv logStudyCv = logStudyCvMapper.getLogStudyCvByUserIdAndCvId(userId, cvId);
		boolean flag = false;//是否已学完标志
		if (cv.getCvType() == 2) {//当该课程为直播时
			//如果为直播课程则直播、回放、点播中有一个达标其它都达标，即该课程已学完
			//直播--0:直播单元  1:回放单元   2:点播单元
			for (int unitMakeType=0;unitMakeType<=2;unitMakeType++) {
				//课程下总的任务点单元数量
				Integer totalCount = cvUnitMapper.getPointsByCvId(cvId, unitMakeType);
				//会员已学过的任务点单元数量
				Integer studyCount = cvUnitMapper.getCompletePointsByUIdAndCvId(userId, cvId, unitMakeType);
				if (totalCount != null && studyCount != null && totalCount == studyCount) {
					flag = true;
					break;
				}
			}
		} else {//当课程为直播时
			//课程下总的任务点单元数量
			Integer totalCount = cvUnitMapper.getPointsByCvId(cvId, null);
			//会员已学过的任务点单元数量
			Integer studyCount = cvUnitMapper.getCompletePointsByUIdAndCvId(userId, cvId, null);
			if (totalCount != null && studyCount != null && totalCount == studyCount) {
				flag = true;
			}
		}
		LogStudyCv log = new LogStudyCv();
		log.setCvId(cvId);
		log.setCvSetId(cvSetId);
		
		log.setLastUpdateDate(DateUtil.parse(new Date(), DateUtil.FORMAT_LONG));
		if (flag) {
			log.setState(BusinessConst.STUDY_HAVE_LEARN);
		} else {
			log.setState(BusinessConst.STUDY_NOT_LEARND);
		}
		//如果该课程学习记录存在则更新，否则进行插入操作
		if (logStudyCv != null) {
			log.setId(logStudyCv.getId());
			logStudyCvMapper.updateByPrimaryKeySelective(log);
			//logStudyCvMapper.updateByPrimaryKey(log);
		} else {
			log.setSystemUserId(userId);
			logStudyCvMapper.insert(log);
		}
	}
	@Override
	@Transactional
	public void updateCVSetForLogStudy(Integer userId, Integer cvSetId, Integer cvId) {
		//根据用户id和项目id查询项目学习记录
		List<LogStudyCvSet> logStudyList = logStudyCvSetMapper.listLogStudyByCvSetId(userId, cvSetId);
		//项目总课程数
		Integer totalCount = cvMapper.getCvCountByCvSetId(cvSetId);
		//项目下已完成的课程数量
		Integer studyCount = cvMapper.getCompleteCvCountByUIdAndCvSetId(userId, cvSetId);
		//如果该项目学习记录存在则更新，否则进行插入操作
		if (logStudyList != null && logStudyList.size()>0) {
			LogStudyCvSet logStudy = logStudyList.get(0);
			LogStudyCvSet log = new LogStudyCvSet();
			log.setId(logStudy.getId());
			if (totalCount != null && studyCount != null && totalCount == studyCount) {
				log.setState(BusinessConst.STUDY_HAVE_LEARN);
			} else {
				log.setState(BusinessConst.STUDY_NOT_LEARND);
			}
			logStudyCvSetMapper.updateByPrimaryKeySelective(log);
			//logStudyCvSetMapper.updateByPrimaryKey(logStudy);
		} else {
			LogStudyCvSet log = new LogStudyCvSet();
			log.setCvSetId(cvSetId);
			log.setSystemUserId(userId);
			log.setIsApplyCredit(1);
			log.setSiteId(1);
			log.setLastUpdateDate(DateUtil.parse(new Date(), DateUtil.FORMAT_LONG));
			if (totalCount != null && studyCount != null && totalCount == studyCount) {
				log.setState(BusinessConst.STUDY_HAVE_LEARN);
			} else {
				log.setState(BusinessConst.STUDY_NOT_LEARND);
			}
			logStudyCvSetMapper.insert(log);
		}
	}
	@Override
	@Transactional
	public void updateCvUnitForLogStudy(Integer userId, Integer cvSetId, Integer cvId, Integer unitId) {
		//根据单元id和用户id查询单元学习记录
		LogStudyCvUnit logStudyCvUnit = logStudyCvUnitMapper.getLogStudyByUnitIdAndUserId(userId, unitId);
		//如果该单元学习记录存在则更新，否则进行插入操作
		if (logStudyCvUnit != null) {
			LogStudyCvUnit log = new LogStudyCvUnit();
			log.setId(logStudyCvUnit.getId());
			log.setLastUpdateDate(new Date());
			logStudyCvUnitMapper.updateByPrimaryKeySelective(log);
		} else {
			LogStudyCvUnit log = new LogStudyCvUnit();
			log.setCvId(cvId);
			log.setCvUnitId(unitId);
			log.setLogStudyCvSetId(cvSetId);
			log.setStatus(1);
			log.setSystemUserId(userId);
			log.setLastUpdateDate(new Date());
			logStudyCvUnitMapper.insert(log);
		}
		
	}
	@Override
	@Transactional
	public void saveOrUpdateLogStudyCvUnitVideo(LogStudyCvUnitVideo video) {
		//根据用户id和单元id查询单元视频学习记录
		LogStudyCvUnitVideo log = logStudyCvUnitVideoMapper.getVideoLogByUserIdAndUnitId(video.getSystemUserId(), video.getCvUnitId());
		int logNum = 0;
		int videoLength = video.getVideolength();
		int videoPlayLength = video.getVideoplaylength();
		//如果该视频单元学习记录存在则更新，否则进行插入操作
		if (log != null) {
			log.setVideolength(videoLength);
			log.setVideoplaylength(videoPlayLength);
			log.setEndDate(new Date());
			log.setCvUnitId(null);
			//log.setSystemUserId(null);
			logNum = logStudyCvUnitVideoMapper.updateByPrimaryKeySelective(log);
			//logNum = logStudyCvUnitVideoMapper.updateByPrimaryKey(log);
		} else {
			if (video.getStartDate() == null) {
				video.setStartDate(new Date());
			}
			video.setEndDate(new Date());
			logNum = logStudyCvUnitVideoMapper.insert(video);
		}
		//判断学习单元是否达标
		boolean unitIsPass = false ;
		if (logNum > 0 && videoLength != 0) {
			Double playStep =  (100d * videoPlayLength) / videoLength ;
			CvUnit cvUnit = cvUnitMapper.selectByPrimaryKey(video.getCvUnitId());
			if (cvUnit != null) {
				Integer point = cvUnit.getPoint();
				if (point != null && point == 1) {
					Double unitQuota = cvUnit.getQuota() ;
        			if (unitQuota != null) {
        				if (playStep >= unitQuota) {
        					unitIsPass = true ;
        				}
        			} else {
        				unitIsPass = true ;
        			}
				} else {
					unitIsPass = true;
				}
			}
		}
		//如果学习单元达标，则更新单元学习记录表的状态为已完成
		if (unitIsPass) {
			LogStudyCvUnit cvUnitLog = new LogStudyCvUnit();
			cvUnitLog.setStatus(BusinessConst.STUDY_HAVE_LEARN);
			cvUnitLog.setId(video.getLogStudyCvUnitId());
			logStudyCvUnitMapper.updateByPrimaryKeySelective(cvUnitLog);
		}
	}
	@Override
	public void saveLogStudyCvUnitVideoCensus(LogStudyCvUnitVideoCensus videoCensus) {
		
		logStudyCvUnitVideoCensusMapper.insert(videoCensus);
		
	}
}
