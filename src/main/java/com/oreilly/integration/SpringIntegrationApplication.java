package com.oreilly.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@SpringBootApplication
@Configuration
@ImportResource({ "classpath:integration-context.xml" })
public class SpringIntegrationApplication implements ApplicationRunner {

	@Autowired
	@Qualifier("inputChannel")
	DirectChannel inputChannel;

//	@Autowired
//	@Qualifier("outputChannel")
//	DirectChannel outputChannel;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("key", "value");
//		MessageHeaders header = new MessageHeaders(map);
//		
//		Message<String> message = new GenericMessage<String>("Hello word!!!!!", header);
		
		// inputChannel.subscribe((m)->printPayload(m));
		
		//outputChannel.subscribe((m)->printPayload(m));
		//Message<String> message = MessageBuilder.withPayload("Hello word!!!!!").setHeader("key", "value").build();

		//inputChannel.send(message);
		Message<String> message = MessageBuilder.withPayload("Hello word!!!!!").setHeader("key", "value").build();
		MessagingTemplate template = new MessagingTemplate();
		Message<?> returnMessage = template.sendAndReceive(inputChannel, message);
		System.out.println("After MessagingTemplate");
		System.out.println(returnMessage.getPayload());

	}

	private Object printPayload(Message<?> m) {

		System.out.println(m.getPayload());
		return null;
	}
}
