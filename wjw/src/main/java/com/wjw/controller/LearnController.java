package com.wjw.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.controller.Controller;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.footstone.util.BusinessUtil;
import com.ncme.springboot.footstone.util.StrKit;
import com.ncme.springboot.model.CvSetUnitDiscuss;
import com.ncme.springboot.model.CvUnit;
import com.ncme.springboot.model.ExamExamination;
import com.ncme.springboot.model.ExamQuestionKey;
import com.ncme.springboot.model.LogExam;
import com.ncme.springboot.model.LogExamResult;
import com.ncme.springboot.model.LogStudyCvUnit;
import com.ncme.springboot.model.LogStudyCvUnitVideo;
import com.ncme.springboot.model.LogStudyCvUnitVideoCensus;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.CvUnitService;
import com.wjw.service.ExamPaperService;
import com.wjw.service.LogStudyCvSetService;
import com.wjw.service.LogStudyCvUnitService;
import com.wjw.service.SystemUserService;
import com.wjw.service.TopicDiscussionService;
import com.wjw.util.SystemUserUtil;

/**
 * ClassName:LearnController
 * Function: 学习相关controller
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月17日	上午9:36:48
 *
 * @see 	 
 *  
 */
@RestController
@RequestMapping("/learn")
public class LearnController extends Controller {

