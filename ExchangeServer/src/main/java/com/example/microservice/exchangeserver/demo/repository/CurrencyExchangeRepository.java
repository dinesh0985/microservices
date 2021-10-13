package com.example.microservice.exchangeserver.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservice.exchangeserver.demo.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	
	CurrencyExchange findByFromAndTo(String from,String to);

}
