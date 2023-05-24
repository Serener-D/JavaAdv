package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.model.Book;
import org.example.repository.MongoBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final MongoBookRepository mongoBookRepository;

    public List<Book> findAll() {
        return mongoBookRepository.findAll();
    }
}