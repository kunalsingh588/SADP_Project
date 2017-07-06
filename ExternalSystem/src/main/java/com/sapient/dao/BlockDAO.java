package com.sapient.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Blocks;

@Component
public class BlockDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public BlockDAO() {
	}

	@Transactional
	public void addBlocks(Blocks block) {
		entityManager.persist(block);
	}

	public Blocks getBlocks(int id) {
		Blocks block = entityManager.find(Blocks.class, id);
		return block;
	}
	

	
	
	public List<Blocks> fetchBlocks() {
		List<Blocks> result = null;
		Query query1 = entityManager.createQuery("from Blocks b");
		result = query1.getResultList();
		return result;
	}

	@Transactional
	/*
	 * public void updateBlocks(Blocks block) { TypedQuery<Blocks> query =
	 * entityManager.createNamedQuery("getExecutedQuantity",Blocks.class);
	 * query.setParameter("executedQuantity",block.getExecutedQuantitiy());
	 * query.setParameter("id", block.getId()); System.out.println(
	 * "Inside updation"); entityManager.merge(block); }
	 */
	public void updateBlocks(Blocks block) {
		System.out.println("Id is... " + block.getId());
		Query query = entityManager
				.createQuery("update Blocks b set b.executedQuantity=:executedQuantity where b.id=:id");
		query.setParameter("executedQuantity", block.getExecutedQuantity());
		query.setParameter("id", block.getId());
		
		int a = query.executeUpdate();
		System.out.println(a);
		Query query1 = entityManager.createQuery("update Blocks b set b.openQuantity=:openQuantity where b.id=:id");
		query1.setParameter("openQuantity", block.getOpenQuantity());
		query1.setParameter("id", block.getId());
		System.out.println("Query run for " + query1.executeUpdate());
		System.out.println("Inside updation");
		Query query2 = entityManager.createQuery("update Blocks b set b.status=:status where b.id=:id");
		query2.setParameter("status", block.getStatus());
		query2.setParameter("id", block.getId());
		System.out.println("Query run for " + query2.executeUpdate());
		Query query3 = entityManager.createQuery("update Blocks b set b.tradedPrice=:tradedPrice where b.id=:id");
		query3.setParameter("tradedPrice", block.getTradedPrice());
		query3.setParameter("id", block.getId());
		System.out.println("Query run for " + query3.executeUpdate());
	}
}
