/**
 * 
 */
package com.service.serviceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.model.Entity;
import com.service.ReportSortService;

/**
 * @author lavakusareddytamma
 *
 */
public class ReportSortServiceImpl implements ReportSortService{

	@Override
	public void sortEntityList(List<Entity> entityList, TradeServiceImpl tradeImpl) {
		Collections.sort( entityList, new Comparator<Entity>()
        {
			@Override
			public int compare(Entity obj1, Entity obj2) {
				return Double.compare(tradeImpl.getTradeAmount(obj2.getUnitPrice(), obj2.getUnits(), obj2.getExchangeFX()), 
						tradeImpl.getTradeAmount(obj1.getUnitPrice(), obj1.getUnits(), obj1.getExchangeFX()));
			}

        });
	}}
