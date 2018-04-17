package com.wjw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.mapper.SystemMessageMapper;
import com.ncme.springboot.model.SystemMessage;
import com.wjw.service.SystemMessageService;

@Service
public class SystemMessageServiceImpl implements SystemMessageService {

	@Autowired
	SystemMessageMapper messageMapper;
	@Override
	public PageInfo<Record> getMessageList(Integer userId, String pageCurrent, String pageSize) {
		/* v1.1增加功能后,查询语句sql修改后不支持分布式sql查询,故注释掉框架自带的分页功能
		PageHelper.startPage(StrKit.str2Int(pageNum), StrKit.str2Int(pageSize));
		List<Record> list = messageMapper.getMessageList(userId);
		PageInfo<Record> page = new PageInfo<Record>(list);
		*/
		List<Record> list = messageMapper.getMessageList(userId);
		PageInfo<Record> page;
		if (pageCurrent!=null) {
			if (list.size() > Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)) {
				page = new PageInfo<Record>(list.subList((Integer.parseInt(pageCurrent)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)));
			} else {
				page = new PageInfo<Record>(list.subList((Integer.parseInt(pageCurrent)-1)*Integer.parseInt(pageSize), list.size()));
			}
				
			if (list.size() > Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)) {
				page.setIsLastPage(false);
			} else {
				page.setIsLastPage(true);
			}
			page.setTotal(list.size());
			return page;
		} else {
			if (list.size() > Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)) {
				page = new PageInfo<Record>(list.subList((Integer.parseInt(pageCurrent)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)));
			} else {
				page = new PageInfo<Record>(list.subList((Integer.parseInt(pageCurrent)-1)*Integer.parseInt(pageSize), list.size()));
			}
				
			if (list.size() > Integer.parseInt(pageCurrent)*Integer.parseInt(pageSize)) {
				page.setIsLastPage(false);
			} else {
				page.setIsLastPage(true);
			}
			page.setTotal(list.size());
			return page;
		}

	}
	
	@Override
	public void saveMessage(SystemMessage record) {
		messageMapper.insert(record);
	}

	@Override
	public int getNotReadCount(Integer userId) {
		
		return messageMapper.getNotReadCount(userId);
		
	}

	@Override
	public void markReadMessageByUserId(Integer userId, Integer isRead) {
		messageMapper.markReadMessageByUserId(userId, isRead);
		
	}

}
