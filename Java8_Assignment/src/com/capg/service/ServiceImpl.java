package com.capg.service;

import java.util.List;

import com.capg.beans.Transaction;
import com.capg.dao.DaoImpl;
import com.capg.dao.IDao;

public class ServiceImpl implements IService{
	
	IDao dao = null;
	
	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void findMatches(List<Transaction> x, List<Transaction> y) {
		// TODO Auto-generated method stub
		dao.findMatches(x, y);
	}

	@Override
	public void getExactMatches() {
		// TODO Auto-generated method stub
		dao.getExactMatches();
		
	}

	@Override
	public void getWeekMatches() {
		// TODO Auto-generated method stub
		dao.getWeekMatches();
	}

	@Override
	public void getXBreaks() {
		// TODO Auto-generated method stub
		dao.getXBreaks();
	}

	@Override
	public void getYBreaks() {
		// TODO Auto-generated method stub
		dao.getYBreaks();
	}

}
