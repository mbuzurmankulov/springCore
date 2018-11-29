package com.epam.spring.core;

import org.springframework.stereotype.Component;

@Component
public class ConsoleEventLogger {
	public void logEvent(String msg) {
		System.out.println(msg);
	}
}
