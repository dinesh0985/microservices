package com.example.microservice.conversionservice.currencyconversion;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="exchange-server",url="http://localhost:8001")
@FeignClient(name="exchange-server")
public interface CurrencyExchangeProxy {

	@GetMapping("/exchange-server/{from}/rate/{to}")
	public CurrencyCoversion getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) ;
	
}
