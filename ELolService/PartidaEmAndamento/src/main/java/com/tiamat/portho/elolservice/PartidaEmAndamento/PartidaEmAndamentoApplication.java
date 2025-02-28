package com.tiamat.portho.elolservice.PartidaEmAndamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
public class PartidaEmAndamentoApplication {
	
	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(PartidaEmAndamentoApplication.class, args);
		
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		final String APIKEY = "0TvQnueqKa5mxJntVWt0w4LpLfEkrV1Ta8rQBb9Z";
		final String HEADERNAME = "x-api-key";
		return builder.defaultHeader(HEADERNAME, APIKEY)
	            .build();
	}
	
	@Bean
	public IPartidaService partidaService() {
		IPartidaService toReturn = new LiveLolService();
		
		String execEnvironment = env.getProperty("execution.environment");
		
		if (!toReturn.online())
			toReturn = new ScrapperService();
		
		if (execEnvironment != null && execEnvironment.compareTo("test") == 0)
			toReturn = new TestService();
		
		return toReturn;
	}

}
