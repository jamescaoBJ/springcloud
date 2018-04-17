package com.wjw.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.ncme.springboot.footstone.util.StrKit;
import com.wjw.service.RedisService;

/**
 * ClassName:SignUtil
 * Function: 微信工具类
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2018年1月30日	上午9:23:04
 *
 * @see 	 
 *  
 */
@Component
public class SignUtil {

	public static final Logger log = LoggerFactory.getLogger(SignUtil.class);
	
	@Autowired
	private RedisService redisService;
	private static SignUtil signUtil;

	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}
	
	@PostConstruct  
    public void init() {  
		signUtil = this;  
		signUtil.redisService = this.redisService;  
    }  

	// 与接口配置信息中的Token要一致  
    private static String token = "ncmeToken";  
    public static String APPID	= "wx1a64b4795ed26293";//继教网内测Appid  wx1a64b4795ed26293
    public static String APPSECRET = "8d1c589c5ba54f667fad6f7e8d0860e8";//继教网密钥   8d1c589c5ba54f667fad6f7e8d0860e8
  
    /** 
     * 验证签名 
     *  
     * @param signature 
     * @param timestamp 
     * @param nonce 
     * @return 
     */  
    public static boolean checkSignature(String signature, String timestamp, String nonce) {  
        String[] arr = new String[] { token, timestamp, nonce };  
        // 将token、timestamp、nonce三个参数进行字典序排序  
        Arrays.sort(arr);  
        StringBuilder content = new StringBuilder();  
        for (int i = 0; i < arr.length; i++) {  
            content.append(arr[i]);  
        }  
        MessageDigest md = null;  
        String tmpStr = null;  
  
        try {  
            md = MessageDigest.getInstance("SHA-1");  
            // 将三个参数字符串拼接成一个字符串进行sha1加密  
            byte[] digest = md.digest(content.toString().getBytes());  
            tmpStr = byteToStr(digest);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
  
        content = null;  
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信  
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;  
    }  
  
    /** 
     * 将字节数组转换为十六进制字符串 
     *  
     * @param byteArray 
     * @return 
     */  
    private static String byteToStr(byte[] byteArray) {  
        String strDigest = "";  
        for (int i = 0; i < byteArray.length; i++) {  
            strDigest += byteToHexStr(byteArray[i]);  
        }  
        return strDigest;  
    }  
  
    /** 
     * 将字节转换为十六进制字符串 
     *  
     * @param mByte 
     * @return 
     */  
    private static String byteToHexStr(byte mByte) {  
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
        char[] tempArr = new char[2];  
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
        tempArr[1] = Digit[mByte & 0X0F];  
  
        String s = new String(tempArr);  
        return s;  
    }  
    
    
    /**
     * getAccessToken:
     * 使用APPID和APPSecret获取access_token
     * @param  @return    
     * @return String    
     * @throws 
     * @since  　version 1.0
    */
    public static String getAccessToken() {  
    	//从缓存中获得accessToken
    	String access_token = "";
    	String at = (String)signUtil.redisService.get("accessToken");
    	if (StrKit.isBlank(at)) {
            String grant_type = "client_credential";//获取access_token填写client_credential   
            String AppId = APPID;//第三方用户唯一凭证  
            String secret = APPSECRET;//第三方用户唯一凭证密钥，即appsecret   
            //这个url链接地址和参数皆不能变  
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type="+grant_type+"&appid="+AppId+"&secret="+secret;  
               
            try {  
                URL urlGet = new URL(url);  
                HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();  
                http.setRequestMethod("GET"); // 必须是get方式请求  
                http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
                http.setDoOutput(true);  
                http.setDoInput(true);  
                System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒  
                System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒  
                http.connect();  
                InputStream is = http.getInputStream();  
                int size = is.available();  
                byte[] jsonBytes = new byte[size];  
                is.read(jsonBytes);  
                String message = new String(jsonBytes, "UTF-8");  
                JSONObject demoJson = JSONObject.parseObject(message);  
                log.info("基础access_token字符串"+demoJson);
                System.out.println("JSON字符串："+demoJson);  
                access_token = demoJson.getString("access_token");  
                is.close();  
                signUtil.redisService.set("accessToken", access_token, Integer.toUnsignedLong(2*60*60));
            } catch (Exception e) {  
                    e.printStackTrace();  
            }  
    	} else {
    		access_token = at;
    	}
        
        return access_token;  
    } 
    
    /**
     * getTicket:
     * 使用access_token获取jsapi_ticket
     * @param  @param access_token
     * @param  @return    
     * @return String    
     * @throws 
     * @since  　version 1.0
    */
    public static String getTicket(String access_token) {  
        String ticket = null;  
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ access_token +"&type=jsapi";//这个url链接和参数不能变  
        try {  
            URL urlGet = new URL(url);  
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();  
            http.setRequestMethod("GET"); // 必须是get方式请求  
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
            http.setDoOutput(true);  
            http.setDoInput(true);  
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒  
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒  
            http.connect();  
            InputStream is = http.getInputStream();  
            int size = is.available();  
            byte[] jsonBytes = new byte[size];  
            is.read(jsonBytes);  
            String message = new String(jsonBytes, "UTF-8");  
            JSONObject demoJson = JSONObject.parseObject(message);  
            log.info("ticket字符串"+demoJson);
            System.out.println("JSON字符串："+demoJson);  
            ticket = demoJson.getString("ticket");  
            is.close();  
        } catch (Exception e) {  
                e.printStackTrace();  
        }  
        return ticket;  
    }  
    
    public static String SHA1(String decript) {  
        try {  
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");  
            digest.update(decript.getBytes());  
            byte messageDigest[] = digest.digest();  
            // Create Hex String  
            StringBuffer hexString = new StringBuffer();  
            // 字节数组转换为 十六进制 数  
                for (int i = 0; i < messageDigest.length; i++) {  
                    String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);  
                    if (shaHex.length() < 2) {  
                        hexString.append(0);  
                    }  
                    hexString.append(shaHex);  
                }  
                return hexString.toString();  
       
            } catch (NoSuchAlgorithmException e) {  
                e.printStackTrace();  
            }  
            return "";  
    }  
}
