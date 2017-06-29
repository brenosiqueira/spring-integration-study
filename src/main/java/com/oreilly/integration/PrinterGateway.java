package com.oreilly.integration;

import java.util.concurrent.Future;

import org.springframework.messaging.Message;

public interface PrinterGateway {

	Future<Message<String>> print(Message<?> message);
}
