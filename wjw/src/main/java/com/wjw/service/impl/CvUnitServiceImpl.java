package com.wjw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.mapper.CvUnitMapper;
import com.ncme.springboot.model.CvUnit;
import com.wjw.service.CvUnitService;

@Service
public class CvUnitServiceImpl implements CvUnitService {

	@Autowired
	CvUnitMapper cvUnitMapper;
	@Override
	public CvUnit getCvUnitById(Integer unitId) {

		return cvUnitMapper.selectByPrimaryKey(unitId);

	}

}
