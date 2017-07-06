package com.sapient.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Blocks;
import com.sapient.entity.Securities;

@Repository
public class SecuritiesDAO {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void addSecurity(Securities security) {
		manager.persist(security);
	}

	@Transactional
	public void updateSecurities(Blocks block, Securities sec) {
		Query query1 = manager
				.createQuery("update Securities s set s.lastTradedPrice=:lastTradedPrice where s.symbol=:symbol");
		query1.setParameter("lastTradedPrice", block.getTradedPrice());
		query1.setParameter("symbol", sec.getSymbol());
		System.out.println("Query run for " + query1.executeUpdate());
		// sec.setLastTradedPrice(block.getTradedPrice());

	}

	public List<Securities> fetchSecurities() {

		List<Securities> result = null;
		Query query1 = manager.createQuery("from Securities s");
		result = query1.getResultList();
		return result;
	}

	public Securities getSecurityBySymbol(String symbol) {
		Securities security = manager.find(Securities.class, symbol);

		return security;

	}
	@Transactional
	public void updateSecurity(Securities sec) {
		Query query1 = manager.createQuery(
				"update Securities s set s.maxSpread=:maxSpread,s.maxInterval=:maxInterval,s.maxExecution=:maxExecution,s.percentageOfExecution=:percentageOfExecution where s.symbol=:symbol");
		query1.setParameter("maxSpread", sec.getMaxSpread());
		query1.setParameter("maxInterval", sec.getMaxInterval());
		query1.setParameter("maxExecution", sec.getMaxExecution());
		query1.setParameter("percentageOfExecution", sec.getPercentageOfExecution());
		query1.setParameter("symbol", sec.getSymbol());
		System.out.println("Query run for " + query1.executeUpdate());

	}
	@Transactional
	public void delete(String symbol) {
		Query query1 = manager.createQuery("delete from Securities s where s.symbol=:symbol");
		query1.setParameter("symbol",symbol);
		System.out.println("Query run for " + query1.executeUpdate());
			}

}
