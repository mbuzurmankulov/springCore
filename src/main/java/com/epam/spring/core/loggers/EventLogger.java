package com.epam.spring.core.loggers;

import com.epam.spring.core.domain.Event;

public interface EventLogger {
    void logEvent(Event event);
}
