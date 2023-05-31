package org.example;

import org.example.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class CheckBookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckBookServiceApplication.class, args);
    }

    @Bean
    public Function<Book, Book> bookConsumerAndProducer() {
        return book -> {
            System.out.println("Received book: " + book);
            book.setStatus(Book.Status.CHECKED);
            return book;
        };
    }
}