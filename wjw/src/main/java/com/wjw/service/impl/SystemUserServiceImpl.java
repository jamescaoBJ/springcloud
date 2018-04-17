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
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.mapper.CvDiplomaMapper;
import com.ncme.springboot.mapper.CvLiveMapper;
import com.ncme.springboot.mapper.ExamHospitalMapper;
import com.ncme.springboot.mapper.ExamPropValMapper;
import com.ncme.springboot.mapper.LogStudyCvSetMapper;
import com.ncme.springboot.mapper.LogStudyCvUnitVideoCensusMapper;
import com.ncme.springboot.mapper.SystemAccountMapper;
import com.ncme.springboot.mapper.SystemLoginLimitMapper;
import com.ncme.springboot.mapper.SystemUserConfigMapper;
import com.ncme.springboot.mapper.SystemUserMapper;
import com.ncme.springboot.model.ExamHospital;
import com.ncme.springboot.model.ExamPropVal;
import com.ncme.springboot.model.LogStudyCvSet;
import com.ncme.springboot.model.SystemAccount;
import com.ncme.springboot.model.SystemLoginLimit;
import com.ncme.springboot.model.SystemUser;
import com.ncme.springboot.model.SystemUserConfig;
import com.wjw.service.SystemUserService;
@Service
public class SystemUserServiceImpl implements SystemUserService {

	@Autowired
	SystemUserMapper systemMapper;
	@Autowired
	SystemUserConfigMapper systemUserConfigMapper;
	@Autowired
	ExamHospitalMapper examHospitalMapper;
	@Autowired
	ExamPropValMapper examPropValMapper;
	@Autowired
	CvDiplomaMapper cvDiplomaMapper;
	@Autowired
	LogStudyCvUnitVideoCensusMapper logStudyvideoCensusMapper;
	@Autowired
	SystemAccountMapper systemAccountMapper;
	@Autowired
	LogStudyCvSetMapper logStudyCvSetMapper;
	@Autowired
	CvLiveMapper cvLiveMapper;
	
	@Override
	public SystemUser getSystemUserByAccountName(String accountName) {
		return systemMapper.getItemByAccountName(accountName);
	}
	@Override
	public SystemUserConfig getConfigByUserId(Integer userId) {
		return systemUserConfigMapper.selectByUserId(userId);
		
	}
	@Override
	public Record getUserinfo(SystemUser user) {
		
		Record record = new Record();
		record.put("realName", user.getRealName());
		if (user.getSex() == null) {
			record.put("sex", "");
		} else {
			record.put("sex", user.getSex());
		}
		//查询用户工作单位名称
		if (user.getWorkUnitId() != null) {
			ExamHospital hospital = examHospitalMapper.selectByPrimaryKey(user.getWorkUnitId());
			record.put("company", hospital.getName());
		} else {
			if (user.getOtherHospitalName()!=null && user.getOtherHospitalName()!="") {
				record.put("company", user.getOtherHospitalName());
			} else {
				record.put("company", "");
			}
		}
		ExamPropVal subject = examPropValMapper.getSubjectByUserId(user.getId());
		String subjectName = "";
		if (subject != null) {
			subjectName = subject.getName();
		}
		record.put("subject", subjectName);
		Double score = 0.0;
		Double learnScore = cvDiplomaMapper.getScoreByUserId(user.getId(),null);
		if (learnScore != null) {
			score = learnScore;
		}
		record.put("studyScore", score);
		Integer studyLength = logStudyvideoCensusMapper.getStudyLengthByUserId(user.getId(),null,null);
		int hour = 0;
		if (studyLength != null) {
			hour = studyLength/60;
			int second = studyLength%60;
		}
		record.put("studyTime", hour);
		return record;
		
	}
	
