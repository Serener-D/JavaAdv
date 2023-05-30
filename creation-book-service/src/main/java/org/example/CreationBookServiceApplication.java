package org.example;

import lombok.SneakyThrows;
import org.example.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableBinding(Source.class)
public class CreationBookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CreationBookServiceApplication.class, args);
    }

    @InboundChannelAdapter(channel = Source.OUTPUT, poller = @Poller(fixedRate = "5000"))
    public Message<Book> generate(Book book) {
        System.out.println("Sending: " + book);
        return MessageBuilder.withPayload(book)
                .build();
    }

    @PostConstruct
    @SneakyThrows
    private void init() {
        long counter = 0;
        while (true) {
            generate(Book.builder().id(counter++).build());
            Thread.sleep(10000);
        }
    }
}