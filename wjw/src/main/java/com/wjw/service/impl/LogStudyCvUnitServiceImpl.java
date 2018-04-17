package com.wjw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.mapper.CvUnitMapper;
import com.ncme.springboot.mapper.LogStudyCvUnitMapper;
import com.ncme.springboot.model.LogStudyCvUnit;
import com.wjw.service.LogStudyCvUnitService;

@Service
public class LogStudyCvUnitServiceImpl implements LogStudyCvUnitService {

	@Autowired
	CvUnitMapper cvUnitMapper;
	@Autowired
	LogStudyCvUnitMapper logStudyCvUnitMapper;
	@Override
	public Record getCVUnitLogStudyByUnitIdAndUserId(Integer userId, Integer unitId) {
		return cvUnitMapper.getCVUnitLogStudyByUnitIdAndUserId(userId, unitId);

	}
	@Override
	public int updateCvUnitLogStudyByUserIdAndUnitId(LogStudyCvUnit logStudyCvUnit) {
		
		return logStudyCvUnitMapper.updateStatusByUserIdAndUnitId(logStudyCvUnit);
		
	}
	@Override
	public LogStudyCvUnit getLogStudyByUnitIdAndUserId(Integer userId, Integer unitId) {
		
		return logStudyCvUnitMapper.getLogStudyByUnitIdAndUserId(userId, unitId);
		
	}

}
