package com.sapient.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Blocks;
import com.sapient.entity.Fills;

@Component
public class FillsDAO {

	@PersistenceContext
	private EntityManager em ;

	public FillsDAO() {
	}

	@Transactional
	public void addFills(Fills fill) {
		em.persist(fill);

	}

	// generatefills
	@Transactional
	public void generateFills(Blocks block) {
		Fills f;
		System.out.println("Block id" + block.getId());
		int executedstoredinfills = retrieveExecutequantity(block.getId());
		System.out.println("Block id" + block.getId());
		//int totalexecutedinblock = block.getExecutedQuantity();
		int numoffills=(block.getTotalQuantity()-block.getOpenQuantity()-executedstoredinfills);
		f = new Fills(block.getId(), block.getSymbol(), block.getSide(), numoffills,
				block.getTradedPrice(), new java.text.SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date()));
		em.persist(f);

	}

	// returns list of fills contained in a block by block id

	public List<Fills> retrieveFillslistbybid(int bid) {
		System.out.println(bid);
		/*
		 * List<Fills> fill = new ArrayList<Fills>(); fill =
		 * em.createNamedQuery("Fillsbybid").setParameter("bid",
		 * bid).getResultList(); System.out.println("hjkfl"); //
		 * em.getTransaction().commit(); return fill;
		 */
		List<Fills> result = null;
		Query query1 = em.createQuery("from Fills f where f.bid=:bid");
		query1.setParameter("bid", bid);
		result = query1.getResultList();
		return result;
	}

	// returns a fill by its fillid
	@Transactional
	public Fills retrieveFillsbyfill_id(int fill_id) {
		Fills f;
		f = em.find(Fills.class, fill_id);
		return f;
	}

	// retrieves total executed quantity of a particular block

	public int retrieveExecutequantity(int bid) {
		System.out.println(bid);
		List<Fills> fill = new ArrayList<Fills>();
		int totalexecutedquantity = 0;
		fill = retrieveFillslistbybid(bid);
		for (Fills f : fill) {
			totalexecutedquantity += f.getExeQuantity();
		}

		return totalexecutedquantity;
	}

	public List<Fills> fetchFills() {
		// TODO Auto-generated method stub
		List<Fills> result = null;
		result = (ArrayList<Fills>) em.createQuery("from Fills f").getResultList();
		return result;

	}
}
