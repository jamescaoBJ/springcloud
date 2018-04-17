package com.wjw.service;

import java.util.List;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.ExamExamination;
import com.ncme.springboot.model.ExamQuestionKey;
import com.ncme.springboot.model.LogExam;
import com.ncme.springboot.model.LogExamResult;

/**
 * ClassName:ExamPaperService
 * Function: 随堂考试Service
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月17日	上午10:17:13
 *
 * @see 	 
 *  
 */
public interface ExamPaperService {

	/**
	 * getExamInfo:
	 * 获取随堂考试内容
	 * @param  @param userId
	 * @param  @param projectId
	 * @param  @param unitId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	Record getExamInfo(Integer userId, Integer projectId, Integer unitId);
	
	/**
	 * getExamPaperByUnitId:
	 * 根据单元id得到随堂考试试卷id，试卷名称，达标要求,考试id
	 * @param  @param unitId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	Record getExamPaperByUnitId(Integer unitId);
	
	/**
	 * getExamById:
	 * 根据考试id获取考试内容
	 * @param  @param examId
	 * @param  @return    
	 * @return ExamExamination    
	 * @throws 
	 * @since  　version 1.0
	*/
	ExamExamination getExamById(Integer examId);
	
	/**
	 * getQueScoreByQIdAndPId:
	 * 根据问题Id和试卷id查询该试题分数
	 * @param  @param questionId
	 * @param  @param paperId
	 * @param  @return    
	 * @return Double    
	 * @throws 
	 * @since  　version 1.0
	*/
	Double getQueScoreByQIdAndPId(Integer questionId, Integer paperId);
	
	 /**
	 * listQuestionKeyByQId:
	 * 根据试题id查询试题选项
	 * @param  @param questionId
	 * @param  @return    
	 * @return List<ExamQuestionKey>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<ExamQuestionKey> listQuestionKeyByQId(Integer questionId);
	
	/**
	 * getLogExamByUIdAndExamId:
	 * 根据用户Id 考试Id查询是否参加过考试
	 *
	 * @param  @param userId
	 * @param  @param examId
	 * @param  @return    
	 * @return LogExam    
	 * @throws 
	 * @since  　version 1.0
	*/
	LogExam getLogExamByUIdAndExamId(Integer userId, Integer examId);
	
	/**
	 * saveLogExam:
	 * 保存考试记录表
	 * @param  @param logExam
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	void saveLogExam(LogExam logExam);
	
	/**
	 * updateLogExam:
	 * 修改考试记录表
	 * @param  @param logExam
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	int updateLogExam(LogExam logExam);
	
	/**
	 * getLogExamResultByQIdAndExamId:
	 * 根据试题id和试卷id查询考试日志结果表
	 * @param  @param questionId
	 * @param  @param ExamId
	 * @param  @return    
	 * @return LogExamResult    
	 * @throws 
	 * @since  　version 1.0
	*/
	LogExamResult getLogExamResultByQIdAndExamId(Integer questionId, Integer examId);
	
	/**
	 * saveLogExamResult:
	 * 保存考试日志结果记录表
	 * @param  @param logExamResult
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	int saveLogExamResult(LogExamResult logExamResult);
	
	/**
	 * updateLogExamResult:
	 * 保存考试日志结果记录表
	 *
	 * @param  @param logExamResult
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	int updateLogExamResult(LogExamResult logExamResult);
}
