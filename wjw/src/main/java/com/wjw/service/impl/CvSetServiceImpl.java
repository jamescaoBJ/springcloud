package com.wjw.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.DateUtil;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.mapper.CvLiveMapper;
import com.ncme.springboot.mapper.CvMapper;
import com.ncme.springboot.mapper.CvSetMapper;
import com.ncme.springboot.mapper.CvSetScheduleFaceteachMapper;
import com.ncme.springboot.mapper.CvSetScoreLogMapper;
import com.ncme.springboot.mapper.CvUnitMapper;
import com.ncme.springboot.mapper.ExamPropValMapper;
import com.ncme.springboot.mapper.ExpertInfoMapper;
import com.ncme.springboot.mapper.GroupClassInfoMapper;
import com.ncme.springboot.mapper.LogStudyCvSetMapper;
import com.ncme.springboot.mapper.LogStudyCvUnitVideoMapper;
import com.ncme.springboot.mapper.SystemCardSetOrderMapper;
import com.ncme.springboot.mapper.SystemCardTypeCvSetMapper;
import com.ncme.springboot.model.Cv;
import com.ncme.springboot.model.CvSet;
import com.ncme.springboot.model.CvSetScheduleFaceteach;
import com.ncme.springboot.model.CvSetScore;
import com.ncme.springboot.model.CvSetScoreLog;
import com.ncme.springboot.model.CvUnit;
import com.ncme.springboot.model.ExamPropVal;
import com.ncme.springboot.model.GroupClassInfo;
import com.ncme.springboot.model.LogStudyCvSet;
import com.ncme.springboot.model.LogStudyCvUnitVideo;
import com.ncme.springboot.model.SystemCardSetOrder;
import com.ncme.springboot.model.SystemCardTypeCvSet;
import com.wjw.service.CvSetScoreService;
import com.wjw.service.CvSetService;

@Service
public class CvSetServiceImpl implements CvSetService {

	@Autowired
	CvSetMapper cvSetMapper;
	
	@Autowired
	LogStudyCvSetMapper logStudyCvSetMapper;
	
	@Autowired
	ExamPropValMapper examPropValMapper;
	
	@Autowired
	ExpertInfoMapper expertInfoMapper;
	
	@Autowired
	CvSetScoreService cvSetScoreService;
	
	@Autowired
	CvMapper cvMapper;
	@Autowired
	CvUnitMapper cvUnitMapper;
	@Autowired
	SystemCardTypeCvSetMapper cardTypeCvSetMapper;
	@Autowired
	SystemCardSetOrderMapper cardSetOrderMapper;
	@Autowired
	GroupClassInfoMapper groupClassInfoMapper;
	@Autowired
	CvSetScoreLogMapper cvSetScoreLogMapper;
	@Autowired
	CvSetScheduleFaceteachMapper faceteachMapper;
	@Autowired
	CvLiveMapper cvLiveMapper;
	@Autowired
	LogStudyCvUnitVideoMapper logStudyCvUnitVideoMapper;
	
	
	@Override
	public PageInfo<Record> getCVSetPageListByNameAndProvice(CvSet cvSet, Integer provinceId, String pageCurrent, String pageSize, String domainName) {
		
		PageHelper.startPage(StrKit.str2Int(pageCurrent), StrKit.str2Int(pageSize));
		//根据名称和省份查询项目
		List<Record> cvSetList = cvSetMapper.getCVSetPageListByNameAndProvice(cvSet, provinceId, domainName);
		//根据项目id查询该项目的学习次数，并将学习次数set到返回的对象里
		for (Record r:cvSetList) {
			String s = r.get("score").toString();
			r.put("score", s.substring(0,s.length()-1));
			List<LogStudyCvSet> logList = logStudyCvSetMapper.listLogStudyByCvSetId(null,(Integer)r.get("cvSetId"));
			if (logList != null && logList.size()>0) {
				r.put("learnNum", logList.size());
			} else {
				r.put("learnNum", 0);
			}
		}
		PageInfo<Record> page = new PageInfo<Record>(cvSetList);
		return page;
		
	}

