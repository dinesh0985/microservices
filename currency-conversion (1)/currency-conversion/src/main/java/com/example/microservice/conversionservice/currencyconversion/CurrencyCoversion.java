package com.example.microservice.conversionservice.currencyconversion;

public class CurrencyCoversion {
	
	private int id;
	private String from;
	private String to;
	private int exchangeRate;
	private int quantity;
	private int calculatedAmount;
	private String environment;
	
	public CurrencyCoversion() {
		
	}
	
	public CurrencyCoversion(int id, String from, String to, int exchangeRate, int quantity, int calculatedAmount,
			String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeRate = exchangeRate;
		this.quantity = quantity;
		this.calculatedAmount = calculatedAmount;
		this.environment = environment;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

	
	public int getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(int exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCalculatedAmount() {
		return calculatedAmount;
	}
	public void setCalculatedAmount(int calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	

}
