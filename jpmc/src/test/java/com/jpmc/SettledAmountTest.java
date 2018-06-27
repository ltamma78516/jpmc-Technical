package com.jpmc;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.model.Entity;
import com.service.serviceImpl.TradeServiceImpl;

public class SettledAmountTest {

	@Test
	public void test() throws ParseException {
		List<Entity> entitiesList = new ArrayList<Entity>();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		
		TradeServiceImpl tradeImpl = new TradeServiceImpl();
		
		Entity entity1 = new Entity("foo","S",0.50,"USD",date.parse("2018/03/09"),date.parse("2016/01/02"),200,100.25);
		Entity entity2 = new Entity("bar","S",0.22,"AED",date.parse("2018/03/10"),date.parse("2016/01/07"),450,150.5);
		Entity entity3 = new Entity("amg","S",0.85,"GBP",date.parse("2018/03/18"),date.parse("2016/01/02"),1500,75.5);
		Entity entity4 = new Entity("xyc","S",0.20,"SAR",date.parse("2018/03/22"),date.parse("2016/01/07"),550,250.5);
		
		entitiesList.add(entity1);
		entitiesList.add(entity2);
		entitiesList.add(entity3);
		entitiesList.add(entity4);
		
		
		assertEquals(Double.valueOf(10025), tradeImpl.getTradeAmount(entity1.getUnitPrice(), entity1.getUnits(), entity1.getExchangeFX()));
		assertEquals(Double.valueOf(14899.5), tradeImpl.getTradeAmount(entity2.getUnitPrice(), entity2.getUnits(), entity2.getExchangeFX()));
		assertEquals(Double.valueOf(96262.5), tradeImpl.getTradeAmount(entity3.getUnitPrice(), entity3.getUnits(), entity3.getExchangeFX()));
		assertEquals(Double.valueOf(27555), tradeImpl.getTradeAmount(entity4.getUnitPrice(), entity4.getUnits(), entity4.getExchangeFX()));
	}

}
