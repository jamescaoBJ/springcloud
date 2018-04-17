package com.wjw.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.mapper.SystemCardMapper;
import com.ncme.springboot.mapper.SystemCardSetOrderMapper;
import com.ncme.springboot.mapper.SystemCardTypeCvSetMapper;
import com.ncme.springboot.mapper.SystemCardUserMapper;
import com.ncme.springboot.model.SystemCard;
import com.ncme.springboot.model.SystemCardSetOrder;
import com.ncme.springboot.model.SystemCardTypeCvSet;
import com.ncme.springboot.model.SystemCardUser;
import com.wjw.service.SystemCardService;

@Service
public class SystemCardServiceImpl implements SystemCardService {

	@Autowired
	SystemCardMapper systemCardMapper;
	@Autowired
	SystemCardTypeCvSetMapper cardTypeCvSetMapper;
	@Autowired
	SystemCardSetOrderMapper cardSetOrderMapper;
	@Autowired
	SystemCardUserMapper cardUserMapper;
	@Override
	public SystemCard getSystemCardByNumAndPwd(String cardNumber, String cardPassword) {
		
		return systemCardMapper.getSystemCardByNumAndPwd(cardNumber, cardPassword);
	}
	@Override
	public SystemCard getSystemCardByNumAndCvSetId(String cardNumber, Integer cvSetId) {
		
		return systemCardMapper.getSystemCardByNumAndCvSetId(cardNumber, cvSetId);
	}
	@Override
	public List<SystemCardTypeCvSet> findCvSetListByCardType(Integer cardType) {
		
		return cardTypeCvSetMapper.findCvSetListByCardType(cardType);
	}
	@Override
	public List<SystemCardSetOrder> findByUidProid(Map map) {
		
		return cardSetOrderMapper.findByUidProid(map);
		
	}
	@Override
	public int saveSystemCardSetOrder(SystemCardSetOrder order) {
		
		return cardSetOrderMapper.insert(order);
		
	}
	@Override
	public int saveBindUserinfor(SystemCardUser systemCardUser) {
		
		return cardUserMapper.insert(systemCardUser);
		
	}
	@Override
	public int updateSystemCard(SystemCard systemCard) {
		
		return systemCardMapper.updateByPrimaryKey(systemCard);
		
	}

}
