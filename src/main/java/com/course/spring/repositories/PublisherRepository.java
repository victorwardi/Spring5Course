package com.course.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.course.spring.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {}
