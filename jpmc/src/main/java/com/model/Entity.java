package com.model;

import java.text.ParseException;
import java.util.Date;

public class Entity {
	
	private String entityName; // Financial entity whose shares are to bought or sold
	private double unitPrice; // Individual Units price.
	private String currency; // Entity currency
	private String instruction; 	// Instruction used to indicate either Buy/Sell
	private double exchangeFX; 		// Foreign exchange rate with respect to USD that was agreed
	private Date instructionDate; 	// Date on which the instruction was sent to JP Morgan by various clients
	private Date settlementDate;	// The date on which the client wished for the instruction to be settled with respect to Instruction Date
	private int units;				// Number of shares to be bought or sold
	/**
	 * @param entityName
	 * @param unitPrice
	 * @param currency
	 * @param instruction
	 * @param exchangeFX
	 * @param instructionDate
	 * @param settlementDate
	 * @param units
	 */
	public Entity(String entityName, String instruction, double exchangeFX, String currency, Date instructionDate,
			Date settlementDate, int units, double unitPrice) throws ParseException{
		super();
		this.entityName = entityName;
		this.instruction = instruction;
		this.exchangeFX = exchangeFX;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}
	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}
	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	/**
	 * @return the exchangeFX
	 */
	public double getExchangeFX() {
		return exchangeFX;
	}
	/**
	 * @param exchangeFX the exchangeFX to set
	 */
	public void setExchangeFX(double exchangeFX) {
		this.exchangeFX = exchangeFX;
	}
	/**
	 * @return the instructionDate
	 */
	public Date getInstructionDate() {
		return instructionDate;
	}
	/**
	 * @param instructionDate the instructionDate to set
	 */
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	/**
	 * @return the settlementDate
	 */
	public Date getSettlementDate() {
		return settlementDate;
	}
	/**
	 * @param settlementDate the settlementDate to set
	 */
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}

}