	@Override
	public Record getAccountInfo(SystemUser user) {
		Record record = new Record();
		//查询用户密码
		String pwd = systemMapper.getPassWordById(user.getId());
		if (pwd!=null) {
			record.put("password", pwd);
		} else {
			record.put("password", "");
		}
		
		//查询用户工作单位名称
		if (user.getWorkUnitId() != null) {
			ExamHospital hospital = examHospitalMapper.selectByPrimaryKey(user.getWorkUnitId());
			if (hospital!=null) {
				record.put("company", hospital.getName());
				record.put("companyId", hospital.getId());
				//record.put("address", hospital.getHospitalAddress());
			} else {
				record.put("company", user.getOtherHospitalName());
				record.put("companyId", "");
			}
		} else {
			record.put("company", user.getOtherHospitalName());
			record.put("companyId", "");
		}
		
		//查询用户学科及学科ID
		ExamPropVal subject3 = examPropValMapper.getSubjectByUserId(user.getId());
		if (subject3!=null) {
			//根据三级学科ID查其二级学科
			ExamPropVal subject2 = examPropValMapper.getSubjectBySubId(subject3.getId());
			if (subject2!=null) {
				//根据二级学科ID查其一级学科
				ExamPropVal subject1 = examPropValMapper.getSubjectBySubId(subject2.getId());
				if (subject1!=null) {
					record.put("subject", subject1.getName()+" "+subject2.getName()+" "+subject3.getName());
				}
			} else {
				record.put("subject", subject3.getName());
			}
			record.put("subjectId", subject3.getId());
			
			//查询用户 职务类型名称 职务类型 ID
			if (subject3.getImgType()!=null) {
				record.put("jobTypeId", subject3.getImgType());              //设置职务类型ID
				switch (subject3.getImgType()) {
				case 1:
					record.put("jobType", "医疗人员");							//设置职务类型名称
					record.put("jobId", "98953");
					break;
				case 2:
					record.put("jobType", "护理人员");
					record.put("jobId", "98954");
					break;
				case 3:
					record.put("jobType", "药学人员");
					record.put("jobId", "98955");
					break;
				case 4:
					record.put("jobType", "公共卫生人员");
					record.put("jobId", "98956");
					break;
				case 5:
					record.put("jobType", "技术人员");
					record.put("jobId", "98957");
					break;
				case 6:
					record.put("jobType", "中医人员");
					record.put("jobId", "98958");
					break;
				case 7:
					record.put("jobType", "教师");
					record.put("jobId", "98959");
					break;
				case 8:
					record.put("jobType", "研究人员");
					record.put("jobId", "98961");
					break;
				case 9:
					record.put("jobType", "其他");
					record.put("jobId", "98962");
					break;
				default:
					record.put("jobType", "其它");
					record.put("jobId", "98962");
					break;
				}
			} else {
				record.put("jobTypeId", "");
				record.put("jobType", "");
				record.put("jobId", "");
			}
		} else {
			record.put("subject", "");
			record.put("subjectId", "");
			record.put("jobTypeId", "");
			record.put("jobType", "");
		}
		
		//查询用户 职称名称 职称ID
		Record recd = systemMapper.getDutyByUserId(user.getId());
		if (recd !=null) {
			record.put("titleId", recd.get("id"));
			record.put("title", recd.get("name"));
		} else {
			record.put("titleId", "");
			record.put("title", "");			
		}
		//查询用户所在省市区名称及ID
		List<Record> ssq = systemMapper.getSsqByUserId(user.getId());
		if (ssq!=null && ssq.size()>0) {
			record.put("proviceId", "");
			record.put("proviceName", "");
			record.put("cityId", "");
			record.put("cityName", "");
			record.put("districtId", "");
			record.put("districtName", "");
			for (int i=0;i<ssq.size();i++) {
				if (i==0 && ssq.get(i).get("id")!=null && ssq.get(i).get("name")!=null) {
					record.put("proviceId", ssq.get(i).get("id"));
					record.put("proviceName", ssq.get(i).get("name"));
				} else if (i==1 && ssq.get(i).get("id")!=null && ssq.get(i).get("name")!=null) {
					record.put("cityId", ssq.get(i).get("id"));
					record.put("cityName", ssq.get(i).get("name"));
				} else if (i==2 && ssq.get(i).get("id")!=null && ssq.get(i).get("name")!=null) {
					record.put("districtId", ssq.get(i).get("id"));
					record.put("districtName", ssq.get(i).get("name"));
				} else {
					
				}
			}
		}
		return record;
	}
	
