package com.oreilly.integration;

import java.util.Map.Entry;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class PrintService {

	public Message<String> print(Message<String> message) {

//		for (Entry<String, Object> entry : message.getHeaders().entrySet()) {
//			System.out.println("Header entry:  " + entry.getKey() + "="
//					+ entry.getValue());
//		}
//
		System.out.println(message.getPayload());
//		return MessageBuilder.withPayload("new Message").build();
		int messageNumber = (int) message.getHeaders().get("messageNumber");
		return MessageBuilder.withPayload("Sending a reply for message " + messageNumber).build();
	}

}
