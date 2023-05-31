package org.example;

import org.example.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;

@SpringBootApplication
public class CreationBookServiceApplication {

    private Long counter = 0L;

    @Bean
    public Supplier<Book> bookProducer() {
        return () -> Book.builder().id(counter++).status(Book.Status.UNCHECKED).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(CreationBookServiceApplication.class, args);
    }

}