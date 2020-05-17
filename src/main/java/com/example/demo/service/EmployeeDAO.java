package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Book;
import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
@Repository
@Transactional
public class EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    public void test1() {
    	Session session = getSession();
		@SuppressWarnings("rawtypes")
NativeQuery query = session.createSQLQuery("SELECT * FROM Book;");
		//query.getFirstResult();
		List<Object[]> list = query.list();
		for(Object[] objs : list){
            System.out.println("name:" +objs[1]);
            System.out.println("leibie:"+objs[2]);
            System.out.println("author:"+objs[3]);
        }
		System.out.println(list.size());
		System.out.println(query.getFirstResult());
		Book book = (Book) session.get(Book.class, 1L);
        System.out.println(book);
		System.out.println("ok");
		User user = (User) session.get(User.class, 1L);
        System.out.println(user);

//        String hql = " select new com.example.demo.entity.Employee(id,name) from Employee";
        String hql = " select new com.example.demo.entity.Employee(id,name) from Employee e";

        Query q = session.createQuery(hql);
        List<Employee> list1 = q.list();
        list1.forEach(System.out::println);

//        Transaction t = session.beginTransaction();
//创建数据
//        Employee e1 = new Employee();
//        e1.setName("用户名-01");
//
//        Regular_Employee e2 = new Regular_Employee();
//        e2.setName("yiibai su");
//        e2.setSalary(50002);
//        e2.setBonus(5);
//
//        Contract_Employee e3 = new Contract_Employee();
//        e3.setName("Mina su");
//        e3.setPay_per_hour(1010);
//        e3.setContract_duration("15 hours");
//
//        session.persist(e1);
//        session.persist(e2);
//        session.persist(e3);

//        t.commit();
//        session.close();
        System.out.println("success");
    }
}
