package net.devk.marketing.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import net.devk.marketing.service.config.FileStorageProperties;

/**
 * Application Entry Point
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class MarketingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketingServiceApplication.class, args);
	}

}
