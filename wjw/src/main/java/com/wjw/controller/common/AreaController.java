/**
 * ExamPropValController.java
 * com.wjw.controller.common
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月3日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.StrKit;
import com.wjw.service.AreaService;

/**
 * ClassName:ExamPropValController
 * Function: TODO 字典表控制器
 * Reason:	 TODO 由于wjw系统中字典牵扯面太广，又作为一个基础表，特放入common包中，后续的用户，角色等公共基础表也建议放在common中,牵扯到字典表mapper的，一律写在字典表中，集中管理方便
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月3日	下午4:31:40
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/area")
public class AreaController extends Controller {
	
	
	/**
	 * areaService:TODO 区域服务
	 *
	 * @since version 1.0
	 */
	@Autowired
	AreaService areaService;
	
	/**
	 * getProvince:获取省信息
	 * TODO 根据id获取
	 *
	 * @param  @param provinceId：省id
	 * @param  provinceName： 省名称   
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	@RequestMapping("/getProvince")  //暂时规定同时支持 get，post，delete，put等方法，后期根据业务调整
	public RtnBody getProvince(String provinceId,String provinceName){
		
		// provinceId ：省id ; provinceName : 省名称
		List<Record> areas =  areaService.getProvince(provinceId,provinceName); 
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success").data(areas);
	}
	
	/**
	 * getCityByProvinceId: 根据省id查询市区
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param ProvinceId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	@RequestMapping("/getCityByProvinceId") //根据省id获取市区信息，后续其他获得方式随着业务自然态增加
	public RtnBody getCityByProvinceId(String provinceId ){
		
		if(StrKit.isBlank(provinceId)){//params exception
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("provinceId must be is valid.");
		}
		
		List<Record> cities = areaService.getCityByProvinceId(provinceId);
		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success!").data(cities);
		
	}

	/**
	 * getCountyByCityId: 区县 信息
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param cityId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/getCountyByCityId") //和获取市区信息实质是一样的，后续商量是否合并？？@lyj
	public RtnBody getCountyByCityId(String cityId ){
		// cityId 市id
		if(StrKit.isBlank(cityId)){ //params exception
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("cityId must be is valid.");
		}
		
		List<Record> counties = areaService.getCountyByCityId(cityId);
		//返回区县数据
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success!").data(counties);
		
	}

	/**
	 * getProvinces:
	 * 新增：返回 省 市 区 
	 * @param  @param provinceId
	 * @param  @param provinceName
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/getProvinces")
	public RtnBody getProvinces(String provinceId,String provinceName){
		List <Map<String,Object>> map = new ArrayList<Map<String,Object>>();
		//获取省
		List<Record> plist = areaService.getProvince(provinceId,provinceName);
		if (plist!=null && plist.size()>0) {
			for (int i = 0; i < plist.size(); i++) {
				Map<String,Object> msmap = new HashMap<String,Object>();
				msmap.put("provinceId", plist.get(i).get("provinceId"));
				msmap.put("provinceName", plist.get(i).get("provinceName"));
				//获取市
				List<Record> clist = areaService.getCityByProvinceId(plist.get(i).get("provinceId").toString());
				List <Map<String,Object>> map2 = new ArrayList<Map<String,Object>>();
				if(clist!=null && clist.size()>0) {
					for (int j = 0; j < clist.size(); j++) {
						Map<String,Object> msmap1 = new HashMap<String,Object>();
						msmap1.put("cityId", clist.get(j).get("cityId"));
						msmap1.put("cityName", clist.get(j).get("cityName"));
						List<Record> rlist = areaService.getCountyByCityId(clist.get(j).get("cityId").toString());
						//获取区县
						if (rlist!=null && rlist.size()>0) {
							msmap1.put("children", rlist);
						}
						map2.add(msmap1);
					}
					msmap.put("children", map2);
				}
				map.add(msmap);
			}
		}  
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功").data(map);
	}
	
	
}