	@Override
	@Cacheable(value="cvSet", key="#cvSetId")
	public Record getProjectDetailById(Integer cvSetId, Integer provinceId, String domainName) {
		//根据项目id查询项目详情
		Record record = cvSetMapper.getProjectDetailById(cvSetId, provinceId, domainName);
		if (record == null) {
			return new Record();
		}
		String introduction = ((String)record.get("introduction")).replaceAll("&#40;", "\\(").replaceAll("&#41;", "\\)");
		record.put("introduction", introduction);
		//如果该项目为面授项目，则查询项目培训期数
		Integer subjectType = (Integer)record.get("subjectType");
		
		if (subjectType == 3) {//3为面授项目
			//TODO 查询培训期数
		} else {
			//如果为远程项目，需要返回项目的第一个课程的第一个单元id和视频id
			String unitId = "";
			String vedioUrl = "";
			String unitType = "";
			List<Cv> list = cvMapper.mySelectCvByCvsetId(cvSetId.toString(),0);
			if (list != null && list.size()>0) {
				List<Record> cvUnitList = cvUnitMapper.getUnitListByCvId(list.get(0).getId());
				if (cvUnitList != null && cvUnitList.size() > 0) {
					unitId = ((Integer)cvUnitList.get(0).get("id")).toString();
					unitType = ((Integer)cvUnitList.get(0).get("type")).toString();
					vedioUrl = (String)cvUnitList.get(0).get("mediaId");
				}
			}
			record.put("unitId", unitId);
			record.put("unitType", unitType);
			record.put("videoUrl", vedioUrl);
		}
		
		//根据项目id查询学科
		List<ExamPropVal> propList = examPropValMapper.getExamPropValByCvSetId(cvSetId);
		/*String subject = "";
		if (propList != null) {
			for (ExamPropVal prop : propList) {
				subject += prop.getName() + " ";
			}
		}
		record.put("subject", subject);*/
		if (propList != null) {
			//根据三级学科ID查其二级学科
			ExamPropVal subject2 = examPropValMapper.getSubjectBySubId(propList.get(0).getId());
			if (subject2!=null) {
				//根据二级学科ID查其一级学科
				ExamPropVal subject1 = examPropValMapper.getSubjectBySubId(subject2.getId());
				if (subject1!=null) {
					record.put("subject", subject1.getName()+">"+subject2.getName()+">"+propList.get(0).getName());
				}
			} else {
				record.put("subject", propList.get(0).getName());
			}
		}
		//项目来源
		List<Record> sourceList = cvSetMapper.listPeixunOrg(cvSetId);
		String source = "" ;
		if (sourceList != null && sourceList.size()>0) {
			for (Record r:sourceList) {
				source += r.get("name").toString()+" ";
			}
		} else {
			source = "中国继续医学教育网";
		}
		record.put("source", source);
		//根据项目id查询项目负责人
		List<Record> perList = expertInfoMapper.listExpertByCvSetId(cvSetId, 1);
		record.put("expertName", perList.get(0).get("expertName"));
		record.put("photo", perList.get(0).get("photo"));
		record.put("summary", perList.get(0).get("summary"));
		//根据项目id查询授课老师
		List<Record> teacherList = expertInfoMapper.listTeachersByCvSetId(cvSetId, 1);
		record.put("teachers", teacherList);
		 //项目的书籍推荐
		List<Record> recommendation = cvSetMapper.getRefereeBookByCvSetId(cvSetId);
		record.put("recommendation", recommendation);
        //指南共识
		List<Record> guide = cvSetMapper.getKnowledgebaseByCvSetId(cvSetId);
		record.put("guide", guide);
        //最新文献
		List<Record> literature = cvSetMapper.getReferencelatelyByCvSetId(cvSetId);
		record.put("literature", literature);
		//查询项目综合评分
		CvSetScore cvSetScore = cvSetScoreService.getScoreByCvSetId(cvSetId);
		if (cvSetScore != null) {
			record.put("evaluateScore", cvSetScore.getGrade());
		} else {
			record.put("evaluateScore", "100");
		}
		
		//查询项目评价信息,请求详情页时默认先返回20条评价信息
		PageInfo<Record> scoreLogList = cvSetScoreService.listScoreLogByCvSetId(cvSetId, "1", "20");
		record.put("eval", scoreLogList.getList());
		return record;
	}

