package com.wjw.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.mapper.CvSetScoreLogMapper;
import com.ncme.springboot.mapper.CvSetScoreMapper;
import com.ncme.springboot.model.CvSetScore;
import com.ncme.springboot.model.CvSetScoreLog;
import com.wjw.service.CvSetScoreService;

@Service
public class CvSetScoreServiceImpl implements CvSetScoreService {

	@Autowired
	CvSetScoreMapper cvSetScoreMapper;
	@Autowired
	CvSetScoreLogMapper cvSetScoreLogMapper;
	@Override
	public CvSetScore getScoreByCvSetId(Integer cvSetId) {
		
		return cvSetScoreMapper.selectByPrimaryKey(cvSetId);
		
	}

	@Override
	public PageInfo<Record> listScoreLogByCvSetId(Integer cvSetId, String pageNum, String pageSize) {
		
		PageHelper.startPage(StrKit.str2Int(pageNum), StrKit.str2Int(pageSize));
		List<Record> scoreLogList = cvSetScoreLogMapper.listScoreLogByCvSetId(cvSetId);
		PageInfo<Record> page = new PageInfo<Record>(scoreLogList);
		return page;
		
	}

	@Override
	public void insert( Integer projectId,Integer userId, BigDecimal score1, BigDecimal score2, BigDecimal score3, BigDecimal score4,
			Date scoreDate,String scoreContent) {
			cvSetScoreLogMapper.insert( projectId,userId, score1, score2, score3, score4,scoreDate ,scoreContent);
		}
		
	}

