package com.spring.boot.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.employee.entity.Employee;

public interface EmployeeDaoSpringDataJpaRepository extends JpaRepository<Employee, Integer> {
	// This is for Spring JPA repository
	// In this case we do not need an DAO Implementation file.
	// Spring boot handles all the implementations.
}
