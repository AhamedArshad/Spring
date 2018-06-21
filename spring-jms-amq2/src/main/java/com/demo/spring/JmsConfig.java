package com.demo.spring;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@ComponentScan(basePackages="com.demo.spring")
@EnableJms
public class JmsConfig {
	
	
	@Bean
	//ActiveMQConnectionFactory should be from spring
	public ActiveMQConnectionFactory activeMQConnectionFactory(){
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL("tcp://localhost:61616");
		return factory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate jt = new JmsTemplate();
		jt.setConnectionFactory(activeMQConnectionFactory());
		jt.setDefaultDestinationName("MyQueue");
		return jt;
	}
	
	@Bean
	public DefaultJmsListenerContainerFactory listenerFactory(){
		DefaultJmsListenerContainerFactory defaultJmsFactory = new DefaultJmsListenerContainerFactory();
		defaultJmsFactory.setConnectionFactory(activeMQConnectionFactory());
		return defaultJmsFactory;
	}

}
