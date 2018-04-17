/**
 * CardServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月13日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.mapper.LogStudyCvUnitMapper;
import com.ncme.springboot.mapper.SystemCardSetOrderMapper;
import com.ncme.springboot.model.LogStudyCvUnit;
import com.wjw.service.CardService;

/**
 * ClassName:CardServiceImpl
 * Function: TODO ADD 学习卡服务类
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月13日	下午5:17:22
 *
 * @see 	 
 *  
 */
@Service
public class CardServiceImpl implements CardService{

	@Autowired
	SystemCardSetOrderMapper systemCardSetOrderMapper; //学习卡mapper
	@Autowired
	LogStudyCvUnitMapper logStudyCvUnitMapper;
	/**
	 * 学习卡管理列表
	 * @see com.wjw.service.CardService#cardList(java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<Record> cardList(String status, Integer id) {
		
		// TODO Auto-generated method stub
		return systemCardSetOrderMapper.cardList(status,id);
		
	}
	
	/**
	 * 学习卡详情
	 * @see com.wjw.service.CardService#cardDetails(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Record cardDetails(Integer userId,String cardType, String cardNumber) {
		
		Record card = systemCardSetOrderMapper.cardDetails(userId,cardType,cardNumber);
		List<Record> detailList = (List<Record>)card.get("list");
		if (detailList != null) {
			for (Record r:detailList) {
				Integer cvSetId = (Integer)r.get("projectId");
				List<LogStudyCvUnit> list = logStudyCvUnitMapper.queryLogStudyCVUnitByCvSetId(userId, cvSetId);
				if (list != null && list.size()>0) {
					r.put("projectIsLearn", 1);
					r.put("projectStudyTime", list.get(list.size()-1).getLastUpdateDate());
				} else {
					r.put("projectIsLearn", 0);
					r.put("projectStudyTime", "");
				}
			}
		}
		return card;
		
	}

}
