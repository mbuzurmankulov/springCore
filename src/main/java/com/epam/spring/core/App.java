package com.epam.spring.core;

import com.epam.spring.core.domain.Client;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.enums.EventType;
import com.epam.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private EventLogger defaultLogger;
	private Map<EventType, EventLogger> loggerMap;
	private Client client;

	public App(EventLogger defaultLogger, Map<EventType, EventLogger> loggerMap, Client client){
	    this.defaultLogger = defaultLogger;
		this.loggerMap = loggerMap;
		this.client = client;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		App app =  (App)ctx.getBean("app");
		app.logEvent("ERROR event for 1 \n", EventType.ERROR);
		app.logEvent("INFO event for 1 \n", EventType.INFO);
		app.logEvent("Default \n", null);
	}
	
	private void logEvent(String msg, EventType eventType) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		Event event = (Event) ctx.getBean("event");
		event.setMsg(msg.replaceAll(client.getId(), client.getFullName()));
        EventLogger logger = loggerMap.get(eventType);
		if(logger == null){
		    logger = defaultLogger;
        }
		logger
		.logEvent(event);
		ctx.close();
	}

}
