package com.wjw.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.DateUtil;
import com.ncme.springboot.mapper.CvDiplomaMapper;
import com.ncme.springboot.mapper.CvSetMapper;
import com.ncme.springboot.mapper.LogStudyCvUnitMapper;
import com.ncme.springboot.model.CvDiploma;
import com.ncme.springboot.model.CvSet;
import com.ncme.springboot.model.LogStudyCvUnit;
import com.wjw.service.CvDiplomaService;

@Service
public class CvDiplomaServiceImpl implements CvDiplomaService {

	@Autowired
	CvDiplomaMapper cvDiplomaMapper;
	@Autowired
	LogStudyCvUnitMapper logStudyCvUnitMapper;
	@Autowired
	CvSetMapper cvSetMapper;
	@Override
	public int saveCvDiploma(CvDiploma cvDiploma) {
		return cvDiplomaMapper.insert(cvDiploma);
	}
	@Override
	public Record getCvDiplomaByUserIdAndCode(Integer userId, Integer cvSetId, String itemNumber, Integer provinceId, String domainName) {
		
		Record record = cvDiplomaMapper.getCvDiplomaByUserIdAndCode(userId, itemNumber);
		if (record != null) {
			String applyTime = (String)record.get("applyTime");
			record.put("applyTime", DateUtil.format(DateUtil.parse(applyTime, "yyyy-MM-dd"), "yyyy年MM月dd日"));
			record.put("applyUnit", "国家继续医学教育网");
			List<LogStudyCvUnit> logList = logStudyCvUnitMapper.queryLogStudyCVUnitByCvSetId(userId, cvSetId);
			if (logList != null && logList.size() > 0) {
				Date beginTime = logList.get(logList.size()-1).getLastUpdateDate();
				Date endTime = logList.get(0).getLastUpdateDate();
				record.put("beginTime", DateUtil.format(beginTime, "yyyy年MM月dd日"));
				record.put("endTime", DateUtil.format(endTime, "yyyy年MM月dd日"));
			}
			CvSet cvSet = cvSetMapper.getCvSetById(cvSetId, provinceId, domainName);
			if (cvSet != null) {
				record.put("itemNumber", cvSet.getSerialNumber());
				Integer forma = cvSet.getForma();
				if (forma == 3) {
					record.put("itemType", "面授培训班");
				} else {
					record.put("itemType", "远程教育");
				}
			}
		}
		
		return record;
	}

}
