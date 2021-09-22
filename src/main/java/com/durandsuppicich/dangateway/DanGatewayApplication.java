package com.durandsuppicich.dangateway;

import com.durandsuppicich.dangateway.filter.RequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class DanGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanGatewayApplication.class, args);
	}

	@Bean
	public RequestFilter requestFilter() {
		return new RequestFilter();
	}
}