	/**
	 * (non-Javadoc)
	 * @see com.wjw.service.CvSetService#mySelectCvByCvsetId(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public PageInfo<Cv> mySelectCvByCvsetId(String pageNum, String pageSize, String projectId,Integer userId) {
		PageHelper.startPage(StrKit.str2Int(pageNum), StrKit.str2Int(pageSize));

		List<Cv> list = cvMapper.mySelectCvByCvsetId(projectId,userId);
		
		PageInfo<Cv> page = new PageInfo<Cv>(list);

		return page;
		
	}

	/**
	 * (non-Javadoc)
	 * @see com.wjw.service.CvSetService#projectDiscuss(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public PageInfo<Record> projectDiscuss(String pageNum, String pageSize, Integer projectId) {
		PageHelper.startPage(StrKit.str2Int(pageNum), StrKit.str2Int(pageSize));

		List<Record> list = cvSetMapper.projectDiscuss(projectId);
		PageInfo<Record> page = new PageInfo<Record>(list);

		return page;
		
	}



	/**
	 * (non-Javadoc)
	 * @see com.wjw.service.CvSetService#unitDiscuss(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public PageInfo<Record> unitDiscuss(String pageNum, String pageSize, String unitId, String projectId) {
		PageHelper.startPage(StrKit.str2Int(pageNum), StrKit.str2Int(pageSize));

		List<Record> list = cvSetMapper.unitDiscuss(unitId,projectId);
		PageInfo<Record> page = new PageInfo<Record>(list);

		return page;
		
	}

	/**
	 * (non-Javadoc)
	 * @see com.wjw.service.CvSetService#projectNote(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public PageInfo<Record> projectNote(String pageNum, String pageSize, String projectId, Integer userId) {
		
		PageHelper.startPage(StrKit.str2Int(pageNum), StrKit.str2Int(pageSize));

		List<Record> list = cvSetMapper.projectNote(userId,projectId);
		PageInfo<Record> page = new PageInfo<Record>(list);

		return page;
		
	}

	/**
	 * (non-Javadoc)
	 * @see com.wjw.service.CvSetService#unitNote(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public PageInfo<Record> unitNote(String pageNum, String pageSize, String projectId, String unitId, Integer userId) {
		
		
		PageHelper.startPage(StrKit.str2Int(pageNum), StrKit.str2Int(pageSize));

		List<Record> list = cvSetMapper.unitNote(userId,projectId,unitId);
		PageInfo<Record> page = new PageInfo<Record>(list);

		return page;
		
	}

	@Override
	public Record getProjectStudyDetail(Integer userId, Integer cvSetId, String cvUnitId, String domainName) {
		
		Record record = cvSetMapper.getProjectDetailById(cvSetId,null,domainName);
		String introduction = ((String)record.get("introduction")).replaceAll("&#40;", "\\(").replaceAll("&#41;", "\\)");
		record.put("introduction", introduction);
		//项目总讨论数
		List<Record> discussList = cvSetMapper.projectDiscuss(cvSetId);
		record.put("classDiscuss", discussList.size());
		//项目总笔记数
		List<Record> noteList = cvSetMapper.projectNote(userId,cvSetId.toString());
		record.put("classNote", noteList.size());
		//总任务点
		int points = cvUnitMapper.countPoints(cvSetId,1);
		//已完成的任务点
		int completePoints = cvUnitMapper.completedLogUnits(userId, cvSetId,1);
		//计算学习进度
		double progress = 0.0;
		if (points != 0 && completePoints != 0) {
			progress = (completePoints*1.0/points)*100;
			DecimalFormat df = new DecimalFormat("#.0");
			String pro = df.format(progress);
			record.put("progress", pro);
		} else if (points == 0) {
			int unitCount = cvUnitMapper.countPoints(cvSetId, 0);
			int comUnitCount = cvUnitMapper.completedLogUnits(userId, cvSetId, 0);
			progress = (comUnitCount*1.0/unitCount)*100;
			DecimalFormat df = new DecimalFormat("#.0");
			String pro = df.format(progress);
			record.put("progress", pro);
		} else {
			progress = 0;
			record.put("progress", progress);
		}
		
		//是否申请过学分：1：未申请，2：已申请
		Integer isApply = 1;
		List<LogStudyCvSet> studyList = logStudyCvSetMapper.listLogStudyByCvSetId(userId, cvSetId);
		if (studyList != null && studyList.size()>0) {
			isApply = studyList.get(0).getIsApplyCredit();
		}
		record.put("isApply", isApply);
		//是否评价过：0：未评价，1：已评价
		Integer isEval = 0;
		CvSetScoreLog scoreLog = cvSetScoreLogMapper.getScoreLogByUserIdAndCvSetId(userId, cvSetId);
		if (scoreLog != null) {
			isEval = 1;
		}
		record.put("isEval", isEval);
		//根据项目id查询该项目的课程目录
		List<Cv> cvList = cvMapper.mySelectCvByCvsetId(cvSetId.toString(),userId);
		record.put("cvList", cvList);
		//返回视频地址，如果未学习过，返回第一课程的第一单元，如果已经学习过，则返回最后一次学习的视频地址和单元id
		Integer cvId = 0;
		Integer unitId = 0;
		Integer unitType = 0;
		String vedioUrl = "";
		Integer vedioPlayLength = 0;
		Integer cvType = 0;
		//如果cvUnitId不为空，则表示直接从目录里点击单元进入学习详情页
		if (StrKit.isBlank(cvUnitId)) {
			//根据根据用户id和项目id查询学习日志表，如果查出结果为空则代表该用户未学习该项目
			List<LogStudyCvSet> logStudyList = logStudyCvSetMapper.listLogStudyByCvSetId(userId, cvSetId);
			if (logStudyList != null && logStudyList.size()>0) {
				/**返回最后一次学习的视频地址和单元id以及学习视频的长度**/
				//根据项目id和用户id查询用户课程单元学习记录
				List<Record> cvUnitLogStudyList = cvUnitMapper.queryUnitLogStudyByCvSetIdAndUserId(userId, cvSetId);
				if (cvUnitLogStudyList != null && cvUnitLogStudyList.size()>0) {
					Record unitDetail = cvUnitMapper.getCVUnitLogStudyByUnitIdAndUserId(userId, (Integer)cvUnitLogStudyList.get(0).get("unitId"));
					cvId = (Integer)cvUnitLogStudyList.get(0).get("cvId");
					unitId = (Integer)cvUnitLogStudyList.get(0).get("unitId");
					cvType = (Integer)cvUnitLogStudyList.get(0).get("cvType");
					if (unitDetail != null) {
						//unitId = (Integer)unitDetail.get("id");
						unitType = (Integer)unitDetail.get("type");
						vedioUrl = (String)unitDetail.get("mediaId");
						//关联查询时如果视频学习记录表为空，则查不出视频的信息，故分开
						LogStudyCvUnitVideo videoLog = logStudyCvUnitVideoMapper.getVideoLogByUserIdAndUnitId(userId, unitId);
						if (videoLog != null) {
							vedioPlayLength = videoLog.getVideoplaylength();
						}
					}
				}
			} else {
				//未学习过，返回第一课程的第一单元
				if (cvList != null && cvList.size()>0) {
					List<Record> cvUnitList = cvUnitMapper.getUnitListByCvId(cvList.get(0).getId());
					cvId = cvList.get(0).getId();
					cvType = cvList.get(0).getCvType();
					if (cvUnitList != null && cvUnitList.size()>0) {
						unitId = (Integer)cvUnitList.get(0).get("id");
						unitType = (Integer)cvUnitList.get(0).get("type");
						vedioUrl = (String)cvUnitList.get(0).get("mediaId");
						vedioPlayLength = 0;
					}
				}
			}
		} else {
			unitId = Integer.valueOf(cvUnitId);
			CvUnit cu = cvUnitMapper.selectByPrimaryKey(Integer.valueOf(cvUnitId));
			unitType = cu.getType();
			String cv_id = cvMapper.getCvIdByUnitId(cvUnitId);//根据单元ID获取到 该单元 所在的课程ID
			cvId = Integer.valueOf(cv_id);
			GroupClassInfo info = groupClassInfoMapper.getClassInfoByUnitId(Integer.valueOf(cvUnitId));
			if (info != null ) {
				vedioUrl = info.getMediaId();
			}
			LogStudyCvUnitVideo videoLog = logStudyCvUnitVideoMapper.getVideoLogByUserIdAndUnitId(userId, unitId);
			if (videoLog != null) {
				vedioPlayLength = videoLog.getVideoplaylength();
			}
		}
		record.put("cvId", cvId);
		record.put("cvType", cvType);
		record.put("unitId", unitId);
		record.put("unitType", unitType);
		record.put("videoUrl", vedioUrl);
		record.put("videoPlayLength", vedioPlayLength);
		return record;
		
	}


	@Override
	public PageInfo<Record> myStudy(Integer id, String domainName, Integer noApplyCredit,String pageNum,String pageSize) {
		
		PageHelper.startPage(StrKit.str2Int(pageNum), StrKit.str2Int(pageSize));

		
		List<Record> list = cvSetMapper.myStudy(id,domainName,noApplyCredit);
		PageInfo<Record> page = new PageInfo<Record>(list);
		
		return page;
		
	}

	@Override
	public CvSet getCvSetById(Integer cvSetId, Integer provinceId, String domainName) {
		CvSet cvSet = cvSetMapper.getCvSetById(cvSetId,provinceId,domainName);
		return cvSet;
		
	}

	/**
	 * (non-Javadoc)
	 * @see com.wjw.service.CvSetService#myCredit(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public PageInfo<Record> myCredit(Integer id, String domainName, Integer applyCreditState, Integer provinceId,
			String pageNum,	String pageSize) {
		PageHelper.startPage(StrKit.str2Int(pageNum), StrKit.str2Int(pageSize));
		//查询学分申请的项目
		List<Record> list = cvSetMapper.myCredit(id, domainName,applyCreditState,provinceId);
	
		PageInfo<Record> page = new PageInfo<Record>(list);
		
		return page;
	}

	@Override
	public Record checkBindCost(Integer userId, Integer cvSetId, String domainName) {
		//card=1表示成功，不需要再绑卡了，0代表需要绑卡
		Record r = new Record();
		Record record = cvSetMapper.getProjectDetailById(cvSetId,null,domainName);
		if (record != null) {
			Integer costType = (Integer)record.get("costType");
			//第一步先判断该项目是否为卡项目
			if (costType == 1) {//学习卡项目
				//如果是，第二步判断卡类型里是否包含该项目
				List<SystemCardTypeCvSet> cvSetList = cardTypeCvSetMapper.findListBycvSetId(cvSetId);
				List<Integer> cardTypeList = new ArrayList<Integer>();
				if (cvSetList != null && cvSetList.size() > 0) {
					for (SystemCardTypeCvSet c:cvSetList) {
						cardTypeList.add(c.getCardtypeId());
					}
					//查询订单表中是否有该用户绑卡信息
					SystemCardSetOrder setOrder = new SystemCardSetOrder();
					setOrder.setUserId(userId);
					//setOrder.setCvSetId(cvSetId);
					//setOrder.setCardTypeId(cvSetList.get(0).getCardtypeId());
					Map param = new HashMap();
					param.put("cvSet", setOrder);
					param.put("cardTypeList", cardTypeList);
					List<SystemCardSetOrder> orderList = cardSetOrderMapper.findByUidProid(param);
					if (orderList != null && orderList.size() > 0) {
						r.put("card", 1);
					} else {
						r.put("card", 0);
					}
				} else {//如果不包含则该项目非绑卡项目
					r.put("card", 1);
				}
			} else if (costType == 2) {//付费项目，目前暂不考虑
				//r.put("cost", 0);
				r.put("card", 1);
			} else {
				r.put("card", 1);
			}
		}
		return r;
		
	}

	@Override
	public List<Record> myStudyNew(Integer userId, Integer isApplyCredit, Integer provinceId) {
		//获得我的学习列表中的项目列表
		List<Record> cvSetList = cvSetMapper.myStudyCvSet(userId, isApplyCredit, provinceId);
		//面授项目列表，当学员多次报名同一个面授项目的不同期数，将在我的学习中分别显示该项目期数
		List<Record> faceTeachList = new ArrayList<Record>();
		if (cvSetList != null && cvSetList.size()>0) {
			//cvSetList.stream().forEach(record -> {
			for (Record record:cvSetList) {
				Integer forma = (Integer)record.get("forma");//授课类型
				Integer cvSetId = (Integer)record.get("id");//项目id
				Integer state = (Integer)record.get("state");//项目完成状态
//				Integer unitId = 0;//最后一次学习的单元id
//				Integer unitType = 0;//最后一次学习的单元类型
//				String unitName = "";//最后一次学习的单元名称
				if (forma!= null && forma == 1) {
					if (state == 1) {
						//总任务点
						int points = cvUnitMapper.countPoints(cvSetId,1);
						//已完成的任务点
						int completePoints = cvUnitMapper.completedLogUnits(userId, cvSetId,1);
						//计算学习进度
						double progress = 0.0;
						if (points != 0 && completePoints != 0) {
							progress = (completePoints*1.0/points)*100;
							DecimalFormat df = new DecimalFormat("#.0");
							String pro = df.format(progress);
							record.put("status", pro);
						} else if (points == 0) {
							int unitCount = cvUnitMapper.countPoints(cvSetId, 0);
							int comUnitCount = cvUnitMapper.completedLogUnits(userId, cvSetId, 0);
							progress = (comUnitCount*1.0/unitCount)*100;
							DecimalFormat df = new DecimalFormat("#.0");
							String pro = df.format(progress);
							record.put("status", pro);
						}else {
							record.put("status", progress);
						}
					} else {
						record.put("status", 100);
						String content1 = (String)record.get("content1");
						if ("无学分".equals(content1)) {
							//是否评价过：0：未评价，1：已评价
							Integer isEval = 0;
							CvSetScoreLog scoreLog = cvSetScoreLogMapper.getScoreLogByUserIdAndCvSetId(userId, cvSetId);
							if (scoreLog != null) {
								isEval = 1;
							}
							record.put("isEval", isEval);
						}
					}
					/**返回最后一次学习的视频地址和单元id以及学习视频的长度**/
					//根据项目id和用户id查询用户课程单元学习记录
					/*List<Record> cvUnitLogStudyList = cvUnitMapper.queryUnitLogStudyByCvSetIdAndUserId(userId, cvSetId);
					if (cvUnitLogStudyList != null && cvUnitLogStudyList.size()>0) {
						//Record unitDetail = cvUnitMapper.getCVUnitLogStudyByUnitIdAndUserId(userId, (Integer)cvUnitLogStudyList.get(0).get("unitId"));
						Record unitDetail =cvUnitLogStudyList.get(0);
						unitId = (Integer)unitDetail.get("unitId");
						if (unitDetail != null) {
							unitType = (Integer)unitDetail.get("type");
							unitName = (String)unitDetail.get("detailname");
						}
					}*/
				}else if (forma!= null &&forma == 3) {
					//如果为面授项目，当学员多次报名同一个面授项目的不同期数，将在我的学习中分别显示该项目期数
					List<CvSetScheduleFaceteach> faceteachList = faceteachMapper.getFaceteachByUserIdAndCvSetId(userId, cvSetId);
					if (faceteachList != null && faceteachList.size() > 0) {
						String content1 = faceteachList.get(0).getClassName()+":"+DateUtil.format(faceteachList.get(0).getTrainStarttime(), "yyyy-MM-dd")
											+"至"+DateUtil.format(faceteachList.get(0).getTrainEndtime(), "yyyy-MM-dd");
						String content2 = faceteachList.get(0).getTrainPlace();
						record.put("content1", content1);
						record.put("content2", content2);
						if (DateUtil.compareTo(DateUtil.getNowDateYM(), faceteachList.get(0).getTrainStarttime())<0) {
							record.put("status", "未开始");
						} else if (DateUtil.compareTo(DateUtil.getNowDateYM(), faceteachList.get(0).getTrainEndtime())>0) {
							record.put("status", "已结束");
						} else {
							record.put("status", "面授中");
						}
						for (int i=1;i<faceteachList.size();i++) {
							Record temp = (Record)record.clone();
							String c1 = faceteachList.get(i).getClassName()+":"+DateUtil.format(faceteachList.get(i).getTrainStarttime(), "yyyy-MM-dd")
												+"至"+DateUtil.format(faceteachList.get(i).getTrainEndtime(), "yyyy-MM-dd");
							String c2 = faceteachList.get(i).getTrainPlace();
							temp.put("content1", c1);
							temp.put("content2", c2);
							if (DateUtil.compareTo(DateUtil.getNowDateYM(), faceteachList.get(i).getTrainStarttime())<0) {
								temp.put("status", "未开始");
							} else if (DateUtil.compareTo(DateUtil.getNowDateYM(), faceteachList.get(i).getTrainEndtime())>0) {
								temp.put("status", "已结束");
							} else {
								temp.put("status", "面授中");
							}
							/*temp.put("unitId",unitId);
							temp.put("unitType",unitType);
							temp.put("unitName",unitName);*/
							faceTeachList.add(temp);
						}
					}
				}
				/*record.put("unitId",unitId);
				record.put("unitType",unitType);
				record.put("unitName",unitName);*/
			}
		}
		cvSetList.addAll(faceTeachList);
		//直播学习列表:需求要求的查出的直播列表是正在直播和未开始的列表
		List<Record> liveList = cvLiveMapper.myStudyForCvLive(userId);
		List<Record> zbList = new ArrayList<Record>();
		if (liveList != null && liveList.size()>0) {
			for (Record r:liveList) {
				//直播状态 1：正在直播 2：即将开课 3：已结束 4：观看回放 5：已结束待转码
				Long liveState = (Long.valueOf(r.get("liveState").toString()));
				if (null != liveState && liveState == 1) {
					r.put("status", "正在直播");
					//当前在线学习人数
					//int count = getStudyCountForOnline((Integer)r.get("id"));
					int count =Integer.parseInt(r.get("count1Number").toString());
					r.put("content2", "人数："+count+"/200");
					zbList.add(r);
				} else if (null != liveState && liveState == 2) {
					r.put("status", "未开始");
					//查询报名人数
					Integer signupCount = cvLiveMapper.getSignUpCountByCvId((Integer)r.get("id"));
					//Integer signupCount =(Integer)r.get("count2Number");
					r.put("content2", "人数："+signupCount+"/200");
					zbList.add(r);
				}
			}
		}
		cvSetList.addAll(zbList);
		
		Collections.sort(cvSetList, new Comparator<Record>(){  
            /*  
             * int compare(Record o1, Record o2) 返回一个基本类型的整型，  
             * 返回负数表示：o1 大于o2，  
             * 返回0 表示：o1和o2相等，  
             * 返回正数表示：o1小于o2。  
             */  
            public int compare(Record o1, Record o2) {  
              
                //按照最后更新时间进行降序排列  
                if(((Date)o1.get("lastUpdateDate")).compareTo((Date)o2.get("lastUpdateDate"))>0){  
                    return -1;  
                }  
                if(((Date)o1.get("lastUpdateDate")).compareTo((Date)o2.get("lastUpdateDate"))==0){  
                    return 0;  
                }  
                return 1;  
            }  
        });   
		return cvSetList;
		
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

	@Override
	public List<Record> myCreditNew(Integer id, String domainName, Integer applyCreditState, Integer provinceId) {
		
		List<Record> list = cvSetMapper.myCredit(id, domainName,applyCreditState,provinceId);
		return list;
		
	}

	@Override
	public int getMyFavIsFavById(Map<String, Object> map) {
		return cvMapper.getMyFavIsFavById(map);
	}
	
}
