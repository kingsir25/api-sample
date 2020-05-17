package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>,
                                               JpaSpecificationExecutor<Employee>
{

//	User findById(long id);
//
//	User findByUsername(String username);
//
//	void deleteById(Long id);
}