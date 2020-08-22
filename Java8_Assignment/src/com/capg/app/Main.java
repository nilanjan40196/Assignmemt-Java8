package com.capg.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.capg.beans.Transaction;
import com.capg.service.IService;
import com.capg.service.ServiceImpl;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		IService service = new ServiceImpl();
		
		List<Transaction> xRecords = new ArrayList<Transaction>();
		List<Transaction> yRecords = new ArrayList<Transaction>();
		
		File fx = new File("Xset.txt");
		File fy = new File("Yset.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(fx));
		String x = "";
		String[] xs;
		while((x = br.readLine())!=null) {
			xs = x.split("; ");
			Transaction xt = new Transaction();
			xt.setTransactionId(xs[0]);
			xt.setAccountId(xs[1]);
			xt.setPostingDate(LocalDate.parse(xs[2],DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
			xt.setAmount(Double.parseDouble(xs[3]));
			
			xRecords.add(xt);
			//System.out.println(xRecords.size());
			//System.out.println(xt.getPostingDate().getDayOfWeek());
		}
		//System.out.println(xRecords.get(0).getTransactionId());
		
		BufferedReader br1 = new BufferedReader(new FileReader(fy));
		String y = "";
		String[] ys;
		while((y = br1.readLine())!=null) {
			ys = y.split("; ");
			Transaction yt = new Transaction();
			yt.setTransactionId(ys[0]);
			yt.setAccountId(ys[1]);
			yt.setPostingDate(LocalDate.parse(ys[2],DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
			yt.setAmount(Double.parseDouble(ys[3]));
			
			yRecords.add(yt);
			
		}
	//	System.out.println(yRecords.get(0).getTransactionId());
		service.findMatches(xRecords, yRecords);
		
		service.getExactMatches();
		service.getWeekMatches();
		service.getXBreaks();
		service.getYBreaks();
		
	}

}
