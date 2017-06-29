package com.oreilly.integration;

import org.springframework.messaging.Message;

public class PrintService {

	public void print(Message<String> message) {
		// O outro servico deve consumir as mensagens em caso de erro desse
		// endpoint
		throw new RuntimeException("This is erro for demostration");
		// System.out.println(message.getPayload());
	}
}
