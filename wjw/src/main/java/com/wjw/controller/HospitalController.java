/**
 * HospitalController.java
 * com.wjw.controller
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月13日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.StrKit;
import com.wjw.service.HospitalService;

/**
 * ClassName:HospitalController
 * Function: TODO 医院信息控制器
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月13日	下午1:54:57
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController extends Controller{
	
	/**
	 * hospitalService:TODO 医院服务
	 *
	 * @since version 1.0
	 */
	@Autowired
	HospitalService hospitalService;
	
	/**
	 * getHospitalByArea:根据地区，关键字获取医院
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param keyWord
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/getHospitalByArea")
	public RtnBody getHospitalByArea(String keyWord){
		
		String countyId = getPara("countyId");
		
		if(StrKit.isBlank(countyId)){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("params must be not empty.");
		}
		List<Record> list = hospitalService.getHospitalByArea(countyId,keyWord);
		
		//Record  record = new Record();
		//默认最后加一个其他选项，id定为 0
		//record.put("hospitalid", 0);
		//record.put("hospitalName", "其它");
		//list.add(record);
		
		return  getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success").data(list);
		
	}

}
