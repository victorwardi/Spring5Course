package com.course.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.course.spring.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
