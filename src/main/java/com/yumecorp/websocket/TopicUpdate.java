package com.yumecorp.websocket;

import java.io.File;

import org.apache.commons.io.input.Tailer;

public class TopicUpdate {
	public static void main(String[] args) {
		MyListener listener = new MyListener();
		Tailer tailer = new Tailer(new File("/home/tanveer/FTP_TESTtest.txt"), listener, 500);
		tailer.run();
		/* while (true) {
	            try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }*/
	}

}
