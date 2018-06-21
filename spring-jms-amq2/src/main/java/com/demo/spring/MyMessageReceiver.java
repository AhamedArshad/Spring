package com.demo.spring;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class MyMessageReceiver {

	
	@JmsListener(destination="MyQueue", containerFactory="listenerFactory")
	public void getMessage(Message message) throws Exception{
		TextMessage txtMsg = (TextMessage) message;
		
		System.out.println("Message is: "+  txtMsg.getText());
	}
}
