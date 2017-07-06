package com.sapient.Configuration;

import java.util.Arrays;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessagingConfig {

	 private static final String DEFAULT_BROKER_URL = "tcp://10.207.62.170:61616";
     
	    
	    private static final String FILL_SENDER_QUEUE = "executeBlockQueue";
	 
	    @Bean
	    public ActiveMQConnectionFactory connectionFactory(){
	        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
	        connectionFactory.setTrustedPackages(Arrays.asList("com.sapient","java.util"));
	        return connectionFactory;
	    }
	     
	    @Bean
	    public JmsTemplate jmsTemplate(){
	        JmsTemplate template = new JmsTemplate();
	        template.setConnectionFactory(connectionFactory());
	        template.setDefaultDestinationName(FILL_SENDER_QUEUE);
	        return template;
	    }}