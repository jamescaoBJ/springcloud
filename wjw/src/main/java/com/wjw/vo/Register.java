package com.wjw.vo;


public class Register {
    private Integer documentType;     	//证件类型 身份证:1,军官证:2,港澳/台通行证:3,护照:4
    private String phone;				//用户手机号
    private String password;			//用户登录密码
    private String idCard;				//用户身份证号
    private String name;				//用户真实姓名
    private String username;			//用户登录名称
    private Integer sex;				//用户性别 0:男  man 1:女female (数据库 1:男  2:女)
    private String company;				//单位名称
    private Integer companyId;			//单位名称ID
    private String proviceId;			//省ID
    private String cityId;				//市ID
    private String districtId;			//区ID
    private String titleId;				//职称ID
    private String subject;				//学科
    private String subjectId;			//学科ID
    private String practitionerNum;		//用户执业医师号
    private String education;			//用户学历
    private Integer educationId;		//用户学历Id
    private Integer grassroot;			//用户是否来自基层 1:是  0:否
    private String address;				//用户地址
    private String code;				//验证码
    private String confirmPassword;		//用户确认密码
    private String jobTypeId;           //职务类型ID 例 1:医疗人员 对应的 98953
    private String jobType;           	//职务类型ID 例 1:医疗人员 
	
	public Integer getDocumentType() {
		return documentType;
	}
	public void setDocumentType(Integer documentType) {
		this.documentType = documentType;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getProviceId() {
		return proviceId;
	}
	public void setProviceId(String proviceId) {
		this.proviceId = proviceId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	public String getTitleId() {
		return titleId;
	}
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getPractitionerNum() {
		return practitionerNum;
	}
	public void setPractitionerNum(String practitionerNum) {
		this.practitionerNum = practitionerNum;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Integer getEducationId() {
		return educationId;
	}
	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}
	public Integer getGrassroot() {
		return grassroot;
	}
	public void setGrassroot(Integer grassroot) {
		this.grassroot = grassroot;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getJobTypeId() {
		return jobTypeId;
	}
	public void setJobTypeId(String jobTypeId) {
		this.jobTypeId = jobTypeId;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

}