	@Override
	public void updateAccount(SystemUser user, String userName, String proviceId,String cityId,String districtId, String titleId, String subjectId) {
		//修改用户帐户基本信息
		int no = systemMapper.updateByPrimaryKey(user);
		Integer userId = user.getId();
		
		if (!StrKit.isBlank(userName)) {						//用户登录名称
			//更新用户登录名称
			systemMapper.updateSystemAccount(userName, userId);
		}
		if (!StrKit.isBlank(proviceId)) {						//用户所在省ID
			//更新用户省市区
			systemMapper.updateSsq(proviceId,cityId,districtId,userId);
		}
		if (!StrKit.isBlank(titleId)) {						    //用户职称  如：教授
			//更新用户职称
			systemMapper.updateTitle(titleId,userId);
		}
		if (!StrKit.isBlank(subjectId)) {						//用户学科  如：眼科
			//更新用户学科--先删除
			systemMapper.updateSubjectIdDelete(subjectId,userId);
			//更新用户学科--再更新
			systemMapper.updateSubjectId(subjectId,userId);
		}
		
	}

	@Override
	public String getPassWordById(Integer userId) {
		//查询用户密码
		String pwd = "";
		pwd = systemMapper.getPassWordById(userId);
		return pwd;
	}

	/**
	 * 获取登录次数限制规则
	 * @see com.wjw.service.SystemUserService#getLoginLimter()
	 */
	@Autowired
	SystemLoginLimitMapper systemLoginLimitMapper;
	@Override
	public SystemLoginLimit getLoginLimter() {
		
		return systemLoginLimitMapper.getLoginLimter();
		
	}
	
	/**
	 * 更新密码错误次数记录
	 * @see com.wjw.service.SystemUserService#updateLoginErrors(com.ncme.springboot.model.SystemUser)
	 */
	@Override
	public int updateLoginErrors(SystemUser user) {
		
		return systemLoginLimitMapper.updateLoginErrors(user);
		
	}	
	
	@Override
	public boolean isRegister(String userId, String newPhone) {
		boolean isRegister = false;
		int no = systemMapper.isRegister(userId,newPhone);
		if (no > 0) {
			isRegister = true;
		}
		return isRegister;
	}
	
	@Override
	public boolean isRegisterIdCard(String userId, String idCard) {
		boolean isRegister = false;
		int no = systemMapper.isRegisterIdCard(userId,idCard);
		if (no > 0) {
			isRegister = true;
		}
		return isRegister;
	}
	
	@Override
	public void updatePhone(String userId, String newPhone) {
		systemMapper.updatePhone(userId,newPhone);
	}
	
	@Override
	public void saveAccount(SystemUser user, String userName, String password, String proviceId, String cityId, String districtId,String titleId, String subjectId) {
		//保存用户注册帐户基本信息
		int no = 0;
		no = systemMapper.insert(user);
		if (no > 0) {
			//根据手机号码获取用户基本信息
			SystemUser account = systemMapper.getAccountByPhone(user.getMobilPhone());
			Integer userId = account.getId();
			
			if (!StrKit.isBlank(userName)) {						//用户登录名称
				//保存用户登录名称
				systemMapper.saveSystemAccount(userName,userId,password);
			}
			if (!StrKit.isBlank(proviceId)) {						//用户所在省ID
				//保存用户省市区
				systemMapper.saveSsq(proviceId,cityId,districtId,userId);
			}
			if (!StrKit.isBlank(titleId)) {						    //用户职称  如：教授
				//保存用户职称
				systemMapper.saveTitle(titleId,userId);
			}
			if (!StrKit.isBlank(subjectId)) {						//用户学科  如：眼科
				//保存用户学科--先删除
				systemMapper.updateSubjectIdDelete(subjectId,userId);
				//保存用户学科--再更新
				systemMapper.updateSubjectId(subjectId,userId);
			}
		}
	}
	
