package org.example.repository;

import org.example.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoBookRepository extends MongoRepository<Book, String> {
}