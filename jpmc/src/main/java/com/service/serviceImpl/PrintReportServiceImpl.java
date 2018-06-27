package com.service.serviceImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.model.Currency;
import com.model.Entity;
import com.service.PrintReportService;

public class PrintReportServiceImpl implements PrintReportService {
	
	private static Logger log = Logger.getLogger(PrintReportService.class.getName());
	
	private TradeServiceImpl tsimpl;
	private ReportSortServiceImpl sortImpl;

	/**
	 * @param tsimpl
	 */
	public PrintReportServiceImpl() {
		tsimpl= new TradeServiceImpl();
		sortImpl = new ReportSortServiceImpl();
	}

	@Override
	public void printReport(List<Entity> entityList) {
		
		List<Entity> purchaseEntities = entityList.stream().filter((P) -> "B".equals(P.getInstruction())).collect(Collectors.toList());
		List<Entity> sellingEntities = entityList.stream().filter((P) -> "S".equals(P.getInstruction())).collect(Collectors.toList());
		
		try {
			if (!purchaseEntities.isEmpty()) {
				printData(purchaseEntities, "Purchase Report");
			} 
			
			if(!sellingEntities.isEmpty()){
				printData(sellingEntities, "Selling Report");
			}
			
		} catch (Exception e) {
			log.info(e.getMessage());			
		}
		
	}
	
	void printData(List<Entity> entityList, String listHeader)
	{
		int rank = 1;

		System.out.println("				   " + listHeader);
		System.out.println("Rank	Name	Currency	InstructionDate 	SettlementDate 			TradeAmount(USD) ");
		System.out.println("____	______	________	_______________		______________			________________ ");

		sortImpl.sortEntityList(entityList, tsimpl);

		for (Entity entity : entityList) {
			System.out.println(rank++ + " 	" + entity.getEntityName() + "	" + entity.getCurrency() + "	"
					+ entity.getInstructionDate() + "	" + tsimpl.getSettlementDay(Currency.valueOf(entity.getCurrency()), entity.getInstructionDate()) + "	" + "$"
					+ tsimpl.getTradeAmount(entity.getUnitPrice(), entity.getUnits(), entity.getExchangeFX()));
		}
		
	}

}
