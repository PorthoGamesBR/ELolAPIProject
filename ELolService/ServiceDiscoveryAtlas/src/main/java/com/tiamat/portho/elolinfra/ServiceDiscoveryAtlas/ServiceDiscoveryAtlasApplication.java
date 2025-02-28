package com.tiamat.portho.elolinfra.ServiceDiscoveryAtlas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryAtlasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryAtlasApplication.class, args);
	}

}
