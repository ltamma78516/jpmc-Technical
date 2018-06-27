package com.service.serviceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import com.model.Currency;
import com.service.TradeService;

public class TradeServiceImpl implements TradeService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(TradeServiceImpl.class.getName());

	@Override
	public Double getTradeAmount(double unitPrice, int units, double exchangeFX) {

		Double amount = unitPrice * units * exchangeFX;

		return amount;
	}

	@Override
	public Date getSettlementDay(Currency currency, Date instructionDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instructionDate);

		if (Currency.AED.equals(currency) || Currency.SAR.equals(currency)) {
			if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
				return addDays(cal, 1);
			} else if (cal.get(Calendar.DAY_OF_WEEK) == 6) {
				return addDays(cal, 2);
			} else {
				return instructionDate;
			}
		} else {
			if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
				return addDays(cal, 1);
			} else if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
				return addDays(cal, 2);
			} else {
				return instructionDate;
			}
		}

	}

	/*
	 * @param cal
	 * 
	 * @param int
	 * 
	 * @return date
	 */
	public Date addDays(Calendar cal, int numberOfDays) {
		cal.add(Calendar.DATE, numberOfDays);
		return cal.getTime();
	}
}
