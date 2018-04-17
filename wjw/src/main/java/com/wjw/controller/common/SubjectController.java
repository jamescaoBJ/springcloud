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
import com.wjw.service.SubjectService;

/**
 * ClassName:SubjectController
 * Function: TODO 学科控制器
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月6日	下午1:51:19
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/subject")
public class SubjectController extends Controller {
	
	@Autowired
	SubjectService subjectService;

	/**
	 * getSubjectTypeList:学科类型列表
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping(value="/getSubjectTypeList")
	public RtnBody getSubjectTypeList(){
		RtnBody rtn = new RtnBody();
		List<Record> subject = new ArrayList<Record>();
		Record record = new Record();
		record.put("subjectId", "");
		record.put("subjectName", "全部");
		subject.add(record);
		Record r1 = new Record();
		r1.put("subjectId", "510018");
		r1.put("subjectName", "传染病学");
		subject.add(r1);
		Record r2 = new Record();
		r2.put("subjectId", "510051");
		r2.put("subjectName", "全科医学");
		subject.add(r2);
		Record r3 = new Record();
		r3.put("subjectId", "510028");
		r3.put("subjectName", "骨外科学");
		subject.add(r3);
		Record r4 = new Record();
		r4.put("subjectId", "510004");
		r4.put("subjectName", "妇产科学");
		subject.add(r4);
		Record r5 = new Record();
		r5.put("subjectId", "510026");
		r5.put("subjectName", "泌尿外科学");
		subject.add(r5);
		Record r6 = new Record();
		r6.put("subjectId", "510005");
		r6.put("subjectName", "儿科学");
		subject.add(r6);
		Record r7 = new Record();
		r7.put("subjectId", "510034");
		r7.put("subjectName", "外科学其他学科");
		subject.add(r7);
		Record r8 = new Record();
		r8.put("subjectId", "510019");
		r8.put("subjectName", "精神卫生学");
		subject.add(r8);
		Record r9 = new Record();
		r9.put("subjectId", "510043");
		r9.put("subjectName", "耳鼻喉科");
		subject.add(r9);
		Record r10 = new Record();
		r10.put("subjectId", "510052");
		r10.put("subjectName", "康复医学");
		subject.add(r10);
		/*PC端已取消
		Record r11 = new Record();
		r11.put("subjectId", "510015");
		r11.put("subjectName", "肾脏病学");
		subject.add(r11);*/
		Record r12 = new Record();
		r12.put("subjectId", "610010809");
		r12.put("subjectName", "医学教育与卫生管理");
		subject.add(r12);
		Record r13 = new Record();
		r13.put("subjectId", "510011");
		r13.put("subjectName", "心血管病学");
		subject.add(r13);
		
		Record r14 = new Record();
		r14.put("subjectId", "510012");
		r14.put("subjectName", "呼吸病学");
		subject.add(r14);
		
		Record r15 = new Record();
		r15.put("subjectId", "510024");
		r15.put("subjectName", "烧伤外科学");
		subject.add(r15);
		
		Record r16 = new Record();
		r16.put("subjectId", "510050");
		r16.put("subjectName", "重症医学");
		subject.add(r16);
		
		Record r17 = new Record();
		r17.put("subjectId", "510029");
		r17.put("subjectName", "肿瘤外科学");
		subject.add(r17);
		
		Record r18 = new Record();
		r18.put("subjectId", "510032");
		r18.put("subjectName", "麻醉学");
		subject.add(r18);
		
		Record r19 = new Record();
		r19.put("subjectId", "632000123");
		r19.put("subjectName", "超声诊断学");
		subject.add(r19);
		
		Record r20 = new Record();
		r20.put("subjectId", "580005");
		r20.put("subjectName", "儿科护理学");
		subject.add(r20);
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(subject); 
	}
	
	/**
	 * getSubject:一级学科获取
	 * TODO  
	 *
	 * @param  @param id
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/getSubject")
	public RtnBody getSubject(String id){
		if(StrKit.isBlank(id)){ // 学科id
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("id must be not empty."); //传参异常，为空返回状态码
		}
		Record record = subjectService.getSubject(id); // 获取学科数据
		
		return getRtnBody().data(record);// 返回结果
	}
	
	/**
	 * getSubjectByPostId:
	 * 根据职务类型获取一级学科
	 * @param  @param postId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/getSubjectByPostId")
	public RtnBody getSubjectByPostId(String postId){
		if(StrKit.isBlank(postId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("职务类型id不能为空");
		}
		List<Record> subjectList = subjectService.getSubjectByPostId(postId);
		return getRtnBody().data(subjectList).code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！");
	}
	
	/**
	 * 
	 * getSubjectById:
	 * TODO(根据父学科查询子学科,即根据一级学科ID查询其二级学科、根据二级学科ID查询其三级学科)
	 *
	 * @param  @param parentId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/getSubjectById")
	public RtnBody getSubjectById(String parentId){
		if(StrKit.isBlank(parentId)){ 				// 学科 parentId
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("学科ID不能为空！"); 
		}
		List<Record> record = subjectService.getSubjectById(parentId);
		return getRtnBody().data(record).code(BusinessConst.CODE_RESPONSE_SUCCESS).message("获取成功。");
	}
	
	/**
	 * 
	 * getXueke:
	 * TODO(根据职务ID获取 一级二级三级学科)
	 *
	 * @param  @param postId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	 */
	@RequestMapping("/getXueke")
	public RtnBody getXueke(String id){
		List <Map<String,Object>> map = new ArrayList<Map<String,Object>>();
		if(StrKit.isBlank(id)){ 				// 职务类型Id
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("学科ID不能为空！"); 
		}
		//根据职务类型获取一级学科
		List<Record> plist = subjectService.getSubjectByPostId(id);
		if (plist!=null && plist.size()>0) {
			for (int i = 0; i < plist.size(); i++) {
				Map<String,Object> msmap = new HashMap<String,Object>();
				msmap.put("subjectId", plist.get(i).get("id"));
				msmap.put("subjectName", plist.get(i).get("name"));
				//根据一级学科ID获取二级学科
				List<Record> clist = subjectService.getSubjectById(plist.get(i).get("id").toString());
				List <Map<String,Object>> map2 = new ArrayList<Map<String,Object>>();
				if(clist!=null && clist.size()>0) {
					for (int j = 0; j < clist.size(); j++) {
						Map<String,Object> msmap1 = new HashMap<String,Object>();
						msmap1.put("subjectId", clist.get(j).get("subjectId"));
						msmap1.put("subjectName", clist.get(j).get("subjectName"));
						List<Record> rlist = subjectService.getSubjectById(clist.get(j).get("subjectId").toString());
						//根据二级学科ID获取三级学科
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
