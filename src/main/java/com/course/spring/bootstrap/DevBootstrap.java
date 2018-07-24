package com.course.spring.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.course.spring.model.Author;
import com.course.spring.model.Book;
import com.course.spring.model.Publisher;
import com.course.spring.repositories.AuthorRepository;
import com.course.spring.repositories.BookRepository;
import com.course.spring.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;	
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();

	}

	private void initData() {
		
		Publisher altas = new Publisher("Altas Books");
		Publisher radix = new Publisher("Radix");

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Desgin", "123456", radix);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		
		
		authorRepository.save(eric);
		publisherRepository.save(radix);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Jhonson");
		Book noEJB = new Book("J2EE Dev without EJB", "987456", altas);
		rod.getBooks().add(noEJB);

		authorRepository.save(rod);
		publisherRepository.save(radix);
		bookRepository.save(noEJB);
	}

}
