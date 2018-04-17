package com.wjw.task;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ncme.springboot.footstone.exception.MyException;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.footstone.util.DateUtil;
import com.ncme.springboot.footstone.util.JPushClientUtil;
import com.ncme.springboot.model.SystemMessage;
import com.ncme.springboot.model.SystemUser;
import com.wjw.service.RedisService;
import com.wjw.service.SystemMessageService;
import com.wjw.service.SystemUserService;
import com.wjw.util.WeixinUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@Component
public class ScheduledTasks {
	@Autowired
	SystemUserService systemUserService;
	//保存推送消息
	@Autowired
	SystemMessageService systemMessageService;
	@Autowired
	RedisService redisService;
	
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    final Integer NoApplyCredit = 1; // 未申请学分
    
	/**
     * 自动推送消息(项目:远程+面授)
     */
    @Scheduled(cron = "0 40 7 * * ?")  // (cron = "0 0 8 * * ?") 每天早上8执行一次   
    public void reportCurrentTime() {
        System.out.println("当前时间：" + dateFormat.format(new Date()));
	    try{
	    	//获取系统所用用户
	    	List<SystemUser> uList = systemUserService.getAllUser();
	    	if (uList!=null && uList.size()>0) {
	    		for (SystemUser user : uList) {
	    			//SystemUser user = new SystemUser();user.setId(21469);//user.setId(20);测试推送
	    			//根据用户ID 及 (所学习项目)未申请学分,获取其学习项目
	    			
	    			List<Record> list = systemUserService.getMyStudys(user.getId(), NoApplyCredit);
	    			if (list!=null && list.size()>0){
	    				String endDate = "",itemName = "";
	    				SystemMessage message = new SystemMessage(); 
	    				for (Record rec : list) {
	    					endDate = (String) rec.get("content2");
	    					itemName = (String) rec.get("name");
	    					if (endDate != null && endDate.equals("30")) {						  //项目即将到期提醒 (您所学的项目【XXX】还有30天到期，请尽快学习)
	    						//推送一条信息(极光推送)
	    						String notification_title="NCME";     							  // 标题(固定写法)
	    						String msg_title="";											  // 为空
	    						String msg_content="您所学的项目【"+itemName+"】还有30天到期，请尽快学习";       // 内容

	    						if (checkAlreadySend(user.getId(),msg_content)>0){
	    							continue;
	    						}
	    						List<String> alias= new ArrayList<String>();
	    						alias.add(user.getId().toString());
	    						int result = new JPushClientUtil(true).sendToClient(notification_title, msg_title, msg_content, alias);
    							//将此推送信息保存至(system_message)表中
    							message.setSystemUserId(user.getId());
    							message.setMessageContent(msg_content);
    							message.setMessageDate(new Date());
    							message.setIsRead(1);
    							message.setMessageTitle("项目即将到期");
    							systemMessageService.saveMessage(message);
	    					} else if (endDate != null && endDate.equals("0")){					  //项目过期提醒 (您所学的项目【XXX】已过期，不可继续学习)
	    						//推送一条信息(极光推送)
	    						String notification_title="NCME";     							  // 标题(固定写法)
	    						String msg_title="";											  // 为空
	    						String msg_content="您所学的项目【"+itemName+"】已过期，不可继续学习";          // 内容

	    						if (checkAlreadySend(user.getId(),msg_content)>0){
	    							continue;
	    						}
	    						List<String> alias= new ArrayList<String>();
	    						alias.add(user.getId().toString());
	    						int result = new JPushClientUtil(true).sendToClient(notification_title, msg_title, msg_content, alias);
    							//将此推送信息保存至(system_message)表中
    							message.setSystemUserId(user.getId());
    							message.setMessageContent(msg_content);
    							message.setMessageDate(new Date());
    							message.setIsRead(1);
    							message.setMessageTitle("项目过期");
    							systemMessageService.saveMessage(message);
	    					} else {
	    						
	    					}
	    				}
	    			}
	    			/*
	    			//根据用户ID,获取用户已报名的直播课程   定时任务从8点开始  检索时间范围为(早8点 至 晚20点 12个小时)
	    			List<Record> kclist = systemUserService.getSignUpCvLive(user.getId(), 720);
	    			Date userful = null;
	    			if (kclist!=null && kclist.size()>0){
	    				Date curr = DateUtil.getNowDate();
	    				String itemName = "",startDate = "",userfulDate = "";
	    				for (Record rec : kclist) {
	    					itemName = (String) rec.get("name");
	    					startDate = rec.get("startDate").toString();//.substring(0, 16);
	    					//userfulDate = (String) rec.get("startDate");
	    					userful = DateUtil.parse(startDate, "yyyy-MM-dd HH:mm:ss");
	    					long diff = (userful.getTime()-curr.getTime())/1000 - 10 * 60;		 
	    					if (diff > 0){
	    						TimerTest(diff, itemName, user.getId()); //直播课程开课前10分钟才向用户推送消息
	    					} else {
	    						continue;
	    					}
	    				}
	    			}*/
				}
	    	}
        } catch(MyException e) {
        	e.printStackTrace();
        }
    }
    
    
    /**
     * 自动推送消息(直播)
     */
    @Scheduled(cron = "0 * * * * ?")  // "0 * * * * ?" 每分钟(0点0时0分)触发一次 
    public void cvLivePushMessage() {
        System.out.println("当前时间：" + dateFormat.format(new Date()));
	    try{
	    	List<Record> kclist = systemUserService.getSignUpCvLive(20, 720);
			Date userful = null;
			if (kclist!=null && kclist.size()>0){
				Date curr = DateUtil.getNowDate();
				String itemName = "",userId = "";
				for (Record rec : kclist) {
					itemName = (String) rec.get("name");
					//userId = rec.get("userid").toString();
					//从缓存中取得报名课程的学员list
					List<String> userIdList = (List<String>) redisService.get(rec.get("id").toString());
					if (userIdList!=null){
						SystemMessage message1 = new SystemMessage();
						//推送一条信息(极光推送)
						String notification_title="NCME";     							  						// 标题(固定写法)
						String msg_title="";											  						// 为空
						String msg_content="您所报名的直播课程【"+itemName+"】即将开课，请提前准备学习。";      					// 内容
						
						/*if (checkAlreadySend(Integer.parseInt(userId),msg_content)>0){
						continue;
					}*/
						//List<String> alias= new ArrayList<String>();
						//alias.add(userId);
						List<String> alias = userIdList;
						int result = new JPushClientUtil(true).sendToClient(notification_title, msg_title, msg_content, alias);
						
						//当推送成功之后将缓存中的学员id清除
						redisService.remove(rec.get("id").toString());
						/*//将此推送信息保存至(system_message)表中
						message1.setSystemUserId(Integer.parseInt(userId));
						message1.setMessageContent(msg_content);
						message1.setMessageDate(new Date());
						message1.setIsRead(1);
						message1.setMessageTitle("直播开课");
						systemMessageService.saveMessage(message1);*/
						//将此推送信息保存至(system_message)表中
						for (int i=0;i<alias.size();i++) {
							message1.setSystemUserId(Integer.parseInt(alias.get(i)));
							message1.setMessageContent(msg_content);
							message1.setMessageDate(new Date());
							message1.setIsRead(1);
							message1.setMessageTitle("直播开课");
							systemMessageService.saveMessage(message1);
						}
						
					}
					
				}
			}
	    } catch(MyException e) {
        	e.printStackTrace();
        }
    }
	
