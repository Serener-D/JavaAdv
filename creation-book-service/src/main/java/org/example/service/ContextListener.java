package org.example.service;


import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ContextListener implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private BookProducer bookProducer;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ApplicationStartedEvent event) {
        long counter = 0;
        while (true) {
            bookProducer.sendMessage("book");
            Thread.sleep(10000);
        }
    }
}
