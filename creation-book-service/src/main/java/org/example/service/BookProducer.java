package org.example.service;

import org.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
public class BookProducer {

    @Autowired
    private Source source;

    @Output("test")
    public void sendMessage(Book book) {
        System.out.println("Sending: " + book);
        source.output().send(MessageBuilder.withPayload(book).build());
    }

}