	@Autowired
	SystemUserService systemUserService;
	@Autowired
	ExamPaperService examPaperService;
	@Autowired
	LogStudyCvUnitService logStudyCvUnitService;
	@Autowired
	CvUnitService cvUnitService;
	@Autowired
	TopicDiscussionService topicDiscussionService;
	@Autowired
	LogStudyCvSetService logStudyCvSetService;
	/**
	 * getTopicDiscuss:
	 * 获取随堂考试内容
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @param unitId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@RequestMapping("/getExamInfo")
	public RtnBody getExamInfo(String userId, String projectId, String unitId){
		RtnBody rtn = new RtnBody();
		if (StrKit.isBlank(projectId) || StrKit.isBlank(unitId)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("请检查必输项！");
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		Record examPaper = examPaperService.getExamInfo(user.getId(), Integer.valueOf(projectId), Integer.valueOf(unitId));
		return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，获取成功！").data(examPaper);
	}
	
	/**
	 * submitExamInfo:
	 * 随堂考试内容提交
	 * 首先将提交的每个试题内容、该试题所得的分数保存到log_exam表和log_exam_result表中，
	 * 然后根据所得答题分数以及单元设定的任务点和达标要求更新log_study_cv_unit表
	 * 
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @param unitId
	 * @param  @param questionJson
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@Transactional
	@RequestMapping("/submitExamInfo")
	public RtnBody submitExamInfo(String userId, String projectId, String unitId, String questionJson){
		RtnBody rtn = new RtnBody();
		if (StrKit.isBlank(projectId) || StrKit.isBlank(unitId) || StrKit.isBlank(questionJson)) {
			return rtn.code(BusinessConst.CODE_PARAM_EMPTY).message("请检查必输项！");
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		//根据单元Id和userId查询单元学习学习
		LogStudyCvUnit logStudyCvUnit = logStudyCvUnitService.getLogStudyByUnitIdAndUserId(user.getId(), Integer.valueOf(unitId));
		if (logStudyCvUnit != null && logStudyCvUnit.getStatus() == 2) {
			return rtn.code(BusinessConst.STUDY_HAVE_LEARN).message("你已经通过考试不可再考！");
		}
		int questRightNum = 0;//答对的题目数量
		int questNotRightNum = 0 ;//答错的题目数量
		//根据单元id得到随堂考试试卷id，试卷名称，达标要求,考试id
		Record exam = examPaperService.getExamPaperByUnitId(Integer.valueOf(unitId));
		//根据考试id查询考试信息
		ExamExamination examination = examPaperService.getExamById(Integer.valueOf((String)exam.get("examId")));
		JSONObject question = getJsonPara(questionJson);
		Integer paperId = question.getInteger("paperId");
		JSONArray questionArray = question.getJSONArray("titleList");
		double totalScore = 0;
		//1.首先将提交的每个试题内容、该试题所得的分数保存到log_exam表和log_exam_result表中
		if (questionArray != null && questionArray.size()>0) {
			for (int i=0;i<questionArray.size();i++) {
				JSONObject jo = (JSONObject) questionArray.get(i);
				Integer questionId = Integer.valueOf(jo.get("questionId").toString()) ;
				Integer questionLabelId = Integer.valueOf(jo.get("questionLabelId").toString()) ;
				//实例化考试日志试题类
				LogExam examLog = new LogExam();
				examLog.setUserId(user.getId());//设置用户Id
				examLog.setExamSubTypeId(24);//设置系统Id 默认 24
				examLog.setExaminationId(examination.getId());//设置考试Id
				examLog.setExamName(examination.getName());//设置考试名称
				examLog.setExamTypeId(examination.getExamTypeId());//设置考试类别id
				examLog.setExamType(examination.getExamType());//设置考试分类
				examLog.setTestpaperId(paperId);//设置试卷Id
				examLog.setIp(BusinessUtil.getIpAddr(request));//设置客户Ip
				Double score = examPaperService.getQueScoreByQIdAndPId(questionId, paperId);
				double realityscore = 0;
				//判断是否答对
				//通过试题id获取答案
				List<ExamQuestionKey> eqkList = examPaperService.listQuestionKeyByQId(questionId);
				boolean questResult = false ;
				String selectResult = "" ;
				//单选题
				if (questionLabelId == 1 || questionLabelId == 2) {
					//得到选项列表，如果是单选题，则列表中只有一条数据
					JSONArray keyArr = jo.getJSONArray("optionList");
					String keyId = ((JSONObject)keyArr.get(0)).get("optionId").toString();
					selectResult = keyId;
					if (eqkList != null && eqkList.size() > 0) {
						for (ExamQuestionKey eqkObj : eqkList) {
							if (eqkObj.getIsnotTrue() == 1 && (eqkObj.getId().toString()).equals(keyId)) {
								questResult = true ;
								break ;
							}
						}
					}
				}
				//多选题
				if (questionLabelId == 11) {
					//得到选中的选项列表
					JSONArray keyArr = jo.getJSONArray("optionList");
					for (int j = 0 ; j < keyArr.size() ; j++) {
						JSONObject userQuestKey = (JSONObject) keyArr.get(j);
						String userQk = userQuestKey.getString("optionId");
						selectResult += userQk+",";
					}
					if (eqkList != null && eqkList.size() > 0) {
						int keyIsTrueNum = 0 ;
						int userQuestKeyNum = 0 ;
						for (ExamQuestionKey eqkObj : eqkList) {
							if (eqkObj.getIsnotTrue() == 1) {
								keyIsTrueNum ++ ;
								for (int j = 0 ; j < keyArr.size() ; j++) {
									JSONObject userQuestKey = (JSONObject) keyArr.get(j);
									String userQk = userQuestKey.getString("optionId");
									String tmpEqkId = eqkObj.getId().toString() ;
									if (userQk.equals(tmpEqkId)) userQuestKeyNum++ ;
								}
							}
						}
						
						if (keyIsTrueNum == userQuestKeyNum) { 
							questResult = true ;
						}
					}
				}
				if (questionLabelId == 13) {//判断题
					String content = jo.getString("qtnContent");
					selectResult = content;
					if (eqkList != null && eqkList.size()>0) {
						Integer eqk = eqkList.get(0).getIsnotTrue();
						if (eqk.equals(content)) {
							questResult = true ;
						}
					}
				}
				if (questionLabelId == 12) {//12填空题,
					String content = jo.getString("qtnContent");
					selectResult = content;
					if (eqkList != null && eqkList.size()>0) {
						String eqk = eqkList.get(0).getContent();
						if (eqk.equals(content)) {
							questResult = true ;
						}
					}
				}
				if (questionLabelId == 14 || questionLabelId == 18 || questionLabelId == 20) {//14简答题,18名词解释,20案例分析题
					String content = jo.getString("qtnContent");
					selectResult = content;
					//只要填了就算对
					if (StrKit.notBlank(content)) {
						questResult = true ;
					}
				}
				if (questResult) {	
					realityscore = score;
					totalScore += score;
					examLog.setResult(totalScore);//设置试题分数
					examLog.setIsnotPass(0);
					questRightNum++;
				} else {
					examLog.setResult(totalScore);	
					examLog.setIsnotPass(-1);
					questNotRightNum++;
				}
				//判断是否参加过这次考试
				int logExamId = 0;
				LogExam log = examPaperService.getLogExamByUIdAndExamId(user.getId(), Integer.valueOf((String)exam.get("examId")));
				if (log != null) {
					//执行修改操作
					log.setUserId(null);//拆分表不能修改分片字段，所以要把userId置空
					log.setResult(examLog.getResult());	//修改总分数		
					log.setIsnotPass(examLog.getIsnotPass());//修改是否通过
					examPaperService.updateLogExam(log);
					logExamId = log.getId();
				} else {
					examPaperService.saveLogExam(examLog);
					logExamId = examLog.getId();
				}
				//保存考试结果表
				//实例化试题答案实体类
				LogExamResult logExamResult = new LogExamResult();
				logExamResult.setLogExamId(logExamId);//设置考试日志Id
				logExamResult.setQuestionId(questionId);//设置试题Id
				//设置是否正确
				if (questResult) {
					logExamResult.setIsnotRight(1) ;
				} else {
					logExamResult.setIsnotRight(0) ;
				}
				logExamResult.setQuestionlabelId(questionLabelId);//设置试题类型
				logExamResult.setParentId(0);//设置父试题Id
				logExamResult.setScore(score);//设置分数
				logExamResult.setSelectResult(selectResult);//设置选项Id
				logExamResult.setRealityscore(realityscore);// 真实分数
				
				LogExamResult result = examPaperService.getLogExamResultByQIdAndExamId(questionId, logExamId);
				if (result != null) {
					examPaperService.updateLogExamResult(logExamResult);
				} else {
					examPaperService.saveLogExamResult(logExamResult);
				}
			}
		}
		//2.根据答题情况更新log_study_cv_unit表
		CvUnit cvUnit = cvUnitService.getCvUnitById(Integer.valueOf(unitId));
		//判断该单元是否为任务点以及单元达标要求是否为空
		if (cvUnit != null && cvUnit.getPoint() ==1 && cvUnit.getQuota() != null) {
			if(totalScore >= cvUnit.getQuota()){
				LogStudyCvUnit  units = new LogStudyCvUnit();
				units.setSystemUserId(user.getId());
				units.setCvUnitId(Integer.valueOf(unitId));
				units.setStatus(BusinessConst.STUDY_HAVE_LEARN);
				logStudyCvUnitService.updateCvUnitLogStudyByUserIdAndUnitId(units);
								
				//更新log_exam表
				LogExam logExam = examPaperService.getLogExamByUIdAndExamId(user.getId(), Integer.valueOf((String)exam.get("examId")));
				logExam.setResult(totalScore);
				logExam.setIsnotPass(0);
				logExam.setUserId(null);//拆分表不能修改分片字段，所以要把userId置空
				examPaperService.updateLogExam(logExam);
				return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜您，通过了本次考试！本次考试，您答对了"+questRightNum+"道题，答错了"+questNotRightNum
						+"道题，得分："+totalScore+"分，达到达标要求。");
			}else{
				LogExam logExam = examPaperService.getLogExamByUIdAndExamId(user.getId(), Integer.valueOf((String)exam.get("examId")));
				logExam.setResult(totalScore);
				logExam.setIsnotPass(-1);
				logExam.setUserId(null);//拆分表不能修改分片字段，所以要把userId置空
				examPaperService.updateLogExam(logExam);
				return rtn.code(BusinessConst.NOT_PASS_EXAM).message("很遗憾，您未通过本次考试！本次考试，您答对了"+questRightNum+"道题，答错了"+questNotRightNum
						+"道题，得分："+totalScore+"分，未达到达标要求。");
			}
		} else {
			LogStudyCvUnit logCvUnit = new LogStudyCvUnit();
			logCvUnit.setSystemUserId(user.getId());
			logCvUnit.setCvUnitId(Integer.valueOf(unitId));
			logCvUnit.setStatus(BusinessConst.STUDY_HAVE_LEARN);
			logStudyCvUnitService.updateCvUnitLogStudyByUserIdAndUnitId(logCvUnit);
			
			//更新log_exam表
			LogExam logExam = examPaperService.getLogExamByUIdAndExamId(user.getId(), Integer.valueOf((String)exam.get("examId")));
			logExam.setResult(totalScore);
			logExam.setIsnotPass(0);
			logExam.setUserId(null);//拆分表不能修改分片字段，所以要把userId置空
			examPaperService.updateLogExam(logExam);
			return rtn.code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜您，通过了本次考试！本次考试，您答对了"+questRightNum+"道题，答错了"+questNotRightNum
					+"道题，得分："+totalScore+"分，达到达标要求。");
		}
	}
	
	
	@RequestMapping("/getTopicDiscuss")

	public RtnBody getTopicDiscuss(String projectId,String unitId){
		
		if(StrKit.isBlank(projectId) || StrKit.isBlank(unitId)){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请求参数不能为空.");
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		
		Record record = topicDiscussionService.getTopicDiscuss(unitId);
		
		CvSetUnitDiscuss discussSum = new CvSetUnitDiscuss();
		discussSum.setCvUnitId(Integer.valueOf(unitId));
		discussSum.setSystemUserId(Integer.valueOf(user.getId()));
		discussSum.setDiscussType(2);
		int sum = 0;
		sum = topicDiscussionService.CountTalk(discussSum);
		if (record != null && record.get("unitQuota").toString() != null) {
			if (sum < Integer.parseInt(record.get("unitQuota").toString())) {
				record.put("isQuota", 0);
			} else {
				record.put("isQuota", 1);
			}
		}
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).data(record).message("success.");
	}
	
	
	
	/**
	 * submitTopicDiscuss:提交主题评论
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param projectId
	 * @param  @param unitId
	 * @param  @param disscussContent
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@Transactional
	@RequestMapping("/submitTopicDiscuss")
	
	public RtnBody submitTopicDiscuss(String projectId,String unitId,String cvId,String disscussContent){
		try {
			disscussContent = URLDecoder.decode(disscussContent,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(StrKit.isBlank(unitId) || StrKit.isBlank(projectId) || StrKit.isBlank(cvId) || "undefined".equals(cvId)){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请求参数不能为空.");
		}
		if(StrKit.isBlank(disscussContent)){
			
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("讨论内容不能为空。");
		}
		
		
		String caseId = getPara("caseId"); //原业务牵扯，目前接口未传此参数
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		Integer topicId = topicDiscussionService.getTopicIdByUnitId(Integer.valueOf(unitId));
		CvSetUnitDiscuss discuss = new CvSetUnitDiscuss();
		discuss.setSystemUserId(user.getId());
		discuss.setCvSetId(Integer.valueOf(projectId));
		discuss.setCvUnitId((Integer.valueOf(unitId)));
		discuss.setDiscussContent(disscussContent);
		discuss.setDiscussId(topicId);
		
		 topicDiscussionService.submitTopicDiscuss(discuss);
		 int id = discuss.getId();
		
		log.info("讨论id：{}",id);
		boolean passFlag = false ;

		if(id > 0){
			
			CvUnit cvUnit = topicDiscussionService.getCvUnit(unitId);
			
			Integer cvunitPoint = cvUnit.getPoint() ;
			Double  cvunitQuota = cvUnit.getQuota() ;
			com.ncme.springboot.model.CvSetUnitDiscuss discussSum = new com.ncme.springboot.model.CvSetUnitDiscuss();
			discussSum.setCvUnitId(Integer.valueOf(unitId));
			discussSum.setSystemUserId(Integer.valueOf(user.getId()));
			int sum=0;
			if (cvunitPoint != null && cvunitPoint == 1) {
				if (cvunitQuota != null) {					
					if(StrKit.notBlank(caseId)){
						discussSum.setDiscussType(1);
					} else {
						discussSum.setDiscussType(2);
					}
					sum = topicDiscussionService.CountTalk(discussSum);
					if (sum >= cvunitQuota) passFlag = true ;
				}else {
					passFlag = true ;
				}
			} else {
				passFlag = true ;
			}
			// 讨论条数达标更改学习单元的状态
			LogStudyCvUnit unit = new LogStudyCvUnit();
			unit.setCvId(Integer.valueOf(cvId));
			unit.setLogStudyCvSetId(Integer.valueOf(projectId));
			unit.setSystemUserId(discussSum.getSystemUserId());
			unit.setCvUnitId(discussSum.getCvUnitId());
			if (passFlag) {
				unit.setStatus(2);
			} else {
				unit.setStatus(1);
			}
			topicDiscussionService.updateLogCvSetUnit(unit);
			
			Record record =topicDiscussionService.getLastTopicDiscuss(id);
			record.put("disscussNum", sum);
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("success.").data(record);
		}else{
			
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("服务器异常，保存失败。");
		}
		
	}
	
	/**
	 * initializeCVAndCVSetStudyLog:
	 * 初始化项目和课程以及单元学习记录
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @param cvId
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@Transactional
	@RequestMapping("/initializeCVAndCVSetStudyLog")
	public RtnBody initializeCVAndCVSetStudyLog(String userId, String projectId, String cvId, String cvUnitId){
		if(StrKit.isBlank(projectId) || StrKit.isBlank(cvId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请求参数不能为空.");
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		try {
			//课程学习记录表处理
			logStudyCvSetService.updateCvForLogStudy(user.getId(), Integer.valueOf(projectId), Integer.valueOf(cvId));
			//课程学习记录表处理
			logStudyCvSetService.updateCVSetForLogStudy(user.getId(), Integer.valueOf(projectId), Integer.valueOf(cvId));
			//课程单元学习记录表处理
			logStudyCvSetService.updateCvUnitForLogStudy(user.getId(), Integer.valueOf(projectId), Integer.valueOf(cvId), Integer.valueOf(cvUnitId));
		} catch (Exception e) {
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("初始化视频记录失败！");
		}
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，保存成功！");
	}

	/**
	 * saveVideoStudyLog:
	 * 更新视频单元学习记录(用于课程单元是视频时)
	 * @param  @param projectId
	 * @param  @param video
	 * @param  @param result
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@Transactional
	@RequestMapping("/saveVideoStudyLog")
	public RtnBody saveVideoStudyLog(String projectId, @Validated LogStudyCvUnitVideo video, BindingResult result){
		if(StrKit.isBlank(projectId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请求参数不能为空.");
		}
		String message = validate(result);// 字段校验动作
		if(message != null){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message(message);
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		video.setSystemUserId(user.getId());
		video.setEndDate(new Date());
		LogStudyCvUnit logStudyCvUnit = logStudyCvUnitService.getLogStudyByUnitIdAndUserId(user.getId(), video.getCvUnitId());
		if (logStudyCvUnit != null) {
			video.setLogStudyCvUnitId(logStudyCvUnit.getId());
		}
		try {
			logStudyCvSetService.saveOrUpdateLogStudyCvUnitVideo(video);
			//课程学习记录表处理
			logStudyCvSetService.updateCvForLogStudy(user.getId(), Integer.valueOf(projectId), video.getCvId());
			//课程学习记录表处理
			logStudyCvSetService.updateCVSetForLogStudy(user.getId(), Integer.valueOf(projectId), video.getCvId());
		} catch (Exception e) {
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("保存视频记录失败！");
		}
		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，保存成功！");
	}
	
	/**
	 * saveCensusVideoStudyLog:
	 * 统计记录视频实际学习时间
	 * @param  @param projectId
	 * @param  @param videoCensus
	 * @param  @param result
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	@Transactional
	@RequestMapping("/saveCensusVideoStudyLog")
	public RtnBody saveCensusVideoStudyLog(String projectId, @Validated LogStudyCvUnitVideoCensus videoCensus, BindingResult result){
		if(StrKit.isBlank(projectId)){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message("请求参数不能为空.");
		}
		String message = validate(result);// 字段校验动作
		if(message != null){
			return getRtnBody().code(BusinessConst.CODE_PARAM_EMPTY).message(message);
		}
		SystemUser user = SystemUserUtil.getLoginUser(request);
		if (user == null) {
			return getRtnBody().code(BusinessConst.USER_NOT_LOGIN).message("用户未登录或者Token已过期！");
		}
		videoCensus.setSystemUserId(user.getId());
		videoCensus.setCreateDate(new Date());
		videoCensus.setCvSetId(Integer.valueOf(projectId));
		try {
			logStudyCvSetService.saveLogStudyCvUnitVideoCensus(videoCensus);
		} catch (Exception e) {
			return getRtnBody().code(BusinessConst.CODE_RESPONSE_FAIL).message("保存视频记录失败！");
		}
		
		return getRtnBody().code(BusinessConst.CODE_RESPONSE_SUCCESS).message("恭喜你，保存成功！");
	}
}
