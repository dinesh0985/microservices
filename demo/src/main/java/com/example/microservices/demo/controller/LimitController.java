package com.example.microservices.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.demo.Configuration.Configuration;
import com.example.microservices.demo.dto.Limits;

@RestController
public class LimitController {

	@Autowired
	Configuration config;
	
	@GetMapping("/limits")
	private Limits getLimits() {
		return new Limits(config.getMin(),config.getMax());
	}
}
