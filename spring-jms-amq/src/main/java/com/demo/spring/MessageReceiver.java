package com.demo.spring;

import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MessageReceiver {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);
		JmsTemplate jtx = (JmsTemplate)ctx.getBean("jmsTemplate");
		
		
		TextMessage txtMsg= (TextMessage)jtx.receive("myqueue3");
		System.out.println(txtMsg.getText());

	}

}
