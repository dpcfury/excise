package com.dpc.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.baidu.yun.channel.auth.ChannelKeyPair;
import com.baidu.yun.channel.client.BaiduChannelClient;
import com.baidu.yun.channel.exception.ChannelClientException;
import com.baidu.yun.channel.exception.ChannelServerException;
import com.baidu.yun.channel.model.PushBroadcastMessageRequest;
import com.baidu.yun.channel.model.PushBroadcastMessageResponse;
import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.dpc.pojo.UserPush;
import com.dpc.service.PushService;
import com.dpc.util.AndroidPushMessageSample;
import com.opensymphony.xwork2.ActionSupport;

public class PushAction extends ActionSupport implements SessionAware {

	private PushService pushService;
	private String title;
	private String message;
	private String id;
	private Map<String, Object> session;

	public String execute() throws Exception {
		return super.execute();
	}

	
	//发送单播的警示消息的方法
	public String sendMessage() throws Exception {

		UserPush push = pushService.getUserByID(Integer.parseInt(id));

		if (push != null) {
			AndroidPushMessageSample msg = new AndroidPushMessageSample();
			System.out.println("打印消息");
			System.out.println("message " + message);
			System.out.println(push);
			// String Message="保重身体健康，减少外出,一切为了你的健康";
			msg.pushMessage(push.getBaiduUserId(), push.getChannelId(), message);
		}
		return SUCCESS;
	}

	public PushService getPushService() {
		return pushService;
	}

	//发送社区通知的方法
	public String sendBroadCastMessage() {
		/*
		 * @brief 推送广播消息(消息类型为透传，由开发方应用自己来解析消息内容) message_type = 0 (默认为0)
		 */

		// 1. 设置developer平台的ApiKey/SecretKey
		String apiKey = "GbwIQXu9gfgfswsGUxMVG9c4";
		String secretKey = "BXRdzHRcKjsEQlwU0t58tl7ZZ1h6oLus";
		ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

		// 2. 创建BaiduChannelClient对象实例
		BaiduChannelClient channelClient = new BaiduChannelClient(pair);

		// 3. 若要了解交互细节，请注册YunLogHandler类
		channelClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});

		try {

			// 4. 创建请求类对象
			PushBroadcastMessageRequest request = new PushBroadcastMessageRequest();
			request.setDeviceType(3); // device_type => 1: web 2: pc 3:android
										// 4:ios 5:wp

			// request.setMessage("Hello Channel");
			// 若要通知，
			request.setMessageType(1);
			String msg = "{\"title\":\"" + title + "\",\"" + "description"
					+ "\":\"" + message + "\"}";

			request.setMessage(msg);

			// 5. 调用pushMessage接口
			PushBroadcastMessageResponse response = channelClient
					.pushBroadcastMessage(request);

			// 6. 认证推送成功
			System.out.println("push amount : " + response.getSuccessAmount());

		} catch (ChannelClientException e) {
			// 处理客户端错误异常
			e.printStackTrace();
		} catch (ChannelServerException e) {
			// 处理服务端错误异常
			System.out.println(String.format(
					"request_id: %d, error_code: %d, error_message: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
		}
		
		session.put("send_result", "社区广播消息发送成功！！！");
		
		
		return "sendBroadCastMessage_success";
	}

	public void setPushService(PushService pushService) {
		this.pushService = pushService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {

		session = arg0;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
