package com.wjw.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * ClassName:MyX509TrustManager
 * Function: 信任管理器
 * Reason:	 TODO ADD REASON
 *
 * @author   Admin
 * @version  
 * @since    version 1.0
 * @Date	 2018年1月16日	上午11:24:57
 *
 * @see 	 
 *  
 */
public class MyX509TrustManager implements X509TrustManager {

	/**
	 * 检查客户端证书
	 */
	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	/**
	 * 检查服务器端证书
	 */
	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	/**
	 * 返回受信任的X509证书数组
	 */
	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;

	}

}
