package com.service;

import java.util.Date;
import com.model.Currency;

public interface TradeService {
	
	Date getSettlementDay(Currency currency,Date instructionDate); //Method to get Settlement day
	Double getTradeAmount(double unitPrice, int units, double exchangeFX);// Method to cal the Trade amount	
}
