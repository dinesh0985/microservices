package com.example.microservice.exchangeserver.demo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {
	
	@Id
	private int id;
	@Column(name="currency_from")
	private String from;
	@Column(name="currency_to")
	private String to;
	@Column(name="exchange_Rate")
	private double exchangeRate;
	@Column(name="environment")
	private String environment;
	
	
	public CurrencyExchange() {
		
	}
	
	public CurrencyExchange(int id, String from, String to, double exchangeRate) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeRate = exchangeRate;
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
	public void setFrom(String currency_from) {
		this.from = currency_from;
	}
	public String getTo() {
		return to;
	}
	public void setCurrency_to(String currency_to) {
		this.to = currency_to;
	}
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	

}
