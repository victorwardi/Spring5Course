package com.course.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.course.spring.model.Author;


public interface AuthorRepository extends CrudRepository<Author, Long>{



}
