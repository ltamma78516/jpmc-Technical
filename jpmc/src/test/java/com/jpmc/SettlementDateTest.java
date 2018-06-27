package com.jpmc;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.model.Currency;
import com.service.serviceImpl.TradeServiceImpl;

public class SettlementDateTest {

	@Test
	public void settlementDateTest() throws ParseException {
		
		TradeServiceImpl trade = new TradeServiceImpl();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		
		//Test for GBP Currency to close Trading on WeekDay
		assertEquals(date.parse("2018/06/07"), trade.getSettlementDay(Currency.GBP, date.parse("2018/06/07")));
		
		//Test for GBP Currency to close Trading on Weekend
		assertEquals(date.parse("2018/06/11"), trade.getSettlementDay(Currency.GBP, date.parse("2018/06/10")));
		
		//Test for AED Currency to close Trading on WeekDay
		assertEquals(date.parse("2018/06/07"), trade.getSettlementDay(Currency.AED, date.parse("2018/06/07")));
		
		//Test for AED Currency to close trading on weekend
		assertEquals(date.parse("2018/06/10"), trade.getSettlementDay(Currency.AED, date.parse("2018/06/08")));
	}

}
