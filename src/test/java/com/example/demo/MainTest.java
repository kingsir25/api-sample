package com.example.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.demo.entity.Contract_Employee;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Regular_Employee;

public class MainTest {
    public static void main(String[] args) {
        // 但在5.1.0版本汇总，hibernate则采用如下新方式获取：
        // 1. 配置类型安全的准服务注册类，这是当前应用的单例对象，不作修改，所以声明为final
        // 在configure("cfg/hibernate.cfg.xml")方法中，如果不指定资源路径，默认在类路径下寻找名为hibernate.cfg.xml的文件
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("src/main/resources/hibernate.cfg.xml").build();
        // 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();

        /**** 上面是配置准备，下面开始我们的数据库操作 ******/
        Session session = sessionFactory.openSession();// 从会话工厂获取一个session

        // creating transaction object
        Transaction t = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setName("用户名-01");

        Regular_Employee e2 = new Regular_Employee();
        e2.setName("yiibai su");
        e2.setSalary(50002);
        e2.setBonus(5);

        Contract_Employee e3 = new Contract_Employee();
        e3.setName("Mina su");
        e3.setPay_per_hour(1010);
        e3.setContract_duration("15 hours");

        session.persist(e1);
        session.persist(e2);
        session.persist(e3);

        t.commit();
        session.close();
        System.out.println("success");
    }
}
