package com.example.demo.web;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.EmployeeDAO;
import com.example.demo.util.BootstrapTable;
import com.example.demo.util.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "PDWF Payment Status Search API")
@RestController
@RequestMapping("book")
public class BookController
{
	@Autowired
    private EntityManager entityManager;

	@Resource
	BookService bookService;
	@Resource
	EmployeeDAO employeeDAO;

	@RequestMapping("/list")
	@ApiOperation("支払状況ステータス検索")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "ユーザ名", defaultValue = "xxx"),
        @ApiImplicitParam(name = "pageSize", value = "ページサイズ", defaultValue = "1", required = true),
        @ApiImplicitParam(name = "offset", value = "件数", defaultValue = "1", required = true)
}
)
	public BootstrapTable list(String name, int pageSize, int offset)
	{
		Page<Book> books = bookService.findAll(offset, pageSize, name);
		return BootstrapTable.turn(books);
	}

	@RequestMapping("/add")
	public R add(@RequestBody Book book)
	{
		bookService.save(book);
		return R.ok();
	}

	@RequestMapping("/update")
	public R update(@RequestBody Book book)
	{
		bookService.edit(book);
		return R.ok();
	}

	@RequestMapping("/delete")
	public R delete(int id)
	{
		System.out.println(id);
		bookService.delete(id);
		return R.ok();
	}
	@RequestMapping("/test")
	public R test()
	{

		Session session = getSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createSQLQuery("select * from book;");
		query.executeUpdate();
		System.out.println(query);
		return R.ok();
	}
	@RequestMapping("/test1")
	public R test1()
	{

		employeeDAO.test1();
		System.out.println("test1");
		return R.ok();
	}
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

}