package com.cooligc.circuit.breaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
//@EnableZipkinServer
public class CircuitBreakerPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerPocApplication.class, args);
	}

}
