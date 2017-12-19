package com.yumecorp.websocket;

import org.apache.commons.io.input.TailerListenerAdapter;
import org.apache.log4j.Logger;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class MyListener extends TailerListenerAdapter {

	private SimpMessagingTemplate template;
	private String app_server_name;
	private String sessionid;
	private static Logger logger = Logger.getLogger(MyListener.class);

	public SimpMessagingTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SimpMessagingTemplate template) {
		this.template = template;
	}

	public String getApp_server_name() {
		return app_server_name;
	}

	public void setApp_server_name(String app_server_name) {
		this.app_server_name = app_server_name;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	@Override
	public void handle(String line) {
		try {
			template.convertAndSend("/topic/showResult/" + getApp_server_name() + "/" + sessionid, new Result(line));
		} catch (Exception e) {
			logger.error(e);
		}
	}

	@Override
	public void fileNotFound() {
		template.convertAndSend("/topic/showResult/" + getApp_server_name() + "/" + sessionid, new Result(
				"ERROR! Either the App Server Log Host Name is in correct, or there is a problem with the general ssh process"));
	}
}
