package com.wjw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.mapper.CvUnitMapper;
import com.ncme.springboot.mapper.ExamExaminationMapper;
import com.ncme.springboot.mapper.ExamPaperQuestionMapper;
import com.ncme.springboot.mapper.ExamQuestionKeyMapper;
import com.ncme.springboot.mapper.ExamQuestionMapper;
import com.ncme.springboot.mapper.LogExamMapper;
import com.ncme.springboot.mapper.LogExamResultMapper;
import com.ncme.springboot.mapper.LogStudyCvUnitMapper;
import com.ncme.springboot.model.ExamExamination;
import com.ncme.springboot.model.ExamQuestion;
import com.ncme.springboot.model.ExamQuestionKey;
import com.ncme.springboot.model.LogExam;
import com.ncme.springboot.model.LogExamResult;
import com.ncme.springboot.model.LogExamResultKey;
import com.ncme.springboot.model.LogStudyCvUnit;
import com.wjw.service.ExamPaperService;

@Service
public class ExamPaperServiceImpl implements ExamPaperService {

	@Autowired
	CvUnitMapper cvUnitMapper;
	@Autowired
	ExamQuestionMapper examQuestionMapper;
	@Autowired
	ExamQuestionKeyMapper questionKeyMapper;
	@Autowired
	ExamExaminationMapper examExaminationMapper;
	@Autowired
	ExamPaperQuestionMapper paperQuestionMapper;
	@Autowired
	LogExamMapper logExamMapper;
	@Autowired
	LogExamResultMapper logExamResultMapper;
	@Autowired
	LogStudyCvUnitMapper logStudyCvUnitMapper;
	@Override
	public Record getExamInfo(Integer userId, Integer projectId, Integer unitId) {

		// TODO Auto-generated method stub
		//根据单元id得到随堂考试试卷id，试卷名称，达标要求
		Record paper = cvUnitMapper.getExamPaperByUnitId(unitId);
		//判断是否通过考试
		LogStudyCvUnit logStudyCvUnit = logStudyCvUnitMapper.getLogStudyByUnitIdAndUserId(userId,unitId);
		if (logStudyCvUnit != null) {
			Integer status = logStudyCvUnit.getStatus();
			if (status == 2) {
				paper.put("isPassExam", true);
			} else {
				paper.put("isPassExam", false);
			}
		} else {
			paper.put("isPassExam", false);
		}
		//根据试卷id查询试题内容
		List<Record> queList = new ArrayList<Record>();
		List<ExamQuestion> examQuestionList = examQuestionMapper.getQuestionByPaperId((Integer)paper.get("paperId"));
		if (examQuestionList != null && examQuestionList.size()>0) {
			for (ExamQuestion question:examQuestionList) {
				Record record = new Record();
				// 如果是父试题
				if (question.getParentId() == 0) {
					// 查询子试题
					List<ExamQuestion> childQuestion = examQuestionMapper.listQuestionByParentId(question.getId());
					if (childQuestion != null && childQuestion.size()>0) {
						List<Record> childrens = new ArrayList<Record>();
						for (ExamQuestion q:childQuestion) {
							Record childRecord = new Record();
							List<Record> childKeyList = questionKeyMapper.getQuestionKeyByQId(q.getId());
							childRecord.put("questionId", q.getId());
							childRecord.put("questionLabelId", q.getQuestionLabelId());
							childRecord.put("questionContent", q.getContent());
							childRecord.put("answers", childKeyList);
							childrens.add(childRecord);
						}
						record.put("childrens", childrens);
					}
					
				} 
				//查询试题选项
				List<Record> keyList = questionKeyMapper.getQuestionKeyByQId(question.getId());
				record.put("questionId", question.getId());
				record.put("questionLabelId", question.getQuestionLabelId());
				record.put("questionContent", question.getContent());
				record.put("answers", keyList);
				queList.add(record);
			}
		}
		paper.put("queList", queList);
		return paper;

	}
	@Override
	public Record getExamPaperByUnitId(Integer unitId) {
		
		Record paper = cvUnitMapper.getExamPaperByUnitId(unitId);
		return paper;
		
	}
	@Override
	public ExamExamination getExamById(Integer examId) {
		
		return examExaminationMapper.selectByPrimaryKey(examId);
		
	}
	@Override
	public Double getQueScoreByQIdAndPId(Integer questionId, Integer paperId) {
		
		return paperQuestionMapper.getQueScoreByQIdAndPId(questionId, paperId);
		
	}
	@Override
	public List<ExamQuestionKey> listQuestionKeyByQId(Integer questionId) {
		
		return questionKeyMapper.listQuestionKeyByQId(questionId);
		
	}
	@Override
	public LogExam getLogExamByUIdAndExamId(Integer userId, Integer examId) {
		
		return logExamMapper.getLogExamByUIdAndExamId(userId, examId);
		
	}
	@Override
	public void saveLogExam(LogExam logExam) {
		
		logExamMapper.saveLogExam(logExam);
		
	}
	@Override
	public int updateLogExam(LogExam logExam) {
		
		return logExamMapper.updateByPrimaryKeySelective(logExam);
		
	}
	@Override
	public LogExamResult getLogExamResultByQIdAndExamId(Integer questionId, Integer examId) {
		LogExamResultKey key = new LogExamResultKey();
		key.setLogExamId(examId);
		key.setQuestionId(questionId);
		LogExamResult logExamResult = logExamResultMapper.selectByPrimaryKey(key);
		return logExamResult;
	}
	@Override
	public int saveLogExamResult(LogExamResult logExamResult) {
		
		return logExamResultMapper.insert(logExamResult);
		
	}
	@Override
	public int updateLogExamResult(LogExamResult logExamResult) {
		
		return logExamResultMapper.updateByPrimaryKey(logExamResult);
		
	}

}
