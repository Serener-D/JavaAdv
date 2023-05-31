package org.example.service;

import org.example.model.Book;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Processor.class)
public class BookConsumer {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Book handleMessage(Book book) {
        System.out.println("Received book: " + book);
        book.setStatus(Book.Status.CHECKED);
        return book;
    }
}