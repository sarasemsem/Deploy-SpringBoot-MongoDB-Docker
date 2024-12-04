package com.javaexercice.docker.mongodb;

import com.javaexercice.docker.mongodb.dao.BookRepository;
import com.javaexercice.docker.mongodb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/book")
public class SpringbootDockerMongodbApplication {
	@Autowired
	private BookRepository bookRepository;
	@PostMapping
	public Book saveBook(@RequestBody Book book){
		return  bookRepository.save(book);
	}

	@GetMapping
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerMongodbApplication.class, args);
	}

}