	@Override
	public void resetPwd(String phone, String originalPassword) {
		systemMapper.resetPwd(phone,originalPassword);
	}
	
	@Override
	public List<SystemUser> getAllUser() {
		return systemMapper.getAllUser();
	}
	
	@Override
	public List<Record> getMyStudys(Integer userId, Integer isApplyCredit) {
		return systemMapper.getMyStudys(userId, isApplyCredit);
	}
	
	@Override
	public List<Record> getSignUpCvLive(Integer userId, Integer isApplyCredit) {
		return systemMapper.getSignUpCvLive(userId, isApplyCredit);
	}
	
	@Override
	public int checkAlreadySend(Integer userId, String msgContent) {
		return systemMapper.checkAlreadySend(userId, msgContent);
	}
		
	@Override
	public void updateSystemPassword(String userPassword,String userId) {
		systemMapper.updateSystemPassword(userPassword,userId);
		
	}
	@Override
	public SystemAccount getSystemAccountByWeiXinId(String openid) {
		
		return systemAccountMapper.getAccountByOpenId(openid);
		
	}

	@Override
	public void saveYzm(String phone, Integer yzm) {
		//判断该手机号是否已获取过验证码
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String cur = df.format(new Date().getTime() + 300000);//存到数据库里的时候是已经加了5分钟的时间);
		int no=0;
		no = systemMapper.getYzmByPhone(phone);
		if (no > 0) {		//更新该手机号下的验证码
			systemMapper.updateYzmByPhone(phone,yzm,cur);
		} else {			//保存验证码
			systemMapper.saveYzmByPhone(phone,yzm,cur);
		}
		
	}

	@Override
	public int isValidTime(String phone) {
		return systemMapper.isValidTime(phone);
	}
	
	@Override
	public int updateOpenIdByUserId(String openid, Integer userId) {
		
		return systemAccountMapper.updateOpenIdByAccountId(openid, userId);
		
	}
	
	@Override
	public boolean nameValidate(String userId, String userName) {
		boolean isRegister = false;
		int no = systemMapper.nameValidate(userId,userName);
		if (no > 0) {
			isRegister = true;
		}
		return isRegister;
	}
	
