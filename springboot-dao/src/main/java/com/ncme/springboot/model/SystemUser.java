package com.ncme.springboot.model;

import java.util.Date;

public class SystemUser {
    private Integer id;

    private String realName;

    private Date birthday;

    private Integer sex;

    private String mobilPhone;

    private String telphone;

    private String email;

    private Integer certificateType;

    private String certificateNo;

    private String workUnit;

    private String contactAddress;

    private String postCode;

    private String profession;

    private String deptName;

    private String profTitle;

    private String passwordQuestion;

    private String passwordQuestionAnswer;

    private Integer status;

    private Date lastLoginDate;

    private String lastLoginIp;

    private Integer age;

    private Integer workUnitId;

    private Integer education;

    private Date regDate;

    private String healthCertificate;

    private String icCardInt;

    private String userType;

    private Integer userImage;

    private String hospitalAddress;

    private String userAvatar;

    private String otherHospitalName;

    private Integer loginErrorNum;

    private Long loginErrorFirstTime;

    private Long loginErrorLastTime;

    private Date lastUpdateDate;
    
    private Integer grassroot;     	//是否来自基层1:是  0:否
    
    private Integer userProvinceId;
    
    private String openid;
    
    private String accountName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobilPhone() {
        return mobilPhone;
    }

    public void setMobilPhone(String mobilPhone) {
        this.mobilPhone = mobilPhone;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getProfTitle() {
        return profTitle;
    }

    public void setProfTitle(String profTitle) {
        this.profTitle = profTitle;
    }

    public String getPasswordQuestion() {
        return passwordQuestion;
    }

    public void setPasswordQuestion(String passwordQuestion) {
        this.passwordQuestion = passwordQuestion;
    }

    public String getPasswordQuestionAnswer() {
        return passwordQuestionAnswer;
    }

    public void setPasswordQuestionAnswer(String passwordQuestionAnswer) {
        this.passwordQuestionAnswer = passwordQuestionAnswer;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWorkUnitId() {
        return workUnitId;
    }

    public void setWorkUnitId(Integer workUnitId) {
        this.workUnitId = workUnitId;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getHealthCertificate() {
        return healthCertificate;
    }

    public void setHealthCertificate(String healthCertificate) {
        this.healthCertificate = healthCertificate;
    }

    public String getIcCardInt() {
        return icCardInt;
    }

    public void setIcCardInt(String icCardInt) {
        this.icCardInt = icCardInt;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getUserImage() {
        return userImage;
    }

    public void setUserImage(Integer userImage) {
        this.userImage = userImage;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getOtherHospitalName() {
        return otherHospitalName;
    }

    public void setOtherHospitalName(String otherHospitalName) {
        this.otherHospitalName = otherHospitalName;
    }

    public Integer getLoginErrorNum() {
        return loginErrorNum;
    }

    public void setLoginErrorNum(Integer loginErrorNum) {
        this.loginErrorNum = loginErrorNum;
    }

    public Long getLoginErrorFirstTime() {
        return loginErrorFirstTime;
    }

    public void setLoginErrorFirstTime(Long loginErrorFirstTime) {
        this.loginErrorFirstTime = loginErrorFirstTime;
    }

    public Long getLoginErrorLastTime() {
        return loginErrorLastTime;
    }

    public void setLoginErrorLastTime(Long loginErrorLastTime) {
        this.loginErrorLastTime = loginErrorLastTime;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

	public Integer getGrassroot() {
		return grassroot;
	}

	public void setGrassroot(Integer grassroot) {
		this.grassroot = grassroot;
	}

	public Integer getUserProvinceId() {
		return userProvinceId;
	}

	public void setUserProvinceId(Integer userProvinceId) {
		this.userProvinceId = userProvinceId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
    
}