package com.oreilly.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource({ "classpath:integration-context.xml" })
public class SpringIntegrationApplication implements ApplicationRunner {

	@Autowired
	PrinterGateway gateway;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) {

		for (int x = 0; x < 10; x++) {
			Message<?> message = MessageBuilder.withPayload(x+" This is a string.").setHeader("routeHeader", "string").build();
			this.gateway.print(message);

		}
	}
}
