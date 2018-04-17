package com.ncme.springboot.model;


public class SystemAccount {

	private Integer accountId;

    private String accountName;

    private String accountPassword;

    private String accountRemark;

    private Integer userId;

    private Integer siteId;

    private Integer accountStatus;
    
    /**
     * Creates a new instance of SystemAccount. 暂时只定义这两个通用字段，其他的根据业务后期慢慢调整
     *
     * @param accountId
     * @param accountName
     */
    public SystemAccount(String accountId,String accountName){
    	
    	this.accountId = Integer.valueOf(accountId);
    	this.accountName = accountName;
    	
    	
    }
    
    public SystemAccount(){
    	
    	
    }
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountRemark() {
        return accountRemark;
    }

    public void setAccountRemark(String accountRemark) {
        this.accountRemark = accountRemark;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }
}