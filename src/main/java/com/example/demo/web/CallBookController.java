package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Book;
import com.example.demo.util.R;

@RestController
public class CallBookController
{
	@Autowired
    private RestTemplate restTemplate;
	@RequestMapping("/hello")
	public String hello()
	{
		final String uri = "http://localhost:9090/book/list?name=春&pageSize=1&offset=1";

	    restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);

	    System.out.println(result);
		return result;
	}
	@RequestMapping("/addone")
	public R addone()
	{
		final String uri = "http://localhost:9090/book/add";
		Book b = new Book();
		b.setAuthor("Author wang");
		b.setId(101);
		b.setLeibie("type");
		b.setName("story name");

	    restTemplate = new RestTemplate();
	    R result = restTemplate.postForObject(uri, b, R.class);

	    System.out.println(result.toString());
		return result;
	}

}