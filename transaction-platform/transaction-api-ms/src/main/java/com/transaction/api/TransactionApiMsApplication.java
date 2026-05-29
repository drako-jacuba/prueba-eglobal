package com.transaction.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TransactionApiMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionApiMsApplication.class, args);
	}

}
