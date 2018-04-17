package com.ncme.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.CvLive;
import com.ncme.springboot.model.LogStudyCvUnit;
import com.ncme.springboot.model.SystemUser;

public interface CvLiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CvLive record);

    int insertSelective(CvLive record);

    CvLive selectByPrimaryKey(Integer id);
    
    //根据cv_id获取CvLive
    CvLive selectByCvId(Integer id);
   
    int updateByPrimaryKeySelective(CvLive record);

    int updateByPrimaryKey(CvLive record);
    
    //获取当前直播在线人数（暂不使用）
    String getOnlineNum(String classNo);
    
    //获取直播回放人数（暂不使用）
    String getHuiFangNum(Integer cvId);
    
    //获取直播列表信息
    List<Record> getCvList(Map<String,Object> map);
   
    //根据课程ID获取项目List
    List<Record> cvForProvinceManager(Integer cvId);

    //
    List<Record> propCount(Integer cvSetId);
    
    //
    int userPropCount(Map<String,Object> map);
    
    //根据课程ID获取教师
    List<Record> selectTeacher(Integer cvId);
    
    //获取当前直播在线学习人数
    int getStudyNumForOnline(Integer cvId);
    
    //获取直播结束时学习人数
    int getStudyNumForEnd(Integer cvId);
    
    //获取直播回放学习人数
    int getStudyNumForViewBack(Integer cvId);
    
    //获取回放地址列表
    List<Record> getCoursewareList(String classNo);
    
    //根据课程ID获取其项目
    Record getCvSet(Integer cvId);
    
    //根据课程ID 获取课程学习次数
    int getCourseLearnNum(Integer cvId);
    
    //获取直播详情信息
    List<Record> getDetail(Map<String,Object> map);

    //直播课程报名
	void signUpInfo(@Param("userId")String userId, @Param("cvId")String cvId, @Param("date")String date);
	
	//验证用户是否已报名过
	int checkSignUp(@Param("userId")String userId, @Param("cvId")String cvId);
	
    /**
     * myStudyForCvLive:
     * 我的学习列表之直播学习列表
     * @param  @param userId
     * @param  @return    
     * @return List<Record>    
     * @throws 
     * @since  　version 1.0
    */
    List<Record> myStudyForCvLive(@Param("userId")Integer userId);
    
    /**
     * getSignUpCountByCvId:
     * 根据课程id得到直播报名人数
     * @param  @param cvId
     * @param  @return    
     * @return Integer    
     * @throws 
     * @since  　version 1.0
    */
    Integer getSignUpCountByCvId(Integer cvId);
    
    
    List<Record> selectCVUnitByCvId(@Param("cvId")Integer cvId);
    
    //根据单元id判断是否存在记录(log_study_cv_unit)
    List<Record> queryLogStudyCVUnitByUnitId(Map<String,Object> map);
    
    void updLogStudyCVUnit(LogStudyCvUnit record);
    
    int insertLogStudyCVUnit(LogStudyCvUnit record);
    
    //判断是否存在记录(log_study_cv_set)
    List<Record> queryLogStudyCVSet(Map<String,Object> map);
    
    void updLogStudyCVSet(LogStudyCvUnit record);
    
    int insertLogStudyCVSet(LogStudyCvUnit record);

    //判断是否存在记录(log_study_cv)
    List<Record> queryLogStudyCv(Map<String,Object> map);

    void updLogStudyCv(LogStudyCvUnit record);
    
    int insertLogStudyCv(LogStudyCvUnit record);
    
    
}