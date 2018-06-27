package com.jpmc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.model.Entity;
import com.service.serviceImpl.PrintReportServiceImpl;

public class PrintServiceImplTest {

	@Test
	public void printSellingList() throws ParseException {
		List<Entity> entitiesList = new ArrayList<Entity>();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");		
		PrintReportServiceImpl printdata = new PrintReportServiceImpl();
		
		Entity entity1 = new Entity("foo","S",0.50,"USD",date.parse("2018/03/09"),date.parse("2016/01/02"),200,100.25);
		Entity entity2 = new Entity("bar","B",0.22,"AED",date.parse("2018/03/10"),date.parse("2016/01/07"),450,150.5);
		Entity entity3 = new Entity("amg","S",0.85,"GBP",date.parse("2018/03/18"),date.parse("2016/01/02"),15,75.5);
		Entity entity4 = new Entity("xyc","B",0.20,"SAR",date.parse("2018/03/22"),date.parse("2016/01/07"),550,250.5);
		
		entitiesList.add(entity1);
		entitiesList.add(entity2);
		entitiesList.add(entity3);
		entitiesList.add(entity4);		
		
		printdata.printReport(entitiesList);
	}

}
