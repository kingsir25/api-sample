package com.example.demo.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Article;
import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Empee;
import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import com.example.demo.entity.Vendor;
@Repository
@Transactional
public class EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public void test4() {
    	System.out.println("-- find employees left joined with tasks --");

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
        Root<Empee> employee = query.from(Empee.class);
//        ListJoin<Empee, Task> tasks = employee.join(Empee_.tasks, JoinType.LEFT);
//        query.select(criteriaBuilder.tuple(employee.get(Empee_.name).alias("employeeName"),
//                tasks.get(Task_.supervisor).alias("supervisor")))
//             .distinct(true);
        TypedQuery<Tuple> typedQuery = entityManager.createQuery(query);
        for (Tuple tuple : typedQuery.getResultList()) {
            System.out.printf("name: %s, supervisor: %s%n",
                    tuple.get("employeeName", String.class),
                    tuple.get("supervisor", String.class));
        }
    }

    public void test3() {
//    	Configuration configuration = new Configuration().configure();
//        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
//        registry.applySettings(configuration.getProperties());
//        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
//
//        // builds a session factory from the service registry
//        SessionFactory sessionFactory = configuration
//                .buildSessionFactory(serviceRegistry);
//
//        // obtains the session
//        Session session = sessionFactory.openSession();
    	Session session = getSession();
//    	session.beginTransaction();

    	Category category = new Category("Hibernate Framework");

        Article articleOne = new Article("One-to-One Mapping",
                "One-to-One XML Mapping Tutorial", "Hibernate,One-to-One",
                "Content of One-to-One XML Mapping Tutorial");
        Article articleTwo = new Article("One-to-Many Mapping",
                "One-to-Many XML Mapping Tutorial", "Hibernate,One-to-Many",
                "Content of One-to-Many XML Mapping Tutorial");
        Article articleThree = new Article("Many-to-Many Mapping",
                "Many-to-Many XML Mapping Tutorial", "Hibernate,Many-to-Many",
                "Content of Many-to-Many XML Mapping Tutorial");

        Set<Article> articles = new HashSet<Article>();
        articles.add(articleOne);
        articles.add(articleTwo);
        articles.add(articleThree);

        category.setArticles(articles);

        session.save(category);

        session.getTransaction().commit();
        session.close();
    }
    public void test2() {
    	Session session = getSession();
		Query qry1= session.createQuery("select v.vendorName, c.customerName from Vendor v Left Join v.children c");

		List l1 = qry1.list();
		Iterator it2=l1.iterator();

		while(it2.hasNext())
		{
			Object rows[] = (Object[])it2.next();
			System.out.println(rows[0]+ " -- " +rows[1]);
		}


		Query qry= session.createQuery("from Vendor v join fetch v.children c");

		List l = qry.list();
		System.out.println("The list size is: "+l.size());
		Iterator it=l.iterator();

		while(it.hasNext())
		{
			Vendor rows = (Vendor)it.next();
			System.out.println(rows.getVendorId() + " "+rows.getVendorName());


			 Set s= rows.getChildren();
			   Iterator it1=s.iterator();

			      while(it1.hasNext())
			      {
			    	  Customer c = (Customer) it1.next();
			    	  System.out.println(c.getCustomerName());

			      }


		}


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
