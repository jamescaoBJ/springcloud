package com.ncme.springboot.footstone.util;

import java.util.List;
import java.util.Random;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class JPushClientUtil {
	private final static String appKey = "a0e23ce3302d21b342ea5119";
	private final static String masterSecret = "e794af1d00c73a0c44a4506c";
	
	private static boolean apnsProduction = true;
	private static JPushClient jPushClient ;
	
	/**
	 *
	 @param apns
	 *      此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产
	 */
	public JPushClientUtil(boolean apns){
		apnsProduction = apns;
		jPushClient = new JPushClient(masterSecret, appKey);
	}
	
	/**
	 * 推送消息
	 * 
	 * @param notification_title
	 *            通知内容标题
	 * @param msg_title
	 *            消息内容标题
	 * @param msg_content
	 *            消息内容
	 * @param alias
	 *            收到推送消息的人群 一个或多个
	 * @return 0推送失败，1推送成功
	 */
	public int sendToClient(String notification_title, String msg_title, String msg_content, List<String> alias) {
		int result = 0;
		try {
			PushPayload pushPayload = buildPushObjectAndroidAndIOS(notification_title, msg_title, msg_content, "",
					alias);
			System.out.println("pushPayload：" + pushPayload);
			PushResult pushResult = jPushClient.sendPush(pushPayload);
			System.out.println("极光推送返回的结果：" + pushResult);
			if (pushResult.getResponseCode() == 200) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jPushClient.close();
		}
		return result;
	}

	/**
	 * 发送给安卓和IOS用户
	 * 
	 * @param notification_title
	 * @param msg_title
	 * @param msg_content
	 * @param extrasparam
	 * @param alias
	 * @return
	 */
	private static PushPayload buildPushObjectAndroidAndIOS(String notification_title, String msg_title,
			String msg_content, String extrasparam, List<String> alias) {
		Random random = new Random();
		int sendNo = random.nextInt(2147483647);
		return PushPayload.newBuilder().setPlatform(Platform.android_ios()).setAudience(Audience.alias(alias))
				.setNotification(Notification.newBuilder().setAlert(msg_content)
						.addPlatformNotification(AndroidNotification.newBuilder().setAlert(msg_content)
								.setTitle(notification_title)
								// 此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
								//.addExtra("androidNotification extras key", extrasparam).build())
								.addExtra("my_key", "1").build())      //给前端 andro 返回一个标识 (1)用于区分本条推送是 系统推送信息
						.addPlatformNotification(IosNotification.newBuilder()
								// 传一个IosAlert对象，指定apns title、title、subtitle等
								.setAlert(msg_content)
								// 直接传alert
								// 此项是指定此推送的badge自动加1
								.incrBadge(1)
								// 此字段的值default表示系统默认声音；传sound.caf表示此推送以项目里面打包的sound.caf声音来提醒，
								// 如果系统没有此音频则以系统默认声音提醒；此字段如果传空字符串，iOS9及以上的系统是无声音提醒，以下的系统是默认声音
								//.setSound("sound.caf")
								// 此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
								//.addExtra("iosNotification extras key", extrasparam).build())
								.addExtra("my_key", "1").build())      //给前端 ios 返回一个标识 (1)用于区分本条推送是 系统推送信息
						.build())
				.setMessage(Message.newBuilder().setMsgContent("").setTitle("")
						.addExtra("message extras key", extrasparam).build())
				.setOptions(Options.newBuilder()
						// 此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
						.setApnsProduction(apnsProduction)
						// 此字段是给开发者自己给推送编号，方便推送者分辨推送记录
						.setSendno(sendNo)
						// 此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天，单位为秒
						.setTimeToLive(86400).build())
				.build();
	}

}
