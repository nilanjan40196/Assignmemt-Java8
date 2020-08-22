package com.capg.dao;

import java.util.List;

import com.capg.beans.Transaction;

public interface IDao {
	
	public void findMatches(List<Transaction> x, List<Transaction> y);
	
	public void getExactMatches();
	public void getWeekMatches();
	public void getXBreaks();
	public void getYBreaks();

}
