package org.example;

import lombok.SneakyThrows;
import org.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableBinding(Source.class)
public class CreationBookServiceApplication {

    @Autowired
    private Source source;

    public static void main(String[] args) {
        SpringApplication.run(CreationBookServiceApplication.class, args);
    }

    private void sendMessage(Book book) {
        System.out.println("Sending: " + book);
        source.output().send(MessageBuilder.withPayload(book).build());
    }

    @PostConstruct
    @SneakyThrows
    private void init() {
        long counter = 0;
        while (true) {
            sendMessage(Book.builder().id(counter++).build());
            Thread.sleep(10000);
        }
    }
}