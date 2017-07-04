package com.oreilly.integration;

import org.springframework.messaging.Message;

public class NumericPrintService {
	public void print(Message<?> message) {
		System.out.println("Is a number " +message.getPayload());
	}
}
