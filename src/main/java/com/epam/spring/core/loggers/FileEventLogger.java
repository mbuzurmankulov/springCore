package com.epam.spring.core.loggers;

import com.epam.spring.core.domain.Event;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;

@NoArgsConstructor
public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName){
        this.fileName = fileName;
    }

    @Override
    @SneakyThrows
    public void logEvent(Event event) {
        FileUtils.writeStringToFile(file, event.getMsg(),"UTF-8", true);
    }

    protected void init() {
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource(fileName).getFile());
        if(!file.canWrite()){
            throw new RuntimeException("file " + fileName + " is now writable!");
        }
    }
}
