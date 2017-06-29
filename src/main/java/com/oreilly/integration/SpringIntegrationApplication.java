package com.oreilly.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
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
	public void run(ApplicationArguments arg0) throws Exception {

		List<Future<Message<String>>> futures = new ArrayList<>();

		for (int x = 0; x < 10; x++) {
			Message<String> message = MessageBuilder
					.withPayload("Printing message payload for " + x)
					.setHeader("messageNumber", x)
					.setHeader(IntegrationMessageHeaderAccessor.PRIORITY, x)
					.build();
			System.out.println("Sending message " + x);
			futures.add(this.gateway.print(message));

		}
		
		for (Future<Message<String>> future : futures) {
			System.out.println(future.get().getPayload());
		}
	}
}