	@Override
	public PageInfo<Record> getMyFavorite(Integer userId, Integer favType, String pageCurrent, String pageSize) {
		//PageHelper.startPage(StrKit.str2Int(pageCurrent), StrKit.str2Int(pageSize));
		List<Record> list = new ArrayList<Record>();
		if (favType==0) {   //查询收藏的项目
			list =systemMapper.getMyFavoriteByProject(userId, favType);
			if (list!=null && list.size()>0) {
				for (Record r:list) {
					String s = r.get("score").toString();
					r.put("score", s.substring(0,s.length()-1));
					List<LogStudyCvSet> logList = logStudyCvSetMapper.listLogStudyByCvSetId(null,(Integer)r.get("projectId"));
					if (logList != null && logList.size()>0) {
						r.put("learnNum", logList.size());
					} else {
						r.put("learnNum", 0);
					}
				}
			}
		} else {			//查询收藏的课程
			list = systemMapper.getMyFavorite(userId, favType);
			if (list!=null && list.size()>0) {
				for (Record r : list) {
					/*
					Record cvset = cvLiveMapper.getCvSet((Integer)r.get("projectId"));
					if (cvset != null && cvset.get("costType") != null) {
						r.put("costType", cvset.get("costType").toString());
						r.put("cost", cvset.get("cost").toString());
					} else {
						r.put("costType", "0");
						r.put("cost", "0.0");
					}*/
					if (r.get("type").toString().equals("2")) {     //若为直播课程,则查询该课程的状态及学习次数
						Map<String,Object> map=new HashMap<String, Object>();
						//判断是否直播课程ID
						map.put("cvId", r.get("projectId").toString());
						List<Record> cvList = cvLiveMapper.getDetail(map);
						if (cvList!=null && cvList.size()>0) {
							r.put("startDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format( cvList.get(0).get("startDate")));
							r.put("endDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format( cvList.get(0).get("endDate")));
							Integer currentType = (Integer) cvList.get(0).get("type");
							r.put("level", currentType);
							if (currentType == 1) {
								r.put("learnNum", getStudyCountForOnline((Integer)r.get("projectId")));
							} else if (currentType == 2) {
								r.put("learnNum", 0);
							} else if (currentType == 3) {
								r.put("learnNum", getStudyCountForEnd((Integer)r.get("projectId")));
							} else if(currentType == 4) {
								r.put("learnNum", getStudyCountForViewBack((Integer)r.get("projectId")));
							} else {
								r.put("learnNum", 0);
							}
						} else {
							r.put("level", 0);
							r.put("learnNum", 0);
							r.put("startDate", "");
							r.put("endDate", "");
						}
					} else {										//若非直播课程,则查询课程学习次数
						int num = cvLiveMapper.getCourseLearnNum((Integer)r.get("projectId"));
						if ( num > 0) {
							r.put("learnNum", num);
						} else {
							r.put("learnNum", 0);
						}
					}
					//获取课程的授课教师
					List<Record> teacherList = cvLiveMapper.selectTeacher((Integer)r.get("projectId"));
					if (teacherList != null && teacherList.size() > 0) {
						r.put("teacherName", teacherList.get(0).get("name"));
					} else {
						r.put("teacherName", "");
					}
				}
			}
		}
		PageInfo<Record> page = new PageInfo<Record>();
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
	
	
	public int getStudyCountForOnline(Integer cvId){
		int count = 0;
		try{
			count = cvLiveMapper.getStudyNumForOnline(cvId);
		}catch(Exception ex){
			count = 0;
		}
		return count;
	}
	
	public int getStudyCountForEnd(Integer cvId){
		int count = 0;
		try{
			count = cvLiveMapper.getStudyNumForEnd(cvId);
		}catch(Exception ex){
			count = 0;
		}
		return count;
	}
	
	public int getStudyCountForViewBack(Integer cvId){
		int count = 0;
		try{
			count = cvLiveMapper.getStudyNumForViewBack(cvId);
		}catch(Exception ex){
			count = 0;
		}
		return count;
	}
	
	public int getStudentNum(Integer type, Integer cvId){
		int lel = type == null ? 0 : type;
		int num = 0;
		switch (lel) {
		case 1:
			num = getStudyCountForOnline(cvId);
			break;
		case 2:
			num = 200;
			break;
		case 3:
			num = getStudyCountForEnd(cvId);
			break;
		case 4:
			num = getStudyCountForViewBack(cvId);
			break;
		case 5:
			num = getStudyCountForEnd(cvId);
			break;
		default:
			num = 200;
		}
		return num;
	}
	
	@Override
	public void addCollection(Integer userId, Integer projectId, Integer favType) {
		//保存前先删除
		systemMapper.cancelCollection(userId, projectId, favType);
		//再保存
		systemMapper.addCollection(userId,projectId,favType);
	}
	
	@Override
	public void cancelCollection(Integer userId, Integer projectId, Integer favType) {
		systemMapper.cancelCollection(userId, projectId, favType);
	}
	
	@Override
	public int saveFeedBack(Map<String, Object> map) {
		return systemMapper.saveFeedBack(map);
		
	}


}
