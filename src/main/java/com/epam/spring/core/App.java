package com.epam.spring.core;

import com.epam.spring.core.aspects.StatisticAspect;
import com.epam.spring.core.domain.Client;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.enums.EventType;
import com.epam.spring.core.loggers.EventLogger;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private EventLogger defaultLogger;
	private Map<EventType, EventLogger> loggerMap;
	private Client client;
	@Setter
	private ConfigurableApplicationContext ctx;
	@Getter
	@Setter
	private StatisticAspect statisticAspect;

	public App(EventLogger defaultLogger, Map<EventType, EventLogger> loggerMap, Client client){
	    this.defaultLogger = defaultLogger;
		this.loggerMap = loggerMap;
		this.client = client;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		App app =  (App)ctx.getBean("app");
		app.setCtx(ctx);
		app.logEvent("ERROR event for 1 \n", EventType.ERROR);
		app.logEvent("INFO event for 1 \n", EventType.INFO);
		app.logEvent("Default \n", null);

		for(Map.Entry entry : app.getStatisticAspect().getStatistics().entrySet()) {
			System.out.println("logger " + entry.getKey() + " logged " + entry.getValue() + " times");
		}
	}
	
	private void logEvent(String msg, EventType eventType) {
		Event event = (Event) ctx.getBean("event");
		event.setMsg(msg.replaceAll(client.getId(), client.getFullName()));
        EventLogger logger = loggerMap.get(eventType);
		if(logger == null){
		    logger = defaultLogger;
        }
		logger.logEvent(event);
	}

}
