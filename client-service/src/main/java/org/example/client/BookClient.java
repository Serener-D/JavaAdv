package org.example.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Book;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@FeignClient(
        name = "bookClient",
        url = "http://localhost:8890",
        fallbackFactory = BookClient.BookServiceConnectorFallbackFactory.class)
public interface BookClient {

    @GetMapping("/api/books")
    List<Book> getAllBooks();

    @Component
    class BookServiceConnectorFallbackFactory implements FallbackFactory<FallbackWithFactory> {
        @Override
        public FallbackWithFactory create(Throwable cause) {
            return new FallbackWithFactory(cause.getMessage());
        }
    }

    @Slf4j
    @RequiredArgsConstructor
    class FallbackWithFactory implements BookClient {
        private final String reason;

        @Override
        public List<Book> getAllBooks() {
            log.info("Failed send request on book service, reason {}", reason);
            return Collections.emptyList();
        }
    }
}