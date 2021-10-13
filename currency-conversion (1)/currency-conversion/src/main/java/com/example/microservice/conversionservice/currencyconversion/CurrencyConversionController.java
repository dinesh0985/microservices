package com.example.microservice.conversionservice.currencyconversion;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCoversion getCurrencyConversion(@PathVariable String from,@PathVariable String to, @PathVariable int quantity ) {
		
		HashMap uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		//http://localhost:8001/exchange-server/AUD/rate/INR
		ResponseEntity<CurrencyCoversion> forEntity = new RestTemplate().getForEntity("http://localhost:8001/exchange-server/{from}/rate/{to}", CurrencyCoversion.class, uriVariables);
		CurrencyCoversion currencyConversion = forEntity.getBody();
		currencyConversion.setFrom(from);
		currencyConversion.setTo(to);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setCalculatedAmount(currencyConversion.getExchangeRate()*quantity);
		return currencyConversion;
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCoversion getCurrencyConversionFeign(@PathVariable String from,@PathVariable String to, @PathVariable int quantity ) {
		
		CurrencyCoversion currencyConversion = proxy.getExchangeValue(from, to);
		currencyConversion.setFrom(from);
		currencyConversion.setTo(to);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setCalculatedAmount(currencyConversion.getExchangeRate()*quantity);
		return currencyConversion;
	}

}
