package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{

	User findById(long id);

	User findByUsername(String username);

	void deleteById(Long id);
}