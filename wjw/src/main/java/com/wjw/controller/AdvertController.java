package com.wjw.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.model.Advert;
import com.wjw.service.AdvertService;

/**
 * 
 * ClassName:AdvertController
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xuehong
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月1日	下午2:05:05
 *
 * @see 	 
 *
 */
@RestController
@RequestMapping("/banner")
public class AdvertController extends Controller{
	@Autowired
	AdvertService advertService;
	
	/**
	 * 
	 * getBannerList:(这里用一句话描述这个方法的作用)
	 * TODO(获取APP首页Banner)
	 *
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping(value="/getBannerList")
	@ResponseBody
	public RtnBody getBannerList(){
		RtnBody rtn = new RtnBody();
		log.info("{} query begin!","List");
		//查询首页banner
		List<Advert> ad = advertService.getBannerList();
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(ad);
	}
	
	
}
