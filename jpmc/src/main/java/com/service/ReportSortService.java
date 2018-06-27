package com.service;

import java.util.List;

import com.model.Entity;
import com.service.serviceImpl.TradeServiceImpl;

public interface ReportSortService {

	void sortEntityList(List<Entity> entityList, TradeServiceImpl tradeImpl);
}
