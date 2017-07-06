package com.sapient.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sapient.entity.Fills;

@Component
public class Sender {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	private JmsTemplate jmsTemp;
	
	public void sendMessage(final Fills sendFill){
		jmsTemp.send(new MessageCreator(){

			public Message createMessage(Session session) throws JMSException {
				
				return session.createObjectMessage(sendFill);
			}

			
		});
		System.out.println("Block Sent: "+sendFill);
		em.persist(sendFill);
		
	}

}
