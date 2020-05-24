package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import com.example.demo.entity.Person;
/**
 * 测试类
 * @author 15861
 *
 */
public class TestPerson {

	@Test
	public void save() {

		//1.加载配置文件：
		Configuration configuaration = new Configuration().configure();
		//2.创建一个SessionFatcory:
		SessionFactory sessionfactory =configuaration.buildSessionFactory();
		//3.创建Session对象，Session对象类似于Connection：
		Session session = sessionfactory.openSession();
		//4.开启事务：
		Transaction transaction = session.beginTransaction();
		//5.执行相关操作：
		Person person = new Person();
		person.setName("小明");
		person.setAddress_id("73002");

		List<String> list = new ArrayList<String>();
		list.add("康复路");
		list.add("中山街");
		person.setAddressList(list);
		session.save(person);
		//6.事务提交：
		transaction.commit();
		//7.释放资源：
		session.close();
	}
}