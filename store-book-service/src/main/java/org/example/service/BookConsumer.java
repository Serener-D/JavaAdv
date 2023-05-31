package org.example.service;

import org.example.model.Book;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class BookConsumer {

    @StreamListener(Sink.INPUT)
    public void handleMessage(Book book) {
        System.out.println("Received book: " + book + "now I will store it somewhere...");
    }
}