package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.client.BookClient;
import org.example.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class BookController {

    private final BookClient bookClient;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        log.info("getAllBooks: Incoming request");
        return bookClient.getAllBooks();
    }
}
