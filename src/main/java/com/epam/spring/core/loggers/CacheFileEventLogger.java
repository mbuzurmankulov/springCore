package com.epam.spring.core.loggers;

import com.epam.spring.core.domain.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger{
    private Integer cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(Integer cacheSize, String fileName){
        super(fileName);
        this.cacheSize = cacheSize > 0? cacheSize : 1;
        cache = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event){
        cache.add(event);

        if(cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache(){
        for(Event event: cache){
            super.logEvent(event);
        }
    }

    public void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
        cache.clear();
    }
}
