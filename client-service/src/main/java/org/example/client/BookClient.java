package org.example.client;

import org.example.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bookClient", url = "http://localhost:8890")
public interface BookClient {

    @GetMapping("/api/books")
    List<Book> getAllBooks();
}
