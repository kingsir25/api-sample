package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService
{

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getBookList()
	{
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book findBookById(long id)
	{
		return bookRepository.findById(id);
	}

	@Override
	public void save(Book book)
	{
		bookRepository.save(book);
	}

	@Override
	public void edit(Book book)
	{
		bookRepository.save(book);
	}

	@Transactional
	@Override
	public void delete(long id)
	{
		bookRepository.deleteById(id);
	}

	@Override
	public Page<Book> findAll(Integer page, Integer size, String name)
	{
		// 规格定义
		Specification<Book> specification = new Specification<Book>()
		{

			@Override
			public Predicate toPredicate(Root<Book> root,
					CriteriaQuery<?> query, CriteriaBuilder cb)
			{

				List<Predicate> predicates = new ArrayList<>();
				if (!StringUtils.isEmpty(name))
				{ // 添加查询条件
					Predicate likeName = cb.like(
							root.get("name").as(String.class),
							"%" + name + "%");
					predicates.add(likeName);
				}
				return cb.and(predicates.toArray(new Predicate[0]));
			}
		};
		// 分页信息
		page = page / size;
		Pageable pageable = new PageRequest(page, size); // 页码：前端从1开始，jpa从0开始，做个转换
		// 查询
		return this.bookRepository.findAll(specification, pageable);
	}

}