package com.wjw.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.mapper.WeiXinMapper;
import com.wjw.service.WeiXinService;
@Service
public class WeiXinServiceImpl implements WeiXinService {

	@Autowired
	WeiXinMapper weiXinMapper;

	
	@Override
	public PageInfo<Record> selectSpeciaByPage(String userId, String pageCurrent, String pageSize) {
		PageHelper.startPage(StrKit.str2Int(pageCurrent), StrKit.str2Int(pageSize));
		List<Record> list = new ArrayList<Record>();
		list =weiXinMapper.selectSpeciaByPage();
		if (list!=null && list.size()>0) {
			for (Record r : list) {
				if (userId != null && !userId.equals("")){
					Map<String,Object> map=new HashMap<String, Object>();
					map.put("userId", userId);
					map.put("cvSetId", Integer.parseInt(r.get("id").toString()));
					int no = weiXinMapper.isSignUp1(map);
					if (no > 0) {
						r.put("trainStatue", 1);
					} else {
						r.put("trainStatue", 0);
					}
				} else {
					r.put("trainStatue", 0);
				}
			}
		}
		PageInfo<Record> page = new PageInfo<Record>(list);
		return page;
	}

	@Override
	public Record getSpecialDetail(Map<String, Object> map) {
		return weiXinMapper.getSpecialDetail(map);
	}

	@Override
	public List<Record> getSpecialFaceteach(Map<String, Object> map) {
		return weiXinMapper.getSpecialFaceteach(map);
	}

	@Override
	public int isSignUp(Map<String, Object> map) {
		return weiXinMapper.isSignUp(map);
	}

	@Override
	public List<Record> getSpecialCourseList(Map<String, Object> map) {
		return weiXinMapper.getSpecialCourseList(map);
	}

	@Override
	public void saveSignUp(Map<String, Object> map) {
		weiXinMapper.saveSignUp(map);
	}

	@Override
	public Record getSignUp(Map<String, Object> map) {
		return weiXinMapper.getSignUp(map);
		
	}
	
	
	

}
