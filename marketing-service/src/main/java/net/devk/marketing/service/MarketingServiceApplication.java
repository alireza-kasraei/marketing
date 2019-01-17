package net.devk.marketing.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MarketingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketingServiceApplication.class, args);
	}

}