    //检测消息是否已推送过
    public int checkAlreadySend(Integer userId,String msgContent){
    	int num=0;
    	num = systemUserService.checkAlreadySend(userId,msgContent);
    	return num;
    }
    
    public void TimerTest(Long time,String itemName,Integer userId){
    	Timer timer = new Timer();
    	timer.schedule(new timerTaskTest(itemName,userId),time*1000);//timer.schedule(执行的方法，延迟多久执行(ms))
    }
    	
    public class timerTaskTest extends TimerTask{
    	private String itemName;
    	private Integer userId;

        public timerTaskTest(String itemName, Integer userId) {
        	this.itemName = itemName;
            this.userId = userId;
        }
    	
	    @Override
	    public void run() {
	    	System.out.println("time's up!!");
	    	SystemMessage message1 = new SystemMessage();
	    	//推送一条信息(极光推送)
			String notification_title="NCME";     							  						// 标题(固定写法)
			String msg_title="";											  						// 为空
			String msg_content="您所报名的直播课程【"+itemName+"】即将开课，请提前准备学习。";      					// 内容
			List<String> alias= new ArrayList<String>();
			alias.add(userId.toString());
			int result = new JPushClientUtil(true).sendToClient(notification_title, msg_title, msg_content, alias);
			//将此推送信息保存至(system_message)表中
			message1.setSystemUserId(userId);
			message1.setMessageContent(msg_content);
			message1.setMessageDate(new Date());
			message1.setIsRead(1);
			message1.setMessageTitle("直播开课");
			systemMessageService.saveMessage(message1);
	    }
    }
    
    
    /**
     * 获取access_Token的方法
     */
    //@Scheduled(cron = "0 0 0,2,4,6,8,10,12,14,16,18,20,22 * * ?")  //每天的0点、2点、4点、6点...都执行一次      //(cron = "45 20 15 * * ?") 每天下午3点20分45秒执行一次
   /* public void getTicket() throws ClientProtocolException, IOException{
    	 //1、获取AccessToken  
        String accessToken = WeixinUtil.getAccessToken();  
          
        //2、获取Ticket  
        String jsapi_ticket = WeixinUtil.getTicket(accessToken);  
          
        //3、时间戳和随机字符串  
        String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//随机字符串  
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//时间戳  
          
        System.out.println("accessToken:"+accessToken+"\njsapi_ticket:"+jsapi_ticket+"\n时间戳："+timestamp+"\n随机字符串："+noncestr);  
          
        //4、获取url  
        String url="http://www.luiyang.com/add.html";
        根据JSSDK上面的规则进行计算，这里比较简单，我就手动写啦 
        String[] ArrTmp = {"jsapi_ticket","timestamp","nonce","url"}; 
        Arrays.sort(ArrTmp); 
        StringBuffer sf = new StringBuffer(); 
        for(int i=0;i<ArrTmp.length;i++){ 
            sf.append(ArrTmp[i]); 
        } 
          
          
        //5、将参数排序并拼接字符串  
        String str = "jsapi_ticket="+jsapi_ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;  
         
        //6、将字符串进行sha1加密  
        String signature = WeixinUtil.SHA1(str);  
        System.out.println("参数："+str+"\n签名："+signature); 
        
    }*/

}
