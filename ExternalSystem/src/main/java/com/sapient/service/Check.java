package com.sapient.service;
/*package com.monster.service;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.monster.dao.BlockDAO;
import com.monster.entity.Blocks;
@Component
public class Check {
PriorityQueue<Blocks> queue1=new PriorityQueue<Blocks>();
PriorityQueue<Blocks> queue2=new PriorityQueue<Blocks>();
@Autowired
BlockDAO bcdao;
public void addBlocks(Blocks block)
{
   List<Blocks> blocks = bcdao.fetchBlocks();
   for(Blocks b:blocks)
   {
	   queue1.add(b);
   }
}


public int checkNullValueInArray(int a[], int size)
{
	int j = -1;
for(int i = 0; i < size; i++)
{
	if(a[i] == 0)
	{
		return i;
	}
}
return j;
}


public void reduceValueByOne(int a[], int size)
{
	for(int i = 0; i < size; i++)
	{
		a[i] -= 1;
	}
}

public void executeBlocks(PriorityQueue<Blocks> queue, int i,int a[])
{
	Blocks block = queue.poll();
	if(block != null)
	{
		String securityName = block.getSymbol();
		
	}
	



}
	}
	

*/