package com.example.microservices.cloudgateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayRouteConfiguration {

	
	@Bean
	public RouteLocator gateRouter(RouteLocatorBuilder builder) {
		
		return builder.routes().
				route(p -> p.path("/exchange-server/**").filters(f -> f.addRequestHeader("HEADER_NAME", "HEADER_VALUE")
						.addRequestParameter("Request_name", "REQUEST_PARAM_VAL")).uri("lb://exchange-server"))
				.route(p -> p.path("/currency-converter/**").uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-converter-feign/**").uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-converter-new/**").
						filters(f -> f.rewritePath("/currency-converter-new/**", "/currency-converter-feign/"))
						.uri("lb://currency-conversion"))
				.build();
	}
}
