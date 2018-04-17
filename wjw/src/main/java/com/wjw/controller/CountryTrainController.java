package com.wjw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.CvSet;
import com.ncme.springboot.model.SystemUser;
import com.ncme.springboot.model.SystemUserConfig;
import com.wjw.service.CvSetService;
import com.wjw.service.SystemUserService;
import com.wjw.util.SystemUserUtil;


/**
 * ClassName:CountryTrainController
 * Function: 乡医培训Controller
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月1日	下午2:05:30
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/country")
public class CountryTrainController extends Controller {

	@Autowired
	private CvSetService cvSetService;
	@Autowired
	SystemUserService systemUserService;
	/**
	 * getCounTrainList:(查询乡医培训列表)
	 *
	 * @param  @param userId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/getCounTrainList")
	public RtnBody getCounTrainList(String userId, String pageNum){
		SystemUser user = SystemUserUtil.getLoginUser(request);
		SystemUserConfig userConfig = null;
		if (user != null) {
			userConfig = systemUserService.getConfigByUserId(user.getId());
		}
		RtnBody rtn = new RtnBody();
		//查询 page分页
		//String pageNum = getPara("pageNum"); // 当前页
		if (StrKit.isBlank(pageNum)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("页数不能为空！");
		}
		String pageSize = getPara("pageSize", "20"); // 每页条数
		if (StrKit.isBlank(pageSize)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("每页面条数未指定！");
		}
		//1)未登录状态时，默认显示培训后台发布的授权到全国的乡医类型项目，按照发布时间倒叙排序；
		//2）已登录后，将根据用户注册所在地自动筛选更新，显示培训后台发布的授权到对应省份和全国的乡医类型项目，按照发布时间倒叙排序；
		CvSet cvSet = new CvSet();
		cvSet.setStatus(5);//已发布
		//cvSet.setCvSetType(1);//项目类型为乡医培训
		cvSet.setSign("乡医培训");//改过授权后，乡医培训项目在授权信息表中 2017-12-29
		String domainName = request.getServerName(); //取到 域名地址
		PageInfo<Record> page = new PageInfo<Record>();
		if (user != null && userConfig != null) {
			page = cvSetService.getCVSetPageListByNameAndProvice(cvSet, userConfig.getUserProvinceId(), pageNum, pageSize, domainName);
		} else {
			page = cvSetService.getCVSetPageListByNameAndProvice(cvSet, null, pageNum, pageSize, domainName);
		}
		
		rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(page);//{"code":200,"page":{....}} --可用,主要使用自定义数据体前缀，例如 ：page
		return rtn;
	}
	
}
