package com.epam.spring.core;

import com.epam.spring.core.domain.Client;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.loggers.ConsoleEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private ConsoleEventLogger eventLogger;
	private Client client;
	private ApplicationContext ctx;

	public App(ConsoleEventLogger eventLogger, Client client){
		this.eventLogger = eventLogger;
		this.client = client;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		App app =  (App)ctx.getBean("app");
		app.logEvent("Some event for 1");
	}
	
	private void logEvent(String msg) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		Event event = (Event) ctx.getBean("event");
		event.setMsg(msg.replaceAll(client.getId(), client.getFullName()));
		eventLogger
		.logEvent(event);
	}

}
