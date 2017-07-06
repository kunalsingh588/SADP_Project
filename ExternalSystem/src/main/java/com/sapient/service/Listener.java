package com.sapient.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.sapient.dao.BlockDAO;
import com.sapient.entity.Blocks;

@Service
public class Listener implements MessageListener{
	
private static final String ORDER_RECEIVE_QUEUE = "blockQueue";
	
	@PersistenceContext
	EntityManager em;

	@Autowired
	BlockDAO bdao;
	@JmsListener(destination=ORDER_RECEIVE_QUEUE)
	public void onMessage(Message msg) {
		
		ObjectMessage obj = (ObjectMessage) msg;
		Blocks b = new Blocks();
		try {
			Object Obj = obj.getObject();
			b = (Blocks) Obj;
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
		System.out.println("Block Receive: "+b);
		/*em.persist(b);*/
		bdao.addBlocks(b);
	}

}
