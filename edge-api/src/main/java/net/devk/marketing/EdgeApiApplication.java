package net.devk.marketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
//@EnableZuulProxy
@SpringBootApplication
public class EdgeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeApiApplication.class, args);
	}

}
