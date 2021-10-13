package com.example.microservice.exchangeserver.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.exchangeserver.demo.repository.CurrencyExchangeRepository;
@RestController
public class ExchangeController {
	
	@Autowired
	Environment environment;
	@Autowired
	CurrencyExchangeRepository exchangeRepo;
	@GetMapping("/exchange-server/{from}/rate/{to}")
	public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = exchangeRepo.findByFromAndTo(from, to);
	//	CurrencyExchange currencyExchange = new CurrencyExchange(1000,from,to,65.00);
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));		
		return currencyExchange;
	}

}
