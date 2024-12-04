package com.javaexercice.docker.mongodb.dao;

import com.javaexercice.docker.mongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,Integer> {
}
