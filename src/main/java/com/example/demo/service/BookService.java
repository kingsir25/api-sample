package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Book;

public interface BookService
{

	public List<Book> getBookList();

	public Book findBookById(long id);

	public void save(Book book);

	public void edit(Book book);

	public void delete(long id);

	/**
	 * 分页查询book
	 * 
	 * @param page
	 * @param size
	 * @param name
	 *            -- 书名 模糊查询
	 * @return
	 */
	Page<Book> findAll(Integer page, Integer size, String name);

}