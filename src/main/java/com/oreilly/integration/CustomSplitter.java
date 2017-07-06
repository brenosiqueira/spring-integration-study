package com.oreilly.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.messaging.Message;

public class CustomSplitter {

	public List<String> split(Message<?> message) {
		return new ArrayList<String>(Arrays.asList(message.getPayload().toString().split(" ")));
	}

}
