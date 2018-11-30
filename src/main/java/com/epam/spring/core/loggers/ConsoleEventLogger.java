package com.epam.spring.core.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ConsoleEventLogger implements EventLogger {

	private static final Logger logger = LoggerFactory.getLogger(ConsoleEventLogger.class);

	public void logEvent(String msg) {
		logger.info(msg);
	}
}
