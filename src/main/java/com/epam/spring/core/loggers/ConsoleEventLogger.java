package com.epam.spring.core.loggers;

import com.epam.spring.core.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleEventLogger implements EventLogger {

	private static final Logger logger = LoggerFactory.getLogger(ConsoleEventLogger.class);

	public void logEvent(Event event) {
		System.out.println(event.getMsg());
		logger.info(event.getMsg());
	}
}

