package com.baraujo.pagamentoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PagamentomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentomsApplication.class, args);
	}

}
