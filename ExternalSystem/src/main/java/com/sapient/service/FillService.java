package com.sapient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.dao.BlockDAO;
import com.sapient.dao.FillsDAO;
import com.sapient.entity.Blocks;
import com.sapient.entity.Fills;

@Component
public class FillService 
{

	@Autowired
	FillsDAO fdao;

	 public FillService() {
		
	} 

	
	
	public void addFills(Fills fills) {
		fdao.addFills(fills);
	}
	
	public void generateFills(Blocks b) {
		fdao.generateFills(b);
	}



	public ArrayList<Fills> displayFills() 
	{
		System.out.println("inside services");
		ArrayList<Fills> fillList=  (ArrayList<Fills>) fdao.fetchFills();
		System.out.println("after dao reached here ");
	//	return null;
		return fillList;
	}

	/*public Blocks getBlocks(int id) {
		return bdao.getBlocks(id);

	}*/
	/*public List<Blocks> fetchfill() {
				return bdao.fetchBlocks();
	}*/
}