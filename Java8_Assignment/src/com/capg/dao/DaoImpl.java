package com.capg.dao;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.capg.beans.Transaction;

public class DaoImpl implements IDao{
	
	StringBuilder exact = new StringBuilder();
	StringBuilder week = new StringBuilder();
	StringBuilder xBreaks = new StringBuilder();
	StringBuilder yBreaks  = new StringBuilder();
	
	private long diffOfPostingDates(LocalDate d1,LocalDate d2) {
		
		Predicate<LocalDate> isWeekends = (d) -> d.getDayOfWeek() ==DayOfWeek.SATURDAY || d.getDayOfWeek() ==DayOfWeek.SUNDAY;
		
		long diff = Math.abs(d1.compareTo(d2));
		
		BiFunction<LocalDate, LocalDate,LocalDate> startDate = (date1,date2) -> {
			if(date1.compareTo(date2)<0) {
				return date1;
			}else
				return date2;
		};
		
		LocalDate startD = startDate.apply(d1, d2);
		
		Stream<LocalDate> dates = Stream.iterate(startD, d -> d.plusDays(1)).limit(diff);
		long d = dates.filter(isWeekends.negate()).count();
		
		return d;
	}
	
	private double diffOfAmount(double amt1,double amt2) {
		
		amt1 = Double.parseDouble(String.format("%.2f", amt1));
		amt2 = Double.parseDouble(String.format("%.2f", amt2));
		
		return Double.parseDouble(String.format("%.2f", Math.abs(amt1-amt2)));
	}

	@Override
	public void findMatches(List<Transaction> x, List<Transaction> y) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<x.size();i++) {
			//System.out.println(x.size());
			Transaction xt = x.get(i);
			Transaction yt = y.get(i);
			
			if(xt.getAccountId().equals(yt.getAccountId()) && xt.getPostingDate().compareTo(yt.getPostingDate())==0 
					&& xt.getAmount()==yt.getAmount()) {
				exact.append(xt.getTransactionId()).append(yt.getTransactionId() + ", ");
			}else if(xt.getAccountId().equals(yt.getAccountId())  &&  diffOfPostingDates(xt.getPostingDate(), yt.getPostingDate()) <=1 
					&& diffOfAmount(xt.getAmount(), yt.getAmount()) <= .01){
				week.append(xt.getTransactionId()).append(yt.getTransactionId() + ", ");
			}else {
				xBreaks.append(xt.getTransactionId() + ", ");
				yBreaks.append(yt.getTransactionId() + ", ");
			}
		}
	}

	@Override
	public void getExactMatches() {
		// TODO Auto-generated method stub
		System.out.println("# XY exact matches");
		System.out.println(exact);
	}

	@Override
	public void getWeekMatches() {
		// TODO Auto-generated method stub
		System.out.println("# XY weak matches");
		System.out.println(week);
	}

	@Override
	public void getXBreaks() {
		// TODO Auto-generated method stub
		
		System.out.println("X breaks");
		System.out.println(xBreaks);
		
	}

	@Override
	public void getYBreaks() {
		// TODO Auto-generated method stub
		
		System.out.println("Y breaks");
		System.out.println(yBreaks);
	}

}
