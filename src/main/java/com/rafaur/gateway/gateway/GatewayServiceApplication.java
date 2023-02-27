package com.rafaur.gateway.gateway;

import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.provider.HibernateUtils;

import java.util.ArrayList;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(GatewayServiceApplication.class, args);
	}

}
