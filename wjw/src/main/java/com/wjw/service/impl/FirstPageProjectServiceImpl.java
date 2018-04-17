/**
 * FirstPageProjectServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月2日                   xh
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.mapper.CvSetMapper;
import com.ncme.springboot.mapper.LogStudyCvSetMapper;
import com.ncme.springboot.model.LogStudyCvSet;
import com.wjw.service.FirstPageProjectService;

/**
 * ClassName:FirstPageProjectServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月2日	下午3:45:02
 *
 * @see 	 
 *  
 */
@Service
public class FirstPageProjectServiceImpl implements FirstPageProjectService {
	@Autowired
	CvSetMapper cvSetMapper;
	@Autowired
	LogStudyCvSetMapper logStudyCvSetMapper;
	
	@Override
	public List<Record> getReCommendProjectList(Map<String,Object> map) {
		List<Record> cvSetList = cvSetMapper.getReCommendProjectList(map);
		
		//根据项目id查询该项目的学习次数，并将学习次数set到返回的对象里
		for (Record r:cvSetList) {
			if (r != null && r.get("type").toString().equals("1")) {
				List<LogStudyCvSet> logList = logStudyCvSetMapper.listLogStudyByCvSetId(null,(Integer)r.get("cvSetId"));
				if (logList != null && logList.size()>0) {
					r.put("learnNum", logList.size());
				} else {
					r.put("learnNum", 0);
				}
			} else {
				r.put("learnNum", 0);
			}
			if (r != null && r.get("type").toString().equals("2")) {
				if (r.get("level") != null) {
					switch (Integer.parseInt(r.get("level").toString())) {
					case 1:
						r.put("level", "院长");							//设置职务类型名称
						break;
					case 2:
						r.put("level", "副院长");
						break;
					case 8:
						r.put("level", "校长");
						break;
					case 9:
						r.put("level", "副校长");
						break;
					case 10:
						r.put("level", "书记");
						break;
					case 11:
						r.put("level", "副书记");
						break;
					case 12:
						r.put("level", "处长");
						break;
					case 13:
						r.put("level", "副处长");
						break;
					case 5:
						r.put("level", "所长");
						break;
					case 6:
						r.put("level", "副所长");
						break;
					case 14:
						r.put("level", "科长");
						break;
					case 15:
						r.put("level", "副科长");
						break;
					case 3:
						r.put("level", "主任");
						break;
					case 4:
						r.put("level", "副主任");
						break;
					case 7:
						r.put("level", "护士长");
						break;
					case 16:
						r.put("level", "副护士长");
						break;
					case 17:
						r.put("level", "秘书");
						break;
					default:
						r.put("level", "请选择");
						break;
					}
				} else {
					r.put("level", "请选择");
				}
			}
		}
		return cvSetList;

	}

}
