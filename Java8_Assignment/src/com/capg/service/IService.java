package com.capg.service;

import java.util.List;

import com.capg.beans.Transaction;

public interface IService {
	
	public void findMatches(List<Transaction> x, List<Transaction> y);
	
	public void getExactMatches();
	public void getWeekMatches();
	public void getXBreaks();
	public void getYBreaks();

}
