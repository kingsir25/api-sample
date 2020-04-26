package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>
{

	Book findById(long id);

	void deleteById(Long id);

	Page<Book> findAll(Specification<Book> book, Pageable pageable);
}