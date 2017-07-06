package com.sapient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.dao.SecuritiesDAO;
import com.sapient.entity.Blocks;
import com.sapient.entity.Securities;

@Component
public class SecuritiesService {
	@Autowired
	SecuritiesDAO secdao;

	public void addSecurity(Securities security) {

		secdao.addSecurity(security);

	}
	public void updateSecurities(Blocks block,Securities sec)
	{
		
		secdao.updateSecurities(block, sec);
	}
	public List<Securities> fetchSecurities()
	{
		return secdao.fetchSecurities();
	}
	
	public Securities getSecurityBySymbol(String symbol)
	{
		return secdao.getSecurityBySymbol(symbol);
	}
	public void updateSecurity(Securities sec)
	{
		secdao.updateSecurity(sec);
	}
	public void delete(String symbol) {
		secdao.delete(symbol);
		
	}
}